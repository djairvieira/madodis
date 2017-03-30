package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.SecretariaDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;
import br.edu.facol.gestaoacademicaweb.service.SecretariaService;

@Service("secretariaService")
public class SecretariaServiceImpl implements SecretariaService {

	@Autowired
	private SecretariaDAO secretariaDAO;
	
	@Transactional
	public void adicionarSecretaria(Secretaria secretaria) {
		secretariaDAO.salvar(secretaria);
	}

	@Transactional
	public void removerSecretaria(int id) {
		secretariaDAO.remover(id);
	}

	@Transactional
	public void atualizarSecretaria(Secretaria secretaria) {
		secretariaDAO.atualizar(secretaria);
	}

	@Override
	@Transactional
	public List<Secretaria> listarSecretarias() {
		return secretariaDAO.listarTodos();
	}

	@Override
	@Transactional
	public Secretaria getSecretariaById(int id) {
		return secretariaDAO.getById(id);
	}

}
