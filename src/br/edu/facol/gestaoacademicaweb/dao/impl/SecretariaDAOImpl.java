package br.edu.facol.gestaoacademicaweb.dao.impl;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.SecretariaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;

@Repository
public class SecretariaDAOImpl extends BaseDaoImpl<Secretaria> implements SecretariaDAO {

	public Secretaria autenticar(String matricula, String senha) {
		final String matriculaParam = "matricula";
		final String senhaParam = "senha";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select s from ").append(this.getPersistentClass().getName())
				.append(" s where s.matricula = :").append(matriculaParam)
				.append(" and s.senha = :").append(senhaParam);
		
		Secretaria secretaria = null;
		
		try {
			secretaria = (Secretaria)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(matriculaParam, matricula)
					.setParameter(senhaParam, senha)
					.uniqueResult();
		} catch (Exception e) {
			secretaria = null;
		}
		
		return secretaria;
	}
	
}
