<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cerveja.biz - Alterar cartorio</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Alterar Cartorio ${cartorio.cartorioCNPJ}</h3>
		<!-- Formulario para alteração de clientes -->
		<form action="controller.do" method="post">
			<!-- area de campos do form -->

			<input type="hidden" name="id" value="${cartorio.id}" />



			<div class="row">
				<div class="form-group col-md-2">
					<label for="cartorioCNPJ">CNPJ*</label> <input type="text"
						class="form-control" name="cartorioCNPJ" id="cartorioCNPJ"
						required maxlength="14" placeholder="CNPJ"
						value="${cartorio.cartorioCNPJ}" readonly="true">
				</div>

				<div class="form-group col-md-2">
					<label for="id">ID*</label> <input type="text" class="form-control"
						name="id" id="id" required maxlength="14" placeholder="CNPJ"
						value="${cartorio.id}" readonly="true">
				</div>

				<div class="form-group col-md-2">
					<label for="tipoPerfil">Perfil*</label> <input type="text"
						class="form-control" name="tipoPerfil" id="tipoPerfil" required
						maxlength="14" placeholder="CNPJ" value="${cartorio.tipoPerfil}"
						readonly="true">
				</div>

				<div class="form-group col-md-4">
					<label for="senhaAcesso">Senha de acesso*</label> <input
						type="text" class="form-control" name="senhaAcesso"
						id="senhaAcesso" required maxlength="20" placeholder="Senha"
						value="${cartorio.senhaAcesso}" readonly="true">
				</div>

			</div>


			<h3 class="page-header">Dados do Tabelião</h3>

			<div class="row">
				<div class="form-group col-md-2">
					<label for="tabeliaoNome">Nome*</label> <input type="text"
						class="form-control" name="tabeliaoNome" id="tabeliaoNome"
						required maxlength="50" placeholder="nome completo"
						value="${cartorio.tabeliaoNome}">
				</div>
			
				<div class="form-group col-md-4">
					<label for="tabeliaoEmail">Email</label> <input type="text"
						class="form-control" name="tabeliaoEmail" id="tabeliaoEmail"
						required maxlength="50" placeholder="e-mail completo"
						value="${cartorio.tabeliaoEmail}">
				</div>

		
				<div class="form-group col-md-4">
					<label for="tabeliaoCPF">CPF</label> <input type="text"
						class="form-control" name="tabeliaoCPF" id="tabeliaoCPF" required
						maxlength="14" placeholder="CPF" value="${cartorio.tabeliaoCPF}" readonly="true">
				</div>

			</div>

			<h3 class="page-header">Dados do Tabelião Substituto</h3>

			<div class="row">
				<div class="form-group col-md-2">
					<label for="substitutoNome">Nome*</label> <input type="text"
						class="form-control" name="substitutoNome" id="substitutoNome"
						required maxlength="50" placeholder="nome completo"
						value="${cartorio.substitutoNome}">
				</div>
		
				<div class="form-group col-md-4">
					<label for="substitutoEmail">Email</label> <input type="text"
						class="form-control" name="substitutoEmail" id="substitutoEmail"
						required maxlength="50" placeholder="e-mail completo"
						value="${cartorio.substitutoEmail}" >
				</div>

			
				<div class="form-group col-md-4">
					<label for="substitutoCPF">CPF</label> <input type="text"
						class="form-control" name="substitutoCPF" id="substitutoCPF"
						required maxlength="14" placeholder="CPF"
						value="${cartorio.substitutoCPF}" readonly="true">
				</div>

			</div>

			<h3 class="page-header">Dados do Cartorio</h3>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="razaoSocial">Razão Social*</label> <input type="text"
						class="form-control" name="razaoSocial" id="razaoSocial" required
						maxlength="100" placeholder="digite a razão social"
						value="${cartorio.razaoSocial }">
				</div>

				<div class="form-group col-md-2">
					<label for="numeroCartorio">Numero do Cartorio</label> <input
						type="text" class="form-control" name="numeroCartorio"
						id="numeroCartorio" required maxlength="50" placeholder="numero"
						value="${cartorio.numeroCartorio}">
				</div>

			</div>


			<div class="row">
				<!--<div class="form-group col-md-4">
					<label for="dataHoraFuncionamento">Horario de Funcionamento</label>
					<input type="text" class="form-control"
						name="dataHoraFuncionamento" id="dataHoraFuncionamento" required
						maxlength="50" placeholder="horario funcionamento"
						value="${cartorio.dataHoraFuncionamento}">
				</div>-->
				<div class="form-group col-md-2">
					<label for="telCartorio">Telefone</label> <input type="text"
						class="form-control" name="telCartorio" id="telCartorio" required
						maxlength="15" placeholder="informe o Telefone"
						value="${cartorio.telCartorio}">
				</div>

			
				<div class="form-group col-md-6">
					<label for="site">Site</label> <input type="text"
						class="form-control" name="site" id="site" required maxlength="50"
						placeholder="nome site" value="${cartorio.site}">

				</div>

			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="#">Descrição das Atividades Econômicas e
						Jurídicas</label>
					<textarea class="form-control" rows="3" name="dataHoraFuncionamento" id="dataHoraFuncionamento" required
						maxlength="200" placeholder="Maximo de 200 caracteres">${cartorio.dataHoraFuncionamento}</textarea>
				</div>
			</div>


			<h3 class="page-header">Endereço completo</h3>
			<div class="row">
				<div class="form-group col-md-2">
					<label for="tabeliaoCPF">CEP</label> <input type="text"
						class="form-control" name="tabeliaoCPF" id="tabeliaoCPF" required
						maxlength="9" placeholder="00000-000"
						value="${cartorio.tabeliaoCPF}">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="logradouro">Logradouro</label> <input type="text"
						class="form-control" name="logradouro" id="logradouro" required
						maxlength="50" placeholder="informe o Logradouro"
						value="${cartorio.logradouro}">
				</div>

			</div>

			<div class="row">
				<div class="form-group col-md-4">
					<label for="cidade">Cidade</label> <input type="text"
						class="form-control" name="cidade" id="cidade" required
						maxlength="20" placeholder="informe a Cidade"
						value="${cartorio.cidade}">
				</div>
				<div class="form-group col-md-2">
					<label for="estado">Estado</label> <input type="text"
						class="form-control" name="estado" id="estado" required
						maxlength="2" placeholder="UF" value="${cartorio.estado}">
				</div>

			</div>
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command"
						value="AlterarCartorio">Salvar</button>
					<a href="ListarCartorio.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
			<br><br>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>