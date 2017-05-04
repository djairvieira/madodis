package br.edu.facol.gestaoacademicaweb.dao.impl;

import org.springframework.stereotype.Repository;

import br.edu.facol.gestaoacademicaweb.dao.ProfessorDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Professor;

@Repository
public class ProfessorDAOImpl extends BaseDaoImpl<Professor> implements ProfessorDAO {

	public Professor autenticar(String matricula, String senha) {
		final String matriculaParam = "matricula";
		final String senhaParam = "senha";
		
		StringBuilder hql = 
			new StringBuilder()
				.append("select p from ").append(this.getPersistentClass().getName())
				.append(" p where p.matricula = :").append(matriculaParam)
				.append(" and p.senha = :").append(senhaParam);
		
		Professor professor = null;
		
		try {
			professor = (Professor)
				this.getCurrentSession().createQuery(hql.toString())
					.setParameter(matriculaParam, matricula)
					.setParameter(senhaParam, senha)
					.uniqueResult();
		} catch (Exception e) {
			professor = null;
		}
		
		return professor;
	}
	
}
