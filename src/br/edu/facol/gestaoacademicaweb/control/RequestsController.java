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
import br.edu.facol.gestaoacademicaweb.pojo.Curso;
import br.edu.facol.gestaoacademicaweb.pojo.Docente;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;
import br.edu.facol.gestaoacademicaweb.service.AlunoService;
import br.edu.facol.gestaoacademicaweb.service.CursoService;
import br.edu.facol.gestaoacademicaweb.service.DocenteService;
import br.edu.facol.gestaoacademicaweb.service.InstituicaoService;

@Controller
public class RequestsController {

	@Resource(name="docenteService")
	private DocenteService docenteService;
	
	@Resource(name="alunoService")
	private AlunoService alunoService;

	@Resource(name="cursoService")
	private CursoService cursoService;
	
	@Resource(name="instituicaoService")
	private InstituicaoService instituicaoService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {		
		return "index";
	}
	
	@RequestMapping("/home")
	public String inicial(){
		return "index";
	}

//Configura��es referentes a Docentes ---------------------------------------------	
	@RequestMapping("/listarDocentes")
	public String listarDocentes(Map<String, Object> map){
			map.put("docente", new Docente());
			map.put("docenteList", docenteService.listarDocentes());		
		return "docentes/listar_docente";
	}
	
	@RequestMapping("/form")
	public String form(Map<String, Object> map){
			map.put("docente", new Docente());
		return "docentes/inserir_docente_form";
	}
	
	@RequestMapping(value="/adicionar", method=RequestMethod.POST)
	public String adicionarDocente(@ModelAttribute("docente") Docente docente, ModelMap model, HttpServletRequest request){		
			model.addAttribute("nome", docente.getNome());
			model.addAttribute("matricula", docente.getMatricula());
			model.addAttribute("titulacao", docente.getTitulacao());
			docenteService.adicionarDocente(docente);
		return "redirect:/listarDocentes";
	}
	
	@RequestMapping(value="/update/{docenteId}", method=RequestMethod.GET)
	public ModelAndView updateForm(@PathVariable("docenteId") int id){			
			Docente docente = docenteService.docenteById(id);
		return new ModelAndView("atualizar_docente_form","docente",docente);
	}
	
	@RequestMapping(value="/atualizar", method=RequestMethod.PUT)
	public String atualizarDocente(final Docente docente){
			docenteService.atualizaDocente(docente);
		return "redirect:/listarDocentes";
	}
	
	@RequestMapping("/remover/{docenteId}")
	public String removerDocente(@PathVariable("docenteId") int id){
			docenteService.removerDocente(id);
		return "redirect:/listarDocentes";
	}

//Configura��es referentes a Alunos ---------------------------------------------	
	@RequestMapping("/listarAlunos")
	public String listarAlunos(Map<String, Object> map){
			map.put("aluno", new Aluno());
			map.put("alunoList", alunoService.listarAlunos());		
		return "alunos/listar_aluno";
	}
	
	@RequestMapping("/form_alunos")
	public String formAlunos(Map<String, Object> map){
		map.put("aluno", new Aluno());
		map.put("alunoCursos", cursoService.listaCursos());
		return "alunos/inserir_aluno_form";
	}
	
	@RequestMapping(value="/adicionarAluno", method=RequestMethod.POST)
	public String adicionarAluno(@ModelAttribute("aluno") Aluno aluno, ModelMap model, HttpServletRequest request){
		model.addAttribute(aluno.getNome());
		model.addAttribute(aluno.getMatricula());
		model.addAttribute(aluno.getId_curso());
		alunoService.adicionarAluno(aluno);
		return "redirect:/listarAlunos";
	}
	
	//Configura��es referentes a Instituicao ---------------------------------------------	
		@RequestMapping("/listarInstituicoes")
		public String listarInstituicoes(Map<String, Object> map){
				map.put("instituicao", new Instituicao());
				map.put("instituicaoList", instituicaoService.listarInstituicoes());		
			return "instituicao/listar_instituicao";
		}
		
		@RequestMapping("/form_instituicao")
		public String formInstituicoes(Map<String, Object> map){
			map.put("instituicao", new Instituicao());
			return "instituicao/inserir_instituicao_form";
		}
		
		@RequestMapping("/remover/instituicao/{instituicaoId}")
		public String removerInstituicao(@PathVariable("instituicaoId") int id){
				instituicaoService.removerInstituicao(id);
			return "redirect:/listarInstituicoes";
		}
		
		@RequestMapping("/update/instituicao/{instituicaoId}")
		public String atualizarInstituicao(@PathVariable("instituicaoId") int id){
				instituicaoService.getInstituicaoById(id);
			return "redirect:/form_instituicao";
		}
		
		@RequestMapping(value="/adicionarInstituicao", method=RequestMethod.POST)
		public String adicionarInstituicao(@ModelAttribute("instituicao") Instituicao instituicao, 
				ModelMap model, HttpServletRequest request){
			model.addAttribute(instituicao.getNomeFantasia());
			model.addAttribute(instituicao.getNomeEmpresarial());
			model.addAttribute(instituicao.getCnpj());
			model.addAttribute(instituicao.getInscricaoEstadual());
			model.addAttribute(instituicao.getEndereco());
			model.addAttribute(instituicao.getTelefone());
			instituicaoService.adicionarInstituicao(instituicao);
			return "redirect:/listarInstituicoes";
		}
	

//Configura��es referentes a Cursos ---------------------------------------------	
	@RequestMapping("/form_cursos")
	public String formCursos(Map<String, Object> map){
		map.put("curso", new Curso());		
		return "cursos/inserir_curso_form";
	}

	@RequestMapping("/listarCursos")
	public String listarCursos(Map<String, Object> map){
		map.put("curso", new Curso());
		map.put("cursoList", cursoService.listaCursos());
		return "cursos/listar_curso";
	}
	
	@RequestMapping(value="/adicionarCurso", method=RequestMethod.POST)
	public String adicionarCurso(@ModelAttribute("curso") Curso curso, ModelMap model, HttpServletRequest request){		
			model.addAttribute("nome", curso.getNome());
			cursoService.adicionarCurso(curso);
		return "redirect:/listarCursos";
	}

}
