package br.edu.facol.gestaoacademicaweb.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_AULA")
public class Aula extends BaseObject {

	@Column(name="ASSUNTO")
	private String assunto;
	
	@OneToOne
	private Disciplina disciplina;
	
	@OneToOne
	private Professor professor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private List<Curso> cursos;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private List<Turma> turmas;
	
	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	@Override
	public String toString() {
		return "Aula [ id = " + getId() + ", assunto = " + getAssunto() + "]";
	}

}
