package br.edu.facol.gestaoacademicaweb.control;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.service.SecretariaService;
import br.edu.facol.gestaoacademicaweb.service.CursoService;

@Controller
public class SecretariaController {

	@Resource(name = "secretariaService")
	private SecretariaService secretariaService;
	
	@Resource(name="cursoService")
	private CursoService cursoService;

	@RequestMapping("/listarSecretarias")
	public String listarSecretarias(Map<String, Object> map) {
		map.put("secretaria", new Secretaria());
		map.put("secretariaList", secretariaService.listarSecretarias());
		return "secretarias/listar_secretaria";
	}

	@RequestMapping("/form_secretarias")
	public String formSecretarias(Map<String, Object> map) {
		map.put("secretaria", new Secretaria());
		map.put("secretariaCursos", cursoService.listaCursos());
		return "secretarias/inserir_secretaria_form";
	}

	@RequestMapping(value = "/adicionarSecretaria", method = RequestMethod.POST)
	public String adicionarSecretaria(@ModelAttribute("secretaria") Secretaria secretaria, ModelMap model, HttpServletRequest request) {
		model.addAttribute(secretaria.getNome());
		model.addAttribute(secretaria.getMatricula());
		secretariaService.adicionarSecretaria(secretaria);
		return "redirect:/listarSecretarias";
	}
}
