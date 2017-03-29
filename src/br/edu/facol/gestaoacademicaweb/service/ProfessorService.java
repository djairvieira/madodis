package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Professor;

public interface ProfessorService {
	
	public void adicionarProfessor(Professor aluno);
	public void removerProfessor(int id);
	public void atualizaProfessor(Professor aluno);
	public List<Professor> listarProfessors();
	public Professor getProfessorById(int id);
	
}
