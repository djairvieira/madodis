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

import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.pojo.Sexo;
import br.edu.facol.gestaoacademicaweb.service.SecretariaService;

@Controller
public class SecretariaController {

	@Resource(name = "secretariaService")
	private SecretariaService secretariaService;

	@RequestMapping("/listarSecretarias")
	public String listarSecretarias(Map<String, Object> map) {
		map.put("secretaria", new Secretaria());
		map.put("secretariaList", secretariaService.listarSecretarias());
		return "secretaria/listar_secretaria";
	}

	@RequestMapping("/form_secretarias")
	public String formSecretarias(Map<String, Object> map) {
		map.put("secretaria", new Secretaria());
		map.put("sexos", Sexo.values());
		return "secretaria/inserir_secretaria_form";
	}

	@RequestMapping(value = "/adicionarSecretaria", method = RequestMethod.POST)
	public String adicionarSecretaria(@ModelAttribute("secretaria") Secretaria secretaria, ModelMap model, HttpServletRequest request) {
		model.addAttribute(secretaria.getNome());
		model.addAttribute(secretaria.getMatricula());
		secretariaService.adicionarSecretaria(secretaria);
		return "redirect:/listarSecretarias";
	}
	
	@RequestMapping(value = "/atualizarSecretaria", method = RequestMethod.POST)
	public String atualizarSecretaria(@ModelAttribute("secretaria") Secretaria secretaria, ModelMap model, HttpServletRequest request) {
		model.addAttribute(secretaria.getNome());
		model.addAttribute(secretaria.getMatricula());
		secretariaService.atualizarSecretaria(secretaria);
		return "redirect:/listarSecretarias";
	}
	
	@RequestMapping("/remover/secretaria/{secretariaId}")
	public String removerSecretaria(@PathVariable("secretariaId") int id) {
		secretariaService.removerSecretaria(id);
		return "redirect:/listarSecretarias";
	}

	@RequestMapping(value = "/update/secretaria/{secretariaId}", method = RequestMethod.GET)
	public ModelAndView getSecretaria(@PathVariable("secretariaId") int id) {
		Secretaria secretaria = secretariaService.getSecretariaById(id);
		return new ModelAndView("secretaria/inserir_secretaria_form", "secretaria", secretaria);
	}
}
