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

import br.edu.facol.gestaoacademicaweb.pojo.Professor;
import br.edu.facol.gestaoacademicaweb.pojo.Sexo;
import br.edu.facol.gestaoacademicaweb.pojo.Titulacao;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;

@Controller
public class ProfessorController {

	@Resource(name = "professorService")
	private ProfessorService professorService;

	@RequestMapping("/listarProfessores")
	public String listarProfessors(Map<String, Object> map) {
		map.put("professor", new Professor());
		map.put("professorList", professorService.listarProfessors());
		return "professor/listar_professor";
	}

	@RequestMapping("/form_professores")
	public String formProfessors(Map<String, Object> map) {
		map.put("professor", new Professor());
		map.put("sexos", Sexo.values());
		map.put("titulacoes", Titulacao.values());
		return "professor/inserir_professor_form";
	}

	@RequestMapping(value = "/adicionarProfessor", method = RequestMethod.POST)
	public String adicionarProfessor(@ModelAttribute("professor") Professor professor, ModelMap model, HttpServletRequest request) {
		model.addAttribute(professor.getNome());
		model.addAttribute(professor.getMatricula());
		professorService.adicionarProfessor(professor);
		return "redirect:/listarProfessores";
	}
	
	@RequestMapping(value = "/atualizarProfessor", method = RequestMethod.POST)
	public String atualizarprofessor(@ModelAttribute("professor") Professor professor, ModelMap model, HttpServletRequest request) {
		model.addAttribute(professor.getNome());
		model.addAttribute(professor.getMatricula());
		professorService.atualizarProfessor(professor);
		return "redirect:/listarProfessores";
	}
	
	@RequestMapping("/remover/professor/{professorId}")
	public String removerProfessor(@PathVariable("professorId") int id) {
		professorService.removerProfessor(id);
		return "redirect:/listarProfessores";
	}

	@RequestMapping(value = "/update/professor/{professorId}", method = RequestMethod.GET)
	public ModelAndView getprofessor(@PathVariable("professorId") int id) {
		Professor professor = professorService.getProfessorById(id);
		return new ModelAndView("professor/inserir_professor_form", "professor", professor);
	}
}
