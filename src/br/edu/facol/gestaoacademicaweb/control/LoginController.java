package br.edu.facol.gestaoacademicaweb.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;
import br.edu.facol.gestaoacademicaweb.pojo.Professor;
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.service.AlunoService;
import br.edu.facol.gestaoacademicaweb.service.CoordenadorService;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;
import br.edu.facol.gestaoacademicaweb.service.SecretariaService;

@Controller
public class LoginController {
	
	@Resource(name = "alunoService")
	private AlunoService alunoService;
	
	@Resource(name = "coordenadorService")
	private CoordenadorService coordenadorService;
	
	@Resource(name = "professorService")
	private ProfessorService professorService;
	
	@Resource(name = "secretariaService")
	private SecretariaService secretariaService;

	@RequestMapping("/login/entrar")
	public ModelAndView entrar(@RequestParam(name="matricula") String matricula, 
						 @RequestParam(name="senha") String senha) {
		
		Aluno aluno = alunoService.autenticarAluno(matricula, senha);
		if (aluno != null) {
			return new ModelAndView("index_aluno", "aluno", aluno);
		}
		
		Coordenador coordenador = coordenadorService.autenticarCoordenador(matricula, senha);
		if (coordenador != null) {
			return new ModelAndView("index_coordenador", "coordenador", coordenador);
		}
		
		Professor professor = professorService.autenticarProfessor(matricula, senha);
		if (professor != null) {
			return new ModelAndView("index_professor", "professor", professor);
		}
		
		Secretaria secretaria = secretariaService.autenticarSecretaria(matricula, senha);
		if (secretaria != null) {
			return new ModelAndView("index_secretaria", "secretaria", secretaria);
		}
		
		if (matricula.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
			return new ModelAndView("index_administrador");
		}
		
		return new ModelAndView("login_error");
	}

}
