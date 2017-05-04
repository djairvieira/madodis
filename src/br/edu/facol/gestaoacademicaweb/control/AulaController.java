package br.edu.facol.gestaoacademicaweb.control;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.pojo.Sexo;
import br.edu.facol.gestaoacademicaweb.service.AulaService;

@Controller
public class AulaController {

	@Resource(name = "aulaService")
	private AulaService aulaService;

	@RequestMapping("/listarAulas")
	public String listarAulas(Map<String, Object> map) {
		map.put("aula", new Aula());
		map.put("aulaList", aulaService.listarAulas());
		return "aulas/listar_aula";
	}

	@RequestMapping("/form_aulas")
	public String formAulas(Map<String, Object> map) {
		map.put("aula", new Aula());
		map.put("sexos", Sexo.values());
		return "aulas/inserir_aula_form";
	}

	@RequestMapping(value = "/adicionarAula", method = RequestMethod.POST)
	public String adicionarAula(@ModelAttribute("aula") Aula aula, ModelMap model, HttpServletRequest request) {
		model.addAttribute(aula.getAssunto());
		model.addAttribute(aula.getDataAula());
		aulaService.adicionarAula(aula);
		return "redirect:/listarAulas";
	}
	
	@RequestMapping(value = "/atualizarAula", method = RequestMethod.POST)
	public String atualizarAula(@ModelAttribute("aula") Aula aula, ModelMap model, HttpServletRequest request) {
		model.addAttribute(aula.getAssunto());
		model.addAttribute(aula.getDataAula());
		aulaService.atualizarAula(aula);
		return "redirect:/listarAulas";
	}
	
	@RequestMapping("/remover/aula/{aulaId}")
	public String removerAula(@PathVariable("aulaId") int id) {
		aulaService.removerAula(id);
		return "redirect:/listarAulas";
	}

	@RequestMapping(value = "/update/aula/{aulaId}", method = RequestMethod.GET)
	public ModelAndView getAula(@PathVariable("aulaId") int id) {
		Aula aula = aulaService.getAulaById(id);
		return new ModelAndView("aula/inserir_aula_form", "aula", aula);
	}
	
}
