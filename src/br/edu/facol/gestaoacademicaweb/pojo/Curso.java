package br.edu.facol.gestaoacademicaweb.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TB_CURSO")
public class Curso extends BaseObject {

	@Column(name="NOME")
	private String nome;
	
	@Column(name="SIGLA")
	private String sigla;
	
	@Column(name="CODIGO_CURSO_MEC")
	private String codigoCursoMec;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="PERIODOS")
	private int periodos;
	
	@Column(name="AREA")
	private String area;
	
	@Column(name="TIPO_ENSINO")
	private String tipoEnsino;
	
	@Column(name="DATA_CRIACAO")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String dataCriacao;
	
	@OneToOne
	private Instituicao instituicao;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Disciplina> disciplinas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCodigoCursoMec() {
		return codigoCursoMec;
	}

	public void setCodigoCursoMec(String codigoCursoMec) {
		this.codigoCursoMec = codigoCursoMec;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPeriodos() {
		return periodos;
	}

	public void setPeriodos(int periodos) {
		this.periodos = periodos;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTipoEnsino() {
		return tipoEnsino;
	}

	public void setTipoEnsino(String tipoEnsino) {
		this.tipoEnsino = tipoEnsino;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	@Override
	public String toString() {
		return "Curso [id=" + getId() + ", nome=" + nome + "]";
	}
	
}
