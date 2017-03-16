package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_DOCENTE")
public class Docente extends BaseObject {
	
	@Column(name="NOME")
	public String nome;
	
	@Column(name="MATRICULA")
	public String matricula;
	
	@Column(name="TITULACAO")
	public String titulacao;

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

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	@Override
	public String toString() {
		return "Docentes [id=" + getId() + ", nome=" + nome + ", matricula=" + matricula + ", titulacao=" + titulacao + "]";
	}
	
}
