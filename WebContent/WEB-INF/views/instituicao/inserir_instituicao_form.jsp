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
		
		<title>Cadastro de Instituição</title>
	</head>
	<body>
		<div class="container">
			<h3>
				<legend>Formulário de Cadastro de Instituição</legend>
			</h3>
		</div>
		<div class="container">
			<div class="col-mod-4"></div>
			<div class="col-mod-4">
				<form:form method="post" action="adicionarInstituicao.html" commandName="instituicao">
					<label>Nome Fantasia:</label>
					<form:input path="nomeFantasia" cssClass="form-control" size="100" maxlength="100"  />
					<br />
					
					<label>Nome Empresarial:</label>
					<form:input path="nomeEmpresarial" cssClass="form-control" size="100" maxlength="100" />
					<br />
					
					<label>CNPJ:</label>
					<form:input path="cnpj" cssClass="form-control" />
					<br />
					
					<label>Inscrição Estadual:</label>
					<form:input path="inscricaoEstadual" cssClass="form-control" />
					<br />
					
					<label>Logradouro:</label>
					<form:input path="endereco.logradouro" cssClass="form-control" />
					<br />
					
					<label>Número:</label>
					<form:input path="endereco.numero" cssClass="form-control" />
					<br />
					
					<label>Cep:</label>
					<form:input path="endereco.cep" cssClass="form-control" />
					<br />
					
					<label>Bairro:</label>
					<form:input path="endereco.bairro" cssClass="form-control" />
					<br />
					
					<label>Cidade:</label>
					<form:input path="endereco.cidade" cssClass="form-control" />
					<br />
					
					<label>Estado:</label>
					<form:input path="endereco.estado" cssClass="form-control" />
					<br />
					
					<label>DDD:</label>
					<form:input path="telefone.DDD" cssClass="form-control" />
					<br />
					
					<label>Telefone:</label>
					<form:input path="telefone.numero" cssClass="form-control" />
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