package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.DocenteDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Docente;

@Repository
public class DocenteDAOImpl implements DocenteDAO{

	@Autowired
	private SessionFactory sessionFactory;
	private Transaction tx;
	private Session session;	
	
	public void adicionarDocente(Docente docente) {				
		try {											
			session = sessionFactory.openSession();
			tx = session.beginTransaction();			
			session.save(docente);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
	}

	public void removerDocente(int id) {
		try{
			session = sessionFactory.openSession();
			Docente docente = (Docente) session.load(Docente.class, id);
			if(docente != null){				
				tx = session.beginTransaction();
				session.delete(docente);
				tx.commit();
				session.close();
			}
		}catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Docente> listaDocentes() {	
		List<Docente> docentes = new ArrayList<Docente>();
		try{
			session = sessionFactory.openSession();			
			tx = session.beginTransaction();
			docentes = session.createQuery("from Docente").list();
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}			
		return docentes;
	}

	@Override
	public void atualizaDocente(Docente docente) {		
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(docente);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
	}

	@Override
	public Docente docenteById(int id) {
		Docente docente = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			docente = (Docente) session.load(Docente.class, id);			
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}		
		return docente;
	}

}
