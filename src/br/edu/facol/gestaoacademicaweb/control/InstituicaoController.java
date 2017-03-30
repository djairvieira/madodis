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

import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.service.InstituicaoService;

@Controller
public class InstituicaoController {

	@Resource(name = "instituicaoService")
	private InstituicaoService instituicaoService;

	@RequestMapping("/listarInstituicoes")
	public String listarInstituicoes(Map<String, Object> map) {
		map.put("instituicao", new Instituicao());
		map.put("instituicaoList", instituicaoService.listarInstituicoes());
		return "instituicao/listar_instituicao";
	}

	@RequestMapping("/form_instituicao")
	public String formInstituicoes(Map<String, Object> map) {
		map.put("instituicao", new Instituicao());
		return "instituicao/form_instituicao";
	}

	@RequestMapping("/remover/instituicao/{instituicaoId}")
	public String removerInstituicao(@PathVariable("instituicaoId") int id) {
		instituicaoService.removerInstituicao(id);
		return "redirect:/listarInstituicoes";
	}

	@RequestMapping(value = "/update/instituicao/{instituicaoId}", method = RequestMethod.GET)
	public ModelAndView getInstituicao(@PathVariable("instituicaoId") int id) {
		Instituicao instituicao = instituicaoService.getInstituicaoById(id);
		return new ModelAndView("instituicao/form_instituicao", "instituicao", instituicao);
	}

	@RequestMapping(value = "/adicionarInstituicao", method = RequestMethod.POST)
	public String adicionarInstituicao(@ModelAttribute("instituicao") Instituicao instituicao, ModelMap model,
			HttpServletRequest request) {
		model.addAttribute(instituicao.getNomeFantasia());
		model.addAttribute(instituicao.getNomeEmpresarial());
		model.addAttribute(instituicao.getCnpj());
		model.addAttribute(instituicao.getInscricaoEstadual());
		model.addAttribute(instituicao.getEndereco());
		model.addAttribute(instituicao.getTelefone());
		instituicaoService.adicionarInstituicao(instituicao);
		return "redirect:/listarInstituicoes";
	}
	
	@RequestMapping(value = "/atualizarInstituicao", method = RequestMethod.POST)
	public String atualizarInstituicao(@ModelAttribute("instituicao") Instituicao instituicao, ModelMap model,
			HttpServletRequest request) {
		model.addAttribute(instituicao.getNomeFantasia());
		model.addAttribute(instituicao.getNomeEmpresarial());
		model.addAttribute(instituicao.getCnpj());
		model.addAttribute(instituicao.getInscricaoEstadual());
		model.addAttribute(instituicao.getEndereco());
		model.addAttribute(instituicao.getTelefone());
		instituicaoService.atualizarInstituicao(instituicao);
		return "redirect:/listarInstituicoes";
	}
}
