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
	<c:import url="MenuUsuario.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<!-- Formulario para alteração de clientes -->
		<form action="controller.do" method="post">
			<!-- area de campos do form -->

			<input type="hidden" name="id" value="${empresa.id}" />

			<h3 class="page-header">${empresa.razaoSocial} CNPJ	${empresa.empresaCNPJ}</h3>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="razaoSocial">Razão Social da Empresa</label> <input type="text"
						class="form-control" name="razaoSocial" id="razaoSocial" required
						maxlength="100" placeholder="digite a razão social"
						value="${empresa.razaoSocial}" readonly="true">
				</div>

				<div class="form-group col-md-6">
					<label for="contatoPrincipalNome">Nome da Empresa</label> <input type="text"
						class="form-control" name="contatoPrincipalNome"
						id="contatoPrincipalNome" required maxlength="30"
						placeholder="nome completo"
						value="${empresa.contatoPrincipalNome}" readonly="true">

				</div>
				<div class="form-group col-md-6">
					<label for="contatoPrincipalEmail">E-Mail da Empresa</label> <input
						type="email" class="form-control" name="contatoPrincipalEmail"
						id="contatoPrincipalEmail" required maxlength="50"
						placeholder="email obrigatório"
						value="${empresa.contatoPrincipalEmail}" readonly="true">
				</div>
			</div>

			<div class="row">
				
				<div class="form-group col-md-4">
					<label for="telEmpresa">Telefone da Empresa</label> <input type="text"
						class="form-control" name="telEmpresa" id="telEmpresa"
						placeholder="Telefone" value="${empresa.telefone}" readonly="true">
				</div>


				<div class="form-group col-md-6">
					<label for="site">Site da Empresa</label> <input type="text"
						class="form-control" name="site" id="site" required maxlength="50"
						placeholder="nome site" value="${empresa.site}" readonly="true">
				</div>
			
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="descriAtvEconomicas">Descrição das Atividades
						Econômicas e Jurídicas da Empresa</label>
					<textarea class="form-control" rows="3" name="descriAtvEconomicas"
						id="descriAtvEconomicas" placeholder="Maximo de 200 caracteres" readonly="true"> ${empresa.descriAtvEconomicas} </textarea>
				</div>
			</div>

			<h3 class="page-header">Endereço completo da Empresa</h3>
			<div class="row">
				<div class="form-group col-md-2">
					<label for="cep">CEP</label> <input type="text"
						class="form-control" name="cep" id="cep" required maxlength="9"
						placeholder="00000-000" value="${empresa.cep}" readonly="true">
				</div>

				<div class="form-group col-md-6">
					<label for="logradouro">Logradouro</label> <input type="text"
						class="form-control" name="logradouro" id="logradouro" required
						maxlength="50" placeholder="informe o Logradouro"
						value="${empresa.logradouro}" readonly="true">
				</div>

			</div>

			<div class="row">
				<div class="form-group col-md-4">
					<label for="cidade">Cidade</label> <input type="text"
						class="form-control" name="cidade" id="cidade" required
						maxlength="20" placeholder="informe a Cidade"
						value="${empresa.cidade}" readonly="true">
				</div>
				<div class="form-group col-md-2">
					<label for="estado">Estado</label> <input type="text"
						class="form-control" name="estado" id="estado" required
						maxlength="2" placeholder="UF" value="${empresa.estado}" readonly="true">
				</div>

			</div>

			</br>
			

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
							<h4 class="modal-title" id="modalLabel">Alterar Empresa</h4>
						</div>
						<div class="modal-body">Deseja realmente fazer alterações em
							sua empresa?</div>
						<div class="modal-footer">
							<form action="cadastro.do" method="post">
								<button type="submit" class="btn btn-primary" name="command"
									value="AlterarEmpresaLogado">Sim</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">N&atilde;o</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal -->




			</br> </br>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>