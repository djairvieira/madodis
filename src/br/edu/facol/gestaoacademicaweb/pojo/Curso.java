package br.edu.facol.gestaoacademicaweb.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_CURSO")
public class Curso extends BaseObject {

	@Column(name="NOME")
	private String nome;

	@OneToMany(mappedBy="curso")
	private Set<Aluno> alunos;
	
	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Curso [id=" + getId() + ", nome=" + nome + "]";
	}
	
}