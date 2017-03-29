package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="TB_PROFESSOR")
public class Professor extends Funcionario {

	@Column(name="TITULACAO")
	@Enumerated(value=EnumType.ORDINAL)
	private Titulacao titulacao;
	
	public Professor() {
		super();
	}

	public Titulacao getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(Titulacao titulacao) {
		this.titulacao = titulacao;
	}

	@Override
	public boolean temAcesso(String menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
