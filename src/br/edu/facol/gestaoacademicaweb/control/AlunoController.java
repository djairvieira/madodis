package br.edu.facol.gestaoacademicaweb.control;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.service.AlunoService;
import br.edu.facol.gestaoacademicaweb.service.CursoService;

@Controller
public class AlunoController {

	@Resource(name = "alunoService")
	private AlunoService alunoService;
	
	@Resource(name="cursoService")
	private CursoService cursoService;

	@RequestMapping("/listarAlunos")
	public String listarAlunos(Map<String, Object> map) {
		map.put("aluno", new Aluno());
		map.put("alunoList", alunoService.listarAlunos());
		return "alunos/listar_aluno";
	}

	@RequestMapping("/form_alunos")
	public String formAlunos(Map<String, Object> map) {
		map.put("aluno", new Aluno());
		map.put("alunoCursos", cursoService.listaCursos());
		return "alunos/inserir_aluno_form";
	}

	@RequestMapping(value = "/adicionarAluno", method = RequestMethod.POST)
	public String adicionarAluno(@ModelAttribute("aluno") Aluno aluno, ModelMap model, HttpServletRequest request) {
		model.addAttribute(aluno.getNome());
		model.addAttribute(aluno.getMatricula());
		alunoService.adicionarAluno(aluno);
		return "redirect:/listarAlunos";
	}
}
