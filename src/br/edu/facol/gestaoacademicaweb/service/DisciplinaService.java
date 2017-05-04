package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Disciplina;

public interface DisciplinaService {
	
	public void adicionarDisciplina(Disciplina disciplina);
	public void removerDisciplina(int id);
	public void atualizarDisciplina(Disciplina disciplina);
	public List<Disciplina> listarDisciplinas();
	public Disciplina getDisciplinaById(int id);
	
}
