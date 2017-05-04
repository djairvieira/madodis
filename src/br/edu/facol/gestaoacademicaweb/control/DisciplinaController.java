package br.edu.facol.gestaoacademicaweb.control;

import java.util.HashMap;
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

import br.edu.facol.gestaoacademicaweb.pojo.Disciplina;
import br.edu.facol.gestaoacademicaweb.service.DisciplinaService;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;

@Controller
public class DisciplinaController {

	@Resource(name = "disciplinaService")
	private DisciplinaService disciplinaService;
	
	@Resource(name = "professorService")
	private ProfessorService professorService;

	@RequestMapping("/listarDisciplinas")
	public String listarDisciplinas(Map<String, Object> map) {
		map.put("disciplina", new Disciplina());
		map.put("disciplinaList", disciplinaService.listarDisciplinas());
		return "disciplinas/listar_disciplina";
	}

	@RequestMapping("/form_disciplinas")
	public String formDisciplinas(Map<String, Object> map) {
		map.put("disciplina", new Disciplina());
		map.put("professor", professorService.listarProfessors());
		return "disciplinas/inserir_disciplina_form";
	}

	@RequestMapping(value = "/adicionarDisciplina", method = RequestMethod.POST)
	public String adicionarDisciplina(@ModelAttribute("disciplina") Disciplina disciplina, ModelMap model, HttpServletRequest request) {
		model.addAttribute(disciplina.getNome());
		model.addAttribute(disciplina.getDescricao());
		disciplinaService.adicionarDisciplina(disciplina);
		return "redirect:/listarDisciplinas";
	}
	
	@RequestMapping(value = "/atualizarDisciplina", method = RequestMethod.POST)
	public String atualizarDisciplina(@ModelAttribute("disciplina") Disciplina disciplina, ModelMap model, HttpServletRequest request) {
		model.addAttribute(disciplina.getNome());
		model.addAttribute(disciplina.getDescricao());
		disciplinaService.atualizarDisciplina(disciplina);
		return "redirect:/listarDisciplinas";
	}
	
	@RequestMapping("/remover/disciplina/{disciplinaId}")
	public String removerDisciplina(@PathVariable("disciplinaId") int id) {
		disciplinaService.removerDisciplina(id);
		return "redirect:/listarDisciplinas";
	}

	@RequestMapping(value = "/update/disciplina/{disciplinaId}", method = RequestMethod.GET)
	public ModelAndView getDisciplina(@PathVariable("disciplinaId") int id) {
		Disciplina disciplina = disciplinaService.getDisciplinaById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("disciplina", disciplina);
		map.put("professor", professorService.listarProfessors());
		return new ModelAndView("disciplina/inserir_disciplina_form", map);
	}
	
}
