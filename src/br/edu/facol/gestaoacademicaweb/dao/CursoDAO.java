package br.edu.facol.gestaoacademicaweb.dao;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Curso;

public interface CursoDAO {
	public void adicionarCurso(Curso curso);
	public void removerCurso(int id);
	public void atualizaCurso(Curso curso);
	public List<Curso> listaCursos();
	public Curso cursoById(int id);
}
