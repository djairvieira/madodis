package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.AulaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aula;
import br.edu.facol.gestaoacademicaweb.service.AulaService;

@Service("aulaService")
public class AulaServiceImpl implements AulaService {

	@Autowired
	private AulaDAO aulaDAO;
	
	@Transactional
	public void adicionarAula(Aula aula) {
		aulaDAO.salvar(aula);
	}

	@Transactional
	public void removerAula(int id) {
		aulaDAO.remover(id);
	}

	@Transactional
	public void atualizarAula(Aula aula) {
		aulaDAO.atualizar(aula);
	}

	@Override
	@Transactional
	public List<Aula> listarAulas() {
		return aulaDAO.listarTodos();
	}

	@Override
	@Transactional
	public Aula getAulaById(int id) {
		return aulaDAO.getById(id);
	}

}
