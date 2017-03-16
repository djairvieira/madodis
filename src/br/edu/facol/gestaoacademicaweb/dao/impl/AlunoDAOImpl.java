package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.AlunoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aluno;

@Repository
public class AlunoDAOImpl implements AlunoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	private Transaction transaction;
	private Session session;
	
	@Override
	public void adicionarAluno(Aluno aluno) {
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(aluno);
			transaction.commit();
			session.close();
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
	}

	@Override
	public void removerAluno(int id) {
		try{
			session = sessionFactory.openSession();
			Aluno aluno = (Aluno) session.load(Aluno.class, id);
			if(aluno != null){
				transaction = session.beginTransaction();
				session.delete(aluno);
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
	public void atualizaAluno(Aluno aluno) {
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(aluno);;
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
	public List<Aluno> listaAlunos() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();			 
			alunos = session.createQuery("from Aluno ").list(); 					 
			transaction.commit();
			session.close();
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
		return alunos;
	}

	@Override
	public Aluno alunoById(int id) {
		Aluno aluno = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			aluno = (Aluno) session.load(Aluno.class, id);
			transaction.commit();
			session.close();
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
		
		return aluno;
	}

}
