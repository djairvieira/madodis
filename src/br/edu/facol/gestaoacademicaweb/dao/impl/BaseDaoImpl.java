package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.facol.gestaoacademicaweb.dao.BaseDao;
import br.edu.facol.gestaoacademicaweb.pojo.BaseObject;

public abstract class BaseDaoImpl<T extends BaseObject> implements BaseDao<T> {

	@Autowired
	protected SessionFactory sessionFactory;
	protected Transaction transaction;
	protected Session session;
	
	@Override
	public void salvar(T entity) {
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
			session.close();
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
	}

	@Override
	public void atualizar(T entity) {
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(entity);;
			transaction.commit();
			session.close();
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
	}

	@Override
	public void remover(T entity) {
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();
			session.close();
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
		
	}

	@Override
	public abstract void remover(int id);

	@Override
	public abstract T getById(int id);

	@Override
	public abstract List<T> listarTodos();

}
