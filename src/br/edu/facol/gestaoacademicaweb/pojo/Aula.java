package br.edu.facol.gestaoacademicaweb.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TB_AULA")
public class Aula extends BaseObject {

	@Column(name="ASSUNTO")
	private String assunto;
	
	@Column(name="DATA_AULA")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String dataAula;
	
	@OneToOne
	private Disciplina disciplina;
	
	@OneToOne
	private Professor professor;
	
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

	public String getDataAula() {
		return dataAula;
	}

	public void setDataAula(String dataAula) {
		this.dataAula = dataAula;
	}

	@Override
	public String toString() {
		return "Aula [ id = " + getId() + ", assunto = " + getAssunto() + "]";
	}

}
