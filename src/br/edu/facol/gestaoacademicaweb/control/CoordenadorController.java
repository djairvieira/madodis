package br.edu.facol.gestaoacademicaweb.control;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;
import br.edu.facol.gestaoacademicaweb.service.CoordenadorService;
import br.edu.facol.gestaoacademicaweb.service.CursoService;

@Controller
public class CoordenadorController {

	@Resource(name = "coordenadorService")
	private CoordenadorService coordenadorService;
	
	@Resource(name="cursoService")
	private CursoService cursoService;

	@RequestMapping("/listarCoordenadores")
	public String listarCoordenadors(Map<String, Object> map) {
		map.put("coordenador", new Coordenador());
		map.put("coordenadorList", coordenadorService.listarCoordenadors());
		return "coordenadores/listar_coordenador";
	}

	@RequestMapping("/form_coordenadores")
	public String formCoordenadors(Map<String, Object> map) {
		map.put("coordenador", new Coordenador());
		map.put("coordenadorCursos", cursoService.listaCursos());
		return "coordenadors/inserir_coordenador_form";
	}

	@RequestMapping(value = "/adicionarCoordenador", method = RequestMethod.POST)
	public String adicionarCoordenador(@ModelAttribute("coordenador") Coordenador coordenador, ModelMap model, HttpServletRequest request) {
		model.addAttribute(coordenador.getNome());
		model.addAttribute(coordenador.getMatricula());
		coordenadorService.adicionarCoordenador(coordenador);
		return "redirect:/listarCoordenadores";
	}
}
