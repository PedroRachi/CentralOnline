<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cerveja.biz - Alterar empresa</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->

	<!-- Container Principal -->
	<c:import url="MenuEmpresa.jsp"/>
		<h3 class="page-header">Alterar empresa #${empresa.id}</h3>
		<!-- Formulario para alteração de clientes -->
		<form action="cadastro.do" method="post">
			<!-- area de campos do form -->

			<input type="hidden" name="id" value="${empresa.id}" />

			<div class="row">
				<div class="form-group col-md-12">
					<label for="empresaCNPJ">cnpj</label> <input type="text"
						class="form-control" name="empresaCNPJ" id="empresaCNPJ" required
						maxlength="100" placeholder="nome completo"
						value="${empresa.empresaCNPJ}">
				</div>
				<div class="form-group col-md-6">
					<label for="razaoSocial">razaosocial</label> <input type="text"
						class="form-control" name="razaoSocial" id="razaoSocial"
						placeholder="pop pais" value="${empresa.razaoSocial}">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="area">logradouro</label> <input type="text"
						class="form-control" name="logradouro" id="logradouro" required
						maxlength="60" placeholder="area" value="${empresa.logradouro}">
				</div>
				<div class="form-group col-md-6">
					<label for="populacao">cidade</label> <input type="text"
						class="form-control" name="cidade" id="cidade"
						placeholder="pop pais" value="${empresa.cidade}">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="populacao">estado</label> <input type="text"
						class="form-control" name="estado" id="estado"
						placeholder="pop pais" value="${empresa.estado}" maxlength="2">
				</div>
				<div class="form-group col-md-6">
					<label for="populacao">cep</label> <input type="text"
						class="form-control" name="cep" id="cep" placeholder="pop pais"
						value="${empresa.cep}">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="populacao">telefone</label> <input type="text"
						class="form-control" name="telefone" id="telefone"
						placeholder="pop pais" value="${empresa.telefone}">
				</div>
				<div class="form-group col-md-6">
					<label for="populacao">contatoPrincipalNome</label> <input
						type="text" class="form-control" name="contatoPrincipalNome"
						id="contatoPrincipalNome" placeholder="pop pais"
						value="${empresa.contatoPrincipalNome}">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="populacao">contatoPrincipalCPF</label> <input
						type="text" class="form-control" name="contatoPrincipalCPF"
						id="contatoPrincipalCPF" placeholder="pop pais"
						value="${empresa.contatoPrincipalCPF}">
				</div>
				<div class="form-group col-md-6">
					<label for="populacao">contatoPrincipalEmail</label> <input
						type="text" class="form-control" name="contatoPrincipalEmail"
						id="contatoPrincipalEmail" placeholder="pop pais"
						value="${empresa.contatoPrincipalEmail}">
				</div>
			</div>
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command"
						value="AlterarEmpresa">Salvar</button>
					<a href="ListarEmpresa.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>