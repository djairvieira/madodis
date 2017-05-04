package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_DISCIPLINA")
public class Disciplina extends BaseObject {

	@Column(name="NOME")
	private String nome;
	
	@Column(name="SIGLA")
	private String sigla;
	
	@Column(name="CREDITOS")
	private int creditos;
	
	@Column(name="CARGA_HORARIA")
	private int cargaHoraria;
	
	@Column(name="MODULO_PERTENCENTE")
	private int moduloPertencente;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="REQUISITOS")
	private String requisitos;
	
	@OneToOne
	private Professor professor;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private PlanoDeEnsino planoDeEnsino;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public PlanoDeEnsino getPlanoDeEnsino() {
		return planoDeEnsino;
	}

	public void setPlanoDeEnsino(PlanoDeEnsino planoDeEnsino) {
		this.planoDeEnsino = planoDeEnsino;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getModuloPertencente() {
		return moduloPertencente;
	}

	public void setModuloPertencente(int moduloPertencente) {
		this.moduloPertencente = moduloPertencente;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return " Disciplina [ id = " + getId() + ", nome = " + getNome() + "]";
	}

}
