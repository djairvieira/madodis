package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_INSTITUICAO")
public class Instituicao extends BaseObject {
	
	@Column(name="NOME_FANTASIA")
	private String nomeFantasia;
	
	@Column(name="NOME_EMPRESARIAL")
	private String nomeEmpresarial;
	
	@Column(name="CNPJ")
	private String cnpj;
	
	@Column(name="INSCRICAO_ESTADUAL")
	private String inscricaoEstadual;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco endereco;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Telefone telefone;

	public Instituicao() {
		super();
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}

	public void setNomeEmpresarial(String nomeEmpresarial) {
		this.nomeEmpresarial = nomeEmpresarial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Nome Fantasia: " + getNomeFantasia() + ", CNPJ: " + cnpj;
	}

}
