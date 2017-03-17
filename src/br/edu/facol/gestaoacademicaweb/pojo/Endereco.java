package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_ENDERECO")
public class Endereco extends BaseObject {

	@Column(name="LOGRADOURO")
	private String logradouro;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="estado")
	private String estado;
	
	public Endereco() {
		super();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Id: " + getId() + ", Logradouro: " + getLogradouro() + ", Numero: " + getNumero();
	}
	

}
