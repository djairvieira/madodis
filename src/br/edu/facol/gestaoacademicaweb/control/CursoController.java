package br.edu.facol.gestaoacademicaweb.control;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.facol.gestaoacademicaweb.pojo.Curso;
import br.edu.facol.gestaoacademicaweb.service.CursoService;

@Controller
public class CursoController {

	@Resource(name = "cursoService")
	private CursoService cursoService;

	@RequestMapping("/form_cursos")
	public String formCursos(Map<String, Object> map) {
		map.put("curso", new Curso());
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

}
