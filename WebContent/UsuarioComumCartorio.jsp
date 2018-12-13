<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cerveja.biz - Alterar usuario</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="MenuCartorio.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Criar Colaborador </h3>
		<!-- Formulario para alteração de clientes -->
		<form action="controller.do" method="post">
			<!-- area de campos do form -->

			<input type="hidden" name="id" value="${usuario.id}" />

			<div class="row">
				<div class="form-group col-md-12">
					<label for="nomeUsuario">Nome Usuario</label> <input type="text"
						class="form-control" name="nomeUsuario" id="nomeUsuario" required
						maxlength="100" placeholder="nome completo">
				</div>
				<div class="form-group col-md-6">
					<label for="emailUsuario">Email Usuario</label> <input type="text"
						class="form-control" name="emailUsuario" id="emailUsuario"	placeholder="Campo E-mail" >
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="documentoCPFCNPJ">Documento CPF/CNPJ</label>
					<input type="text" class="form-control"
						name="documentoCPFCNPJ" id="documentoCPFCNPJ"
						required maxlength="60" placeholder="Documento CPF/CNPJ">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="documentoEmpresa">Documento Empresa</label> <input
						type="text" class="form-control" name="documentoEmpresa"
						id="documentoEmpresa" required maxlength="60" placeholder="Doucumento">
				</div>
				
				<div class="form-group col-md-6">
					<label for="senha">Senha</label> <input
						type="text" class="form-control" name="senha"
						id="senha" required maxlength="60" placeholder="senha">
				</div>
			</div>

			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command"
						value="CriarUsuarioComumCartorio">Salvar</button>
					<a href="IndexEmpresa.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>