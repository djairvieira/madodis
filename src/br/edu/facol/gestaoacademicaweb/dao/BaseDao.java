package br.edu.facol.gestaoacademicaweb.dao;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.BaseObject;

public interface BaseDao<T extends BaseObject> {

	void salvar(T entity);
	
	void atualizar(T entity);
	
	void remover(T entity);
	
	boolean remover(int id);
	
	T getById(int id);
	
	List<T> listarTodos();
	
}
