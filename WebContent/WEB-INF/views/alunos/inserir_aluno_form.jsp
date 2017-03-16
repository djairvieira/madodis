<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>
 
<title>Cadastro de Alunos</title>
</head>
<body>
<div class="container">
<h3><legend>Formulário de Cadastro de Alunos</legend></h3>
</div>
<div class="container">
<div class="col-mod-4"></div>
<div class="col-mod-4">
<form:form method="post" action="adicionarAluno.html" commandName="aluno">
	<label>Nome:</label>
		<form:input path="nome"  cssClass="form-control"></form:input><br/>
	<label>Matrícula:</label>	
		<form:input path="matricula" cssClass="form-control"></form:input><br/>
	<label>Curso:</label>
		<select name="id_curso" id="curso" >
			<option value="0">Selecione...</option>
			<c:forEach items="${alunoCursos}" var="curso">
				<option value="${curso.id}">${curso.nome}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Salvar" class="btn btn-success"/>				
</form:form>
</div>
<div class="col-mod-4"></div>
</div>
</body>
</html>