package br.edu.facol.gestaoacademicaweb.control;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.facol.gestaoacademicaweb.pojo.Professor;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;
import br.edu.facol.gestaoacademicaweb.service.CursoService;

@Controller
public class ProfessorController {

	@Resource(name = "professorService")
	private ProfessorService professorService;
	
	@Resource(name="cursoService")
	private CursoService cursoService;

	@RequestMapping("/listarProfessors")
	public String listarProfessors(Map<String, Object> map) {
		map.put("professor", new Professor());
		map.put("professorList", professorService.listarProfessors());
		return "professors/listar_professor";
	}

	@RequestMapping("/form_professors")
	public String formProfessors(Map<String, Object> map) {
		map.put("professor", new Professor());
		map.put("professorCursos", cursoService.listaCursos());
		return "professors/inserir_professor_form";
	}

	@RequestMapping(value = "/adicionarProfessor", method = RequestMethod.POST)
	public String adicionarProfessor(@ModelAttribute("professor") Professor professor, ModelMap model, HttpServletRequest request) {
		model.addAttribute(professor.getNome());
		model.addAttribute(professor.getMatricula());
		professorService.adicionarProfessor(professor);
		return "redirect:/listarProfessors";
	}
}
