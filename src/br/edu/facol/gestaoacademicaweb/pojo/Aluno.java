package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_ALUNO")
public class Aluno extends BaseObject {

	@Column(name="NOME")
	private String nome;
	
	@Column(name="MATRICULA")
	private String matricula;
		
	@ManyToOne
	@JoinColumn(name="id_curso", nullable=false, insertable=false, updatable=false)
	private Curso curso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public Curso getId_curso() {
		return curso;
	}

	public void setId_curso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + getId() + ", nome=" + nome + ", matricula=" + matricula + ", id_curso=" + curso.getId() + "]";
	}
	
}
