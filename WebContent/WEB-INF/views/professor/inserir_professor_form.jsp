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
		
		<title>Cadastro de Professores</title>
	</head>
	<body>
		<div class="container">
			<h3>
				<c:choose>
					<c:when test="${professor.id < 1}">
						<legend>Cadastrar Professor</legend>
					</c:when>
					<c:otherwise>
						<legend>Atualizar Professor</legend>
					</c:otherwise>
				</c:choose>
			</h3>
		</div>
		<div class="container">
			<div class="col-mod-4"></div>
			<div class="col-mod-4">
			
				<c:choose>
					<c:when test="${professor.id < 1}">
						<c:set var="my_action" value="adicionarProfessor.html"/>
					</c:when>
					<c:otherwise>
						<c:set var="my_action" value="atualizarProfessor.html"/>
					</c:otherwise>
				</c:choose>
			
				<form:form method="post" action="${my_action}"
					commandName="professor">
					<label>Nome:</label>
					<form:input path="nome" cssClass="form-control"></form:input>
					<br />
					<label>Cpf:</label>
					<form:input path="cpf" cssClass="form-control"></form:input>
					<br />
					<label>Sexo:</label>
					<select name="sexo" id="sexo">
						<c:forEach items="${sexos}" var="sexo">
							<option value="${sexo}">${sexo}</option>
						</c:forEach>
					</select>
					<br />
					<label>Titulação:</label>
					<select name="titulacao" id="titulacao">
						<c:forEach items="${titulacoes}" var="titulacao">
							<option value="${titulacao}">${titulacao}</option>
						</c:forEach>
					</select>
					<br />
					<label>Titulo de eleitor:</label>
					<form:input path="tituloEleitoral" cssClass="form-control"></form:input>
					<br />
					<label>RG:</label>
					<form:input path="rg" cssClass="form-control"></form:input>
					<br />
					<label>Orgão Expedidor:</label>
					<form:input path="rgOrgaoExpedidor" cssClass="form-control"></form:input>
					<br />
					<label>CTPS Numero:</label>
					<form:input path="ctpsNumero" cssClass="form-control"></form:input>
					<br />
					<label>CTPS Data Expedição:</label>
					<form:input type="date" path="ctpsDataExpedicao" cssClass="form-control"></form:input>
					<br />
					<label>Nome do pai:</label>
					<form:input path="nomePai" cssClass="form-control"></form:input>
					<br />
					<label>Nome da Mãe:</label>
					<form:input path="nomeMae" cssClass="form-control"></form:input>
					<br />
					<label>Data Nascimento:</label>
					<form:input type="date" path="dataNascimento" cssClass="form-control"></form:input>
					<br />
					<label>Nacionalidade:</label>
					<form:input path="nacionalidade" cssClass="form-control"></form:input>
					<br />
					<label>Naturalidade:</label>
					<form:input path="naturalidade" cssClass="form-control"></form:input>
					<br />
					<label>Matrícula:</label>
					<form:input path="matricula" cssClass="form-control"></form:input>
					<br />
					<label>Email:</label>
					<form:input path="email" cssClass="form-control"></form:input>
					<br />
					<label>Senha:</label>
					<form:input path="senha" cssClass="form-control"></form:input>
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