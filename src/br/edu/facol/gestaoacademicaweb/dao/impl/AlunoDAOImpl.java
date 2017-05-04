package br.edu.facol.gestaoacademicaweb.dao.impl;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.AlunoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aluno;

@Repository
public class AlunoDAOImpl extends BaseDaoImpl<Aluno> implements AlunoDAO {

	public Aluno autenticar(String matricula, String senha) {
		final String matriculaParam = "matricula";
		final String senhaParam = "senha";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select a from ").append(this.getPersistentClass().getName())
				.append(" a where a.matricula = :").append(matriculaParam)
				.append(" and a.senha = :").append(senhaParam);
		
		Aluno aluno = null;
		
		try {
			aluno = (Aluno)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(matriculaParam, matricula)
					.setParameter(senhaParam, senha)
					.uniqueResult();
		} catch (Exception e) {
			aluno = null;
		}
		
		return aluno;
	}
	
}
