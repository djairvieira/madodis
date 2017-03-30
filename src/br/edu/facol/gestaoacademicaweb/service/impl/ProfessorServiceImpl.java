package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.ProfessorDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Professor;
import br.edu.facol.gestaoacademicaweb.service.ProfessorService;

@Service("professorService")
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorDAO professorDAO;
	
	@Transactional
	public void adicionarProfessor(Professor professor) {
		professorDAO.salvar(professor);
	}

	@Transactional
	public void removerProfessor(int id) {
		professorDAO.remover(id);
	}

	@Transactional
	public void atualizarProfessor(Professor professor) {
		professorDAO.atualizar(professor);
	}

	@Override
	@Transactional
	public List<Professor> listarProfessors() {
		return professorDAO.listarTodos();
	}

	@Override
	@Transactional
	public Professor getProfessorById(int id) {
		return professorDAO.getById(id);
	}

}
