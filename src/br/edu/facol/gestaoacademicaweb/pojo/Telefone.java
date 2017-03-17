package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_TELEFONE")
public class Telefone extends BaseObject {

	@Column(name="DDD")
	private String ddd;
	
	@Column(name="numero")
	private String numero;
	
	public Telefone() {
		super();
	}

	public String getDDD() {
		return ddd;
	}

	public void setDDD(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Id: " + getId() + ", DDD: " + getDDD() + ", Numero: " + getNumero();
	}
	

}
