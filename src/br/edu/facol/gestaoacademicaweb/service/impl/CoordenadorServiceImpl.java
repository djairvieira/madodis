package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.CoordenadorDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;
import br.edu.facol.gestaoacademicaweb.service.CoordenadorService;

@Service("coordenadorService")
public class CoordenadorServiceImpl implements CoordenadorService {

	@Autowired
	private CoordenadorDAO coordenadorDAO;
	
	@Transactional
	public void adicionarCoordenador(Coordenador coordenador) {
		coordenadorDAO.salvar(coordenador);
	}

	@Transactional
	public void removerCoordenador(int id) {
		coordenadorDAO.remover(id);
	}

	@Transactional
	public void atualizarCoordenador(Coordenador coordenador) {
		coordenadorDAO.atualizar(coordenador);
	}

	@Override
	@Transactional
	public List<Coordenador> listarCoordenadors() {
		return coordenadorDAO.listarTodos();
	}

	@Override
	@Transactional
	public Coordenador getCoordenadorById(int id) {
		return coordenadorDAO.getById(id);
	}

}
