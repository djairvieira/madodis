package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Aluno;

public interface AlunoService {
	
	public void adicionarAluno(Aluno aluno);
	public void removerAluno(int id);
	public void atualizarAluno(Aluno aluno);
	public List<Aluno> listarAlunos();
	public Aluno getAlunoById(int id);
	
}
