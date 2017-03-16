package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.AlunoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Aluno;
import br.edu.facol.gestaoacademicaweb.service.AlunoService;

@Service("alunoService")
public class AlunoServiceImpl implements AlunoService{

	@Autowired
	private AlunoDAO alunoDAO;
	
	@Transactional
	public void adicionarAluno(Aluno aluno) {
		alunoDAO.adicionarAluno(aluno);
	}

	@Transactional
	public void removerAluno(int id) {
		alunoDAO.removerAluno(id);
	}

	@Transactional
	public void atualizaAluno(Aluno aluno) {
		alunoDAO.atualizaAluno(aluno);
	}

	@Override
	public List<Aluno> listaAlunos() {
		return alunoDAO.listaAlunos();
	}

	@Override
	public Aluno alunoById(int id) {
		return alunoDAO.alunoById(id);
	}

}
