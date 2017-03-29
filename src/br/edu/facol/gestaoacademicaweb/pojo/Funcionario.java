package br.edu.facol.gestaoacademicaweb.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Funcionario extends Pessoa {

	@Column(name="CTPS_NUMERO")
	private String ctpsNumero;
	
	@Column(name="CTPS_DATA_EXPEDICAO")
	private Date ctpsDataExpedicao;

	public String getCtpsNumero() {
		return ctpsNumero;
	}

	public void setCtpsNumero(String ctpsNumero) {
		this.ctpsNumero = ctpsNumero;
	}

	public Date getCtpsDataExpedicao() {
		return ctpsDataExpedicao;
	}

	public void setCtpsDataExpedicao(Date ctpsDataExpedicao) {
		this.ctpsDataExpedicao = ctpsDataExpedicao;
	}
	
	public abstract boolean temAcesso(String menu);

}
