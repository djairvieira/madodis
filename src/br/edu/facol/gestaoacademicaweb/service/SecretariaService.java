package br.edu.facol.gestaoacademicaweb.service;

import java.util.List;

import br.edu.facol.gestaoacademicaweb.pojo.Secretaria;

public interface SecretariaService {
	
	public void adicionarSecretaria(Secretaria aluno);
	public void removerSecretaria(int id);
	public void atualizarSecretaria(Secretaria aluno);
	public List<Secretaria> listarSecretarias();
	public Secretaria getSecretariaById(int id);
	
}
