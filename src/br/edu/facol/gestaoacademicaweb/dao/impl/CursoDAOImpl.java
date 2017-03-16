package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.CursoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Curso;

@Repository
public class CursoDAOImpl implements CursoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	private Transaction transaction;
	private Session session;
	
	@Override
	public void adicionarCurso(Curso curso) {
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(curso);
			transaction.commit();
			session.close();
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();			
		}
		
	}

	@Override
	public void removerCurso(int id) {
		try{
			session = sessionFactory.openSession();
			Curso curso = (Curso) session.load(Curso.class, id);
			if (curso != null){
				transaction = session.beginTransaction();
				session.delete(curso);
				transaction.commit();
				session.close();
			}						
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
	}

	@Override
	public void atualizaCurso(Curso curso) {
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(curso);
			transaction.commit();
			session.close();
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listaCursos() {
		List<Curso> cursos = new ArrayList<Curso>();
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			cursos = session.createQuery("from Curso").list();
			transaction.commit();
			session.close();			
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
		return cursos;
	}

	@Override
	public Curso cursoById(int id) {
		Curso curso = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			curso = (Curso) session.load(Curso.class, id);
			transaction.commit();
			session.close();			
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
		return curso;
	}

	
}
