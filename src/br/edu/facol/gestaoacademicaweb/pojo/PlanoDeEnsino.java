package br.edu.facol.gestaoacademicaweb.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_PLANO_ENSINO")
public class PlanoDeEnsino {

	@ManyToOne
	private List<Aula> aulas;

}
