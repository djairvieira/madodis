package br.edu.facol.gestaoacademicaweb.dao;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;

public interface AlunoDAO {
	public void adicionarAluno(Aluno aluno);
	public void removerAluno(int id);
	public void atualizaAluno(Aluno aluno);
	public List<Aluno> listaAlunos();
	public Aluno alunoById(int id);
}
