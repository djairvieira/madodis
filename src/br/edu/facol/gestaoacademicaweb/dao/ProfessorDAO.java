package br.edu.facol.gestaoacademicaweb.dao;

import br.edu.facol.gestaoacademicaweb.pojo.Professor;

public interface ProfessorDAO extends BaseDao<Professor> {
	
	public Professor autenticar(String matricula, String senha);
	
}
