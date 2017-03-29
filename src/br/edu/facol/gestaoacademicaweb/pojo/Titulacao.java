package br.edu.facol.gestaoacademicaweb.pojo;

public enum Titulacao {

	GRADUADO, POS_GRADUADO, MESTRE, DOUTOR, POS_DOUTOR, INVALIDO;
	
	public String[] getValues() {
		return new String[]{"Graduado", "Pós-Graduado", "Mestre", "Doutor", "Pós-Doutor"};
	}
	
	public Titulacao getValue(String titulacao) {
		switch (titulacao) {
		case "Graduado":
			return GRADUADO;
		case "Pós-Graduado":
			return POS_GRADUADO;
		case "Mestre":
			return MESTRE;
		case "Doutor":
			return DOUTOR;
		case "Pós-Doutor":
			return POS_DOUTOR;
		default:
			return INVALIDO;
		}
	}
}
