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
		<h3 class="page-header">Usuario ${usuario.nomeUsuario}</h3>
		<!-- Formulario para alteração de clientes -->
		<form action="controller.do" method="post">
			<!-- area de campos do form -->

			<input type="hidden" name="id" value="${usuario.id}" />


			<div class="alert-info" role="alert">
				<strong><h3>${mensagem}</h3></strong>
			</div>

			<div class="row">

				<div class="form-group col-md-6">
					<label for="emailUsuario">Atualizar Meu E-Mail</label> <input
						type="text" class="form-control" name="emailUsuario"
						id="emailUsuario" placeholder="Mudar E-mail"
						value="${usuario.emailUsuario}" readonly="true">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="documentoCPFCNPJEmpresa">Meu Documento</label> <input
						type="text" class="form-control" name="documentoCPFCNPJEmpresa"
						id="documentoCPFCNPJEmpresa" required maxlength="60"
						placeholder="area" value="${usuario.documentoCPFCNPJEmpresa}"
						readonly="true">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="documentoEmpresa">Documento da Empresa</label> <input
						type="text" class="form-control" name="documentoEmpresa"
						id="documentoEmpresa" required maxlength="60" placeholder="area"
						value="${usuario.documentoEmpresa}" readonly="true">
				</div>
			</div>

			<div id="actions" class="row">
				<div class="col-md-12">
					<a href="#" class="btn btn-danger" data-toggle="modal"
						data-target="#delete-modal">Alterar minha senha</a>
				</div>
			</div>

			<!-- Modal -->
			<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
				aria-labelledby="modalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Fechar">
								<span aria-hidden="true">&times;</span>
							</button>

							<h4 class="modal-title" id="modalLabel">Alterar Senha</h4>
						</div>
						<div class="modal-body">Antes de Alterar sua senha nós
							informe a sua senha atual.</div>

						<div class="modal-footer">

							<div class="form-group">
								<label class="sr-only" for="#"> </label><input type="text"
									class="form-control" name="documento" id="documento"
									placeholder="Documento" required> <br> <br> <label
									class="sr-only" for="#"> </label><input type="text"
									class="form-control" name="senha" id="senha"
									placeholder="Senha Atual" required> <br> <br>
								<label class="sr-only" for="#"> </label><input type="text"
									class="form-control" name="senhaNova" id="senhaNova"
									placeholder="Nova Senha" required> <br> <br>

								<button type="submit" class="btn btn-primary" name="command"
									value="AlterarUsuarioCartorio">Sim</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">N&atilde;o</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal -->
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>