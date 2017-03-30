package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public abstract class Funcionario extends Pessoa {

	@Column(name="CTPS_NUMERO")
	private String ctpsNumero;
	
	@Column(name="CTPS_DATA_EXPEDICAO")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String ctpsDataExpedicao;

	public String getCtpsNumero() {
		return ctpsNumero;
	}

	public void setCtpsNumero(String ctpsNumero) {
		this.ctpsNumero = ctpsNumero;
	}

	public String getCtpsDataExpedicao() {
		return ctpsDataExpedicao;
	}

	public void setCtpsDataExpedicao(String ctpsDataExpedicao) {
		this.ctpsDataExpedicao = ctpsDataExpedicao;
	}
	
	public abstract boolean temAcesso(String menu);

}
