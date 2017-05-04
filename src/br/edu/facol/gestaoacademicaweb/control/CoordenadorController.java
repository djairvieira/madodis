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

import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;
import br.edu.facol.gestaoacademicaweb.pojo.Sexo;
import br.edu.facol.gestaoacademicaweb.service.CoordenadorService;
import br.edu.facol.gestaoacademicaweb.service.CursoService;

@Controller
public class CoordenadorController {

	@Resource(name = "coordenadorService")
	private CoordenadorService coordenadorService;
	
	@Resource(name="cursoService")
	private CursoService cursoService;

	@RequestMapping("/listarCoordenadores")
	public String listarCoordenadores(Map<String, Object> map) {
		map.put("coordenador", new Coordenador());
		map.put("coordenadorList", coordenadorService.listarCoordenadores());
		return "coordenadores/listar_coordenador";
	}

	@RequestMapping("/form_coordenadores")
	public String formCoordenadors(Map<String, Object> map) {
		map.put("coordenador", new Coordenador());
		map.put("coordenadorCursos", cursoService.listaCursos());
		map.put("sexos", Sexo.values());
		return "coordenadores/inserir_coordenador_form";
	}

	@RequestMapping(value = "/adicionarCoordenador", method = RequestMethod.POST)
	public String adicionarCoordenador(@ModelAttribute("coordenador") Coordenador coordenador, ModelMap model, HttpServletRequest request) {
		model.addAttribute(coordenador.getNome());
		model.addAttribute(coordenador.getMatricula());
		coordenadorService.adicionarCoordenador(coordenador);
		return "redirect:/listarCoordenadores";
	}
	
	@RequestMapping(value = "/atualizarCoordenador", method = RequestMethod.POST)
	public String atualizarCoordenador(@ModelAttribute("coordenador") Coordenador coordenador, ModelMap model, HttpServletRequest request) {
		model.addAttribute(coordenador.getNome());
		model.addAttribute(coordenador.getMatricula());
		coordenadorService.atualizarCoordenador(coordenador);
		return "redirect:/listarCoordenadores";
	}
	
	@RequestMapping("/remover/coordenador/{coordenadorId}")
	public String removerCoordenador(@PathVariable("coordenadorId") int id) {
		coordenadorService.removerCoordenador(id);
		return "redirect:/listarCoordenadores";
	}

	@RequestMapping(value = "/update/coordenador/{coordenadorId}", method = RequestMethod.GET)
	public ModelAndView getCoordenador(@PathVariable("coordenadorId") int id) {
		Coordenador coordenador = coordenadorService.getCoordenadorById(id);
		return new ModelAndView("coordenadores/inserir_coordenador_form", "coordenador", coordenador);
	}
	
}
