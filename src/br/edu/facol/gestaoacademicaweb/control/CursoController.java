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

import br.edu.facol.gestaoacademicaweb.pojo.Curso;
import br.edu.facol.gestaoacademicaweb.service.CursoService;
import br.edu.facol.gestaoacademicaweb.service.InstituicaoService;

@Controller
public class CursoController {

	@Resource(name = "cursoService")
	private CursoService cursoService;
	
	@Resource(name = "instituicaoService")
	private InstituicaoService instituicaoService;

	@RequestMapping("/form_cursos")
	public String formCursos(Map<String, Object> map) {
		map.put("curso", new Curso());
		map.put("instituicoes", instituicaoService.listarInstituicoes());
		return "cursos/inserir_curso_form";
	}

	@RequestMapping("/listarCursos")
	public String listarCursos(Map<String, Object> map) {
		map.put("curso", new Curso());
		map.put("cursoList", cursoService.listaCursos());
		return "cursos/listar_curso";
	}

	@RequestMapping(value = "/adicionarCurso", method = RequestMethod.POST)
	public String adicionarCurso(@ModelAttribute("curso") Curso curso, ModelMap model, HttpServletRequest request) {
		model.addAttribute("nome", curso.getNome());
		cursoService.adicionarCurso(curso);
		return "redirect:/listarCursos";
	}
	
	@RequestMapping(value = "/atualizarCurso", method = RequestMethod.POST)
	public String atualizarCurso(@ModelAttribute("curso") Curso curso, ModelMap model, HttpServletRequest request) {
		model.addAttribute(curso.getNome());
		model.addAttribute(curso.getSigla());
		cursoService.atualizarCurso(curso);
		return "redirect:/listarCursos";
	}
	
	@RequestMapping("/remover/curso/{cursoId}")
	public String removerCurso(@PathVariable("cursoId") int id) {
		cursoService.removerCurso(id);
		return "redirect:/listarCursos";
	}

	@RequestMapping(value = "/update/curso/{cursoId}", method = RequestMethod.GET)
	public ModelAndView getCurso(@PathVariable("cursoId") int id) {
		Curso curso = cursoService.getCursoById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("curso", curso);
		map.put("instituicoes", instituicaoService.listarInstituicoes());
		return new ModelAndView("curso/inserir_curso_form", map);
	}

}
