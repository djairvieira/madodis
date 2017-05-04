<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet"
			href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
		
		<!-- Optional theme -->
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
			integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX"
			crossorigin="anonymous">
		
		<!-- Latest compiled and minified JavaScript -->
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
			integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="
			crossorigin="anonymous"></script>
		
		<title>Cadastro de Disciplinas</title>
	</head>
	<body>
		<div class="container">
			<h3>
				<c:choose>
					<c:when test="${disciplina.id < 1}">
						<legend>Cadastrar Disciplina</legend>
					</c:when>
					<c:otherwise>
						<legend>Atualizar Disciplina</legend>
					</c:otherwise>
				</c:choose>
			</h3>
		</div>
		<div class="container">
			<div class="col-mod-4"></div>
			<div class="col-mod-4">
			
				<c:choose>
					<c:when test="${disciplina.id < 1}">
						<c:set var="my_action" value="adicionarDisciplina.html"/>
					</c:when>
					<c:otherwise>
						<c:set var="my_action" value="atualizarDisciplina.html"/>
					</c:otherwise>
				</c:choose>
			
				<form:form method="post" action="${my_action}"
					commandName="disciplina">
					<label>Nome:</label>
					<form:input path="nome" cssClass="form-control"></form:input>
					<br />
					<label>Sigla:</label>
					<form:input path="sigla" cssClass="form-control"></form:input>
					<br />
					<label>Creditos:</label>
					<form:input path="creditos" cssClass="form-control"></form:input>
					<br />
					<label>Descrição:</label>
					<form:input path="descricao" cssClass="form-control"></form:input>
					<br />
					<label>Carga horaria:</label>
					<form:input path="cargaHoraria" cssClass="form-control"></form:input>
					<br />
					<label>Modulo Pertencente:</label>
					<form:input path="moduloPertencente" cssClass="form-control"></form:input>
					<br />
					<label>Requisitos:</label>
					<form:input path="requisitos" cssClass="form-control"></form:input>
					<br />
					<label>Metodo de Aprendizagem:</label>
					<form:input path="planoDeEnsino.metodoApredizagem" cssClass="form-control"></form:input>
					<br />
					<label>Carga horaria Teorica:</label>
					<form:input path="planoDeEnsino.cargaHorariaTeorica" cssClass="form-control"></form:input>
					<br />
					<label>Carga horaria Pratica:</label>
					<form:input path="planoDeEnsino.cargaHorariaPratica" cssClass="form-control"></form:input>
					<br />
					<label>Objetivos:</label>
					<form:input path="planoDeEnsino.objetivos" cssClass="form-control"></form:input>
					<br />
					<label>Metodo de Avaliacao:</label>
					<form:input path="planoDeEnsino.medotoAvaliacao" cssClass="form-control"></form:input>
					<br />
					<label>Bibliografia Usada:</label>
					<form:input path="planoDeEnsino.bibliografiaUsada" cssClass="form-control"></form:input>
					<br />
					<label>Ementa:</label>
					<form:input path="planoDeEnsino.ementa" cssClass="form-control"></form:input>
					<br />
					<label>Professor:</label>
					<select name="professor" id="professor">
						<c:forEach items="${professores}" var="professor">
							<option value="${professor}">${professor.name}</option>
						</c:forEach>
					</select>
					<br />
					<input type="submit" value="Salvar" class="btn btn-success" />
					<br />
					<br />
				</form:form>
			</div>
			<div class="col-mod-4"></div>
		</div>
	</body>
</html>