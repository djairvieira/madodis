package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.AlunoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.service.AlunoService;

@Service("alunoService")
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoDAO alunoDAO;
	
	@Transactional
	public void adicionarAluno(Aluno aluno) {
		alunoDAO.salvar(aluno);
	}

	@Transactional
	public void removerAluno(int id) {
		alunoDAO.remover(id);
	}

	@Transactional
	public void atualizarAluno(Aluno aluno) {
		alunoDAO.atualizar(aluno);
	}

	@Override
	@Transactional
	public List<Aluno> listarAlunos() {
		return alunoDAO.listarTodos();
	}

	@Override
	@Transactional
	public Aluno getAlunoById(int id) {
		return alunoDAO.getById(id);
	}

}
