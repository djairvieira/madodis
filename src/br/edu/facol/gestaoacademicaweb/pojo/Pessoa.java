package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class Pessoa extends BaseObject {

	@Column(name="NOME")
	private String nome;
	
	@Column(name="SEXO")
	@Enumerated(value=EnumType.ORDINAL)
	private Sexo sexo;
	
	@Column(name="DATA_NASCIMENTO")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String dataNascimento;
	
	@Column(name="NOME_PAI")
	private String nomePai;
	
	@Column(name="NOME_MAE")
	private String nomeMae;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="RG")
	private String rg;
	
	@Column(name="RG_ORGAO_EXPEDIDOR")
	private String rgOrgaoExpedidor;
	
	@Column(name="TITULO_ELEITORAL")
	private String tituloEleitoral;
	
	@Column(name="NACIONALIDADE")
	private String nacionalidade;
	
	@Column(name="NATURALIDADE")
	private String naturalidade;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="MATRICULA")
	private String matricula;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Endereco endereco;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Telefone telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRgOrgaoExpedidor() {
		return rgOrgaoExpedidor;
	}

	public void setRgOrgaoExpedidor(String rgOrgaoExpedidor) {
		this.rgOrgaoExpedidor = rgOrgaoExpedidor;
	}

	public String getTituloEleitoral() {
		return tituloEleitoral;
	}

	public void setTituloEleitoral(String tituloEleitoral) {
		this.tituloEleitoral = tituloEleitoral;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

}
