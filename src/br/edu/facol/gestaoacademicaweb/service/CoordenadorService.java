package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Coordenador;

public interface CoordenadorService {
	
	public void adicionarCoordenador(Coordenador coordenador);
	public void removerCoordenador(int id);
	public void atualizarCoordenador(Coordenador aluno);
	public List<Coordenador> listarCoordenadors();
	public Coordenador getCoordenadorById(int id);
	
}
