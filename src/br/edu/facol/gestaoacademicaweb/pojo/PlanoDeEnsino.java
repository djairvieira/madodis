package br.edu.facol.gestaoacademicaweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_PLANO_ENSINO")
public class PlanoDeEnsino extends BaseObject {

	@Column(name="METODO_APRENDIZAGEM")
	private String metodoApredizagem;
	@Column(name="CH_TEORICA")
	private int cargaHorariaTeorica;
	@Column(name="CH_PRATICA")
	private int cargaHorariaPratica;
	@Column(name="OBJETIVOS")
	private String objetivos;
	@Column(name="METODO_AVALIACAO")
	private String medotoAvaliacao;
	@Column(name="BIBLIOGRAFIA_USADA")
	private String bibliografiaUsada;
	@Column(name="EMENTA")
	private String ementa;
	
	public String getMetodoApredizagem() {
		return metodoApredizagem;
	}

	public void setMetodoApredizagem(String metodoApredizagem) {
		this.metodoApredizagem = metodoApredizagem;
	}

	public int getCargaHorariaTeorica() {
		return cargaHorariaTeorica;
	}

	public void setCargaHorariaTeorica(int cargaHorariaTeorica) {
		this.cargaHorariaTeorica = cargaHorariaTeorica;
	}

	public int getCargaHorariaPratica() {
		return cargaHorariaPratica;
	}

	public void setCargaHorariaPratica(int cargaHorariaPratica) {
		this.cargaHorariaPratica = cargaHorariaPratica;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getMedotoAvaliacao() {
		return medotoAvaliacao;
	}

	public void setMedotoAvaliacao(String medotoAvaliacao) {
		this.medotoAvaliacao = medotoAvaliacao;
	}

	public String getBibliografiaUsada() {
		return bibliografiaUsada;
	}

	public void setBibliografiaUsada(String bibliografiaUsada) {
		this.bibliografiaUsada = bibliografiaUsada;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	@Override
	public String toString() {
		return "[ID: " + getId() + ", Metodo de Aprendizagem: " + getMetodoApredizagem() +"]";
	}

	

}
