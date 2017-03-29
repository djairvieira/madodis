package br.edu.facol.gestaoacademicaweb.pojo;

public enum Sexo {

	MASCULINO, FEMININO, INVALIDO;
	
	public String[] getValues() {
		return new String[]{"Masculino", "Feminino"};
	}
	
	public Sexo getValue(String sexo) {
		switch (sexo) {
		case "Masculino":
			return MASCULINO;
		case "Feminino":
			return FEMININO;
		default:
			return INVALIDO;
		}
	}
	
}
