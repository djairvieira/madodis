package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Aula;

public interface AulaService {
	
	public void adicionarAula(Aula aula);
	public void removerAula(int id);
	public void atualizarAula(Aula aula);
	public List<Aula> listarAulas();
	public Aula getAulaById(int id);
	
}
