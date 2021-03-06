package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Curso;

public interface CursoService {
	public void adicionarCurso(Curso curso);
	public void removerCurso(int id);
	public void atualizarCurso(Curso curso);
	public List<Curso> listaCursos();
	public Curso getCursoById(int id);
}
