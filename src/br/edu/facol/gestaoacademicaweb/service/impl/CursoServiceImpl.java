package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.CursoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Curso;
import br.edu.facol.gestaoacademicaweb.service.CursoService;

@Service("cursoService")
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoDAO cursoDAO;
	
	@Transactional
	public void adicionarCurso(Curso curso) { 
		cursoDAO.adicionarCurso(curso);
	}

	@Override
	public void removerCurso(int id) {
		cursoDAO.removerCurso(id);
	}

	@Override
	public void atualizaCurso(Curso curso) {
		cursoDAO.atualizaCurso(curso);
	}

	@Override
	public List<Curso> listaCursos() {
		return cursoDAO.listaCursos();
	}

	@Override
	public Curso cursoById(int id) {
		return cursoDAO.cursoById(id);
	}


}
