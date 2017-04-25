package br.edu.facol.gestaoacademicaweb.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_CURSO")
public class Curso extends BaseObject {

	@Column(name="NOME")
	private String nome;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Disciplina> disciplinas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public String toString() {
		return "Curso [id=" + getId() + ", nome=" + nome + "]";
	}
	
}
