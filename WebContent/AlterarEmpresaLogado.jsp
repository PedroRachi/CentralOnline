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
	<c:import url="MenuEmpresa.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<!-- Formulario para alteração de clientes -->
		<form action="controller.do" method="post">
			<!-- area de campos do form -->

			<input type="hidden" name="id" value="${empresa.id}"/>

			<h3 class="page-header">Dados ${empresa.tipoPerfil} Seu CNPJ
				Cadastrado na Central é ${empresa.empresaCNPJ}</h3>
			
			<h3 class="page-header">Seus dados como Empresa</h3>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="razaoSocial">Razão Social*</label> <input type="text"
						class="form-control" name="razaoSocial" id="razaoSocial" required
						maxlength="100" placeholder="digite a razão social"
						value="${empresa.razaoSocial}">
				</div>

				<div class="form-group col-md-6">
					<label for="contatoPrincipalNome">Nome</label> <input type="text"
						class="form-control" name="contatoPrincipalNome"
						id="contatoPrincipalNome" required maxlength="30"
						placeholder="nome completo"
						value="${empresa.contatoPrincipalNome}">

				</div>
				<div class="form-group col-md-6">
					<label for="contatoPrincipalEmail">E-Mail</label> <input
						type="email" class="form-control" name="contatoPrincipalEmail"
						id="contatoPrincipalEmail" required maxlength="50"
						placeholder="email obrigatório"
						value="${empresa.contatoPrincipalEmail}">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-4">
					<label for="contatoPrincipalCPF">CPF</label> <input type="text"
						class="form-control" name="contatoPrincipalCPF"
						id="contatoPrincipalCPF" placeholder="CPF"
						value="${empresa.contatoPrincipalCPF}" readonly="true">
				</div>

				<div class="form-group col-md-4">
					<label for="telEmpresa">Telefone</label> <input type="text"
						class="form-control" name="telEmpresa" id="telEmpresa"
						placeholder="Telefone" value="${empresa.telefone}">
				</div>


				<div class="form-group col-md-6">
					<label for="site">Nome do site</label> <input type="text"
						class="form-control" name="site" id="site" required maxlength="50"
						placeholder="nome site" value="${empresa.site}">
				</div>
				
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="descriAtvEconomicas">Descrição das Atividades
						Econômicas e Jurídicas</label>
					<textarea class="form-control" rows="3" name="descriAtvEconomicas"
						id="descriAtvEconomicas" placeholder="Maximo de 200 caracteres">${empresa.descriAtvEconomicas}</textarea>
				</div>
			</div>

			<h3 class="page-header">Endereço completo</h3>
			<div class="row">
				<div class="form-group col-md-2">
					<label for="cep">CEP</label> <input type="text"
						class="form-control" name="cep" id="cep" required maxlength="9"
						placeholder="00000-000" value="${empresa.cep}">
				</div>

				<div class="form-group col-md-6">
					<label for="logradouro">Logradouro</label> <input type="text"
						class="form-control" name="logradouro" id="logradouro" required
						maxlength="50" placeholder="informe o Logradouro"
						value="${empresa.logradouro}">
				</div>

			</div>

			<div class="row">
				<div class="form-group col-md-4">
					<label for="cidade">Cidade</label> <input type="text"
						class="form-control" name="cidade" id="cidade" required
						maxlength="20" placeholder="informe a Cidade"
						value="${empresa.cidade}">
				</div>
				<div class="form-group col-md-2">
					<label for="estado">Estado</label> <input type="text"
						class="form-control" name="estado" id="estado" required
						maxlength="2" placeholder="UF" value="${empresa.estado}">
				</div>

			</div>

			</br>
			<div id="actions" class="row">
				<div class="col-md-12">
					<a href="#" class="btn btn-danger" data-toggle="modal"
						data-target="#delete-modal">Salvar</a> <a href="indexEmpresa"
						class="btn btn-default">Cancelar</a>
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