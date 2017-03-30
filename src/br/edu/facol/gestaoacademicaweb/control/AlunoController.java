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

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.Sexo;
import br.edu.facol.gestaoacademicaweb.service.AlunoService;

@Controller
public class AlunoController {

	@Resource(name = "alunoService")
	private AlunoService alunoService;

	@RequestMapping("/listarAlunos")
	public String listarAlunos(Map<String, Object> map) {
		map.put("aluno", new Aluno());
		map.put("alunoList", alunoService.listarAlunos());
		return "alunos/listar_aluno";
	}

	@RequestMapping("/form_alunos")
	public String formAlunos(Map<String, Object> map) {
		map.put("aluno", new Aluno());
		map.put("sexos", Sexo.values());
		return "alunos/inserir_aluno_form";
	}

	@RequestMapping(value = "/adicionarAluno", method = RequestMethod.POST)
	public String adicionarAluno(@ModelAttribute("aluno") Aluno aluno, ModelMap model, HttpServletRequest request) {
		model.addAttribute(aluno.getNome());
		model.addAttribute(aluno.getMatricula());
		alunoService.adicionarAluno(aluno);
		return "redirect:/listarAlunos";
	}
	
	@RequestMapping(value = "/atualizarAluno", method = RequestMethod.POST)
	public String atualizarAluno(@ModelAttribute("aluno") Aluno aluno, ModelMap model, HttpServletRequest request) {
		model.addAttribute(aluno.getNome());
		model.addAttribute(aluno.getMatricula());
		alunoService.atualizarAluno(aluno);
		return "redirect:/listarAlunos";
	}
	
	@RequestMapping("/remover/aluno/{alunoId}")
	public String removerAluno(@PathVariable("alunoId") int id) {
		alunoService.removerAluno(id);
		return "redirect:/listarAlunos";
	}

	@RequestMapping(value = "/update/aluno/{alunoId}", method = RequestMethod.GET)
	public ModelAndView getAluno(@PathVariable("alunoId") int id) {
		Aluno aluno = alunoService.getAlunoById(id);
		return new ModelAndView("aluno/inserir_aluno_form", "aluno", aluno);
	}
	
}
