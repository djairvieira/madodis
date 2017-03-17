package br.edu.facol.gestaoacademicaweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.InstituicaoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Instituicao;

@Repository
public class InstituicaoDAOImpl extends BaseDaoImpl<Instituicao> implements InstituicaoDAO {

	@Override
	public void remover(int id) {
		try{
			session = sessionFactory.openSession();
			Instituicao instituicao = (Instituicao) session.load(Instituicao.class, id);
			if(instituicao != null){
				transaction = session.beginTransaction();
				session.delete(instituicao);
				transaction.commit();
				session.close();
			}
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Instituicao> listarTodos() {
		List<Instituicao> instituicoes = new ArrayList<Instituicao>();
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();			 
			instituicoes = session.createQuery("from Instituicao ").list(); 					 
			transaction.commit();
			session.close();
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
		return instituicoes;
	}

	@Override
	public Instituicao getById(int id) {
		Instituicao instituicao = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			instituicao = (Instituicao) session.load(Instituicao.class, id);
			transaction.commit();
			session.close();
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
		
		return instituicao;
	}

}
