package br.edu.facol.gestaoacademicaweb.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.edu.facol.gestaoacademicaweb.dao.CursoDAO;
import br.edu.facol.gestaoacademicaweb.pojo.Curso;

@Component
public class ConverterParaCurso implements Converter<Long, Curso> {

	@Autowired
	private CursoDAO cursoDAO;
	
	@Override
	public Curso convert(Long id) {
		return cursoDAO.cursoById(id.intValue());
	}

}
