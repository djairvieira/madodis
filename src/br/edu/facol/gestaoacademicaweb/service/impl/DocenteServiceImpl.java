package br.edu.facol.gestaoacademicaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.facol.gestaoacademicaweb.dao.DocenteDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Docente;
import br.edu.facol.gestaoacademicaweb.service.DocenteService;

@Service("docenteService")
public class DocenteServiceImpl implements DocenteService{

	@Autowired
	private DocenteDAO docenteDAO;
	
	@Transactional
	public void adicionarDocente(Docente docente) {
		docenteDAO.adicionarDocente(docente);
	}

	@Transactional
	public void removerDocente(int id) {
		docenteDAO.removerDocente(id);
	}

	@Override
	public List<Docente> listarDocentes() {
		return docenteDAO.listaDocentes();
	}

	@Transactional
	public void atualizaDocente(Docente docente) {
		docenteDAO.atualizaDocente(docente);
	}

	@Override
	public Docente docenteById(int id) {		
		return docenteDAO.docenteById(id);
	}

}
