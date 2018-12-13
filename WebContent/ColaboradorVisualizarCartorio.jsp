<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cerveja.biz - Criar Cartorio</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script type="text/javascript" src="js/funcao.js"></script>
</head>

<body>

	<!-- Container Principal -->
		<c:import url="MenuUsuarioCartorio.jsp" />
	<div id="main" class="container">
		
		<!-- Formulario para inclusao de Cartorio -->
		<form action="controller.do" method="post">
           
			<!-- area de campos do form -->
			
			<input type="hidden" name="id" value="${cartorio.id}" />
			
			<h3 class="page-header">Dados ${cartorio.tipoPerfil} CNPJ
				Cadastrado na Central ${cartorio.cartorioCNPJ}</h3>

			
			<h3 class="page-header">Dados do Tabelião</h3>

			<div class="row">
				<div class="form-group col-md-2">
					<label for="tabeliaoNome">Nome*</label> <input type="text"
						class="form-control" name="tabeliaoNome" id="tabeliaoNome"
						required maxlength="50" placeholder="nome completo"
						value="${cartorio.tabeliaoNome}" readonly="true">
				</div>
			

		
				<div class="form-group col-md-4">
					<label for="tabeliaoEmail">Email</label> <input type="text"
						class="form-control" name="tabeliaoEmail" id="tabeliaoEmail"
						required maxlength="50" placeholder="e-mail completo"
						value="${cartorio.tabeliaoEmail}" readonly="true">
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
						value="${cartorio.substitutoNome}" readonly="true">
				</div>
			
				<div class="form-group col-md-4">
					<label for="substitutoEmail">Email</label> <input type="text"
						class="form-control" name="substitutoEmail" id="substitutoEmail"
						required maxlength="50" placeholder="e-mail completo"
						value="${cartorio.substitutoEmail}" readonly="true">
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
				<div class="form-group col-md-4">
					<label for="razaoSocial">Razão Social*</label> <input type="text"
						class="form-control" name="razaoSocial" id="razaoSocial" required
						maxlength="100" placeholder="digite a razão social"
						value="${cartorio.razaoSocial }" readonly="true">
				</div>

				<div class="form-group col-md-2">
					<label for="numeroCartorio">Numero do Cartorio</label> <input
						type="text" class="form-control" name="numeroCartorio"
						id="numeroCartorio" required maxlength="50" placeholder="numero"
						value="${cartorio.numeroCartorio}" readonly="true">
				</div>

			</div>


			<div class="row">
				<div class="form-group col-md-4">
					<label for="dataHoraFuncionamento">Horario de Funcionamento</label>
					<input type="text" class="form-control"
						name="dataHoraFuncionamento" id="dataHoraFuncionamento" required
						maxlength="50" placeholder="horario funcionamento"
						value="${cartorio.dataHoraFuncionamento}" readonly="true">
				</div>
				<div class="form-group col-md-2">
					<label for="#">Telefone</label> <input type="text"
						class="form-control" name="telCartorio" id="telCartorio" required
						maxlength="15" placeholder="informe o Telefone"
						value="${cartorio.telCartorio}" readonly="true">
				</div>

			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="site">Nome do site</label> <input type="text"
						class="form-control" name="site" id="site" required maxlength="50"
						placeholder="nome site" value="${cartorio.site}" readonly="true">

				</div>

			</div>






   <!-- ADICIONAR ESSE CAMPO NO BANCO DE DADOS
			<div class="row">
				<div class="form-group col-md-6">
					<label for="#">Descrição das Atividades Econômicas e
						Jurídicas</label>
					<textarea class="form-control" rows="3" name="#" id="#" required
						maxlength="200" placeholder="Maximo de 200 caracteres"
						value="${cartorio.cartorioCNPJ}"></textarea>
				</div>
			</div>

 -->







			<h3 class="page-header">Endereço completo</h3>
			<div class="row">
				<div class="form-group col-md-2">
					<label for="cep">CEP</label> <input type="text"
						class="form-control" name="cep" id="cep" required maxlength="9"
						placeholder="00000-000" value="${cartorio.cep}" readonly="true">
				</div>
			
				<div class="form-group col-md-4">
					<label for="logradouro">Logradouro</label> <input type="text"
						class="form-control" name="logradouro" id="logradouro" required
						maxlength="50" placeholder="informe o Logradouro"
						value="${cartorio.logradouro}" readonly="true">
				</div>

			</div>

			<div class="row">
				<div class="form-group col-md-4">
					<label for="cidade">Cidade</label> <input type="text"
						class="form-control" name="cidade" id="cidade" required
						maxlength="20" placeholder="informe a Cidade"
						value="${cartorio.cidade}" readonly="true">
				</div>
				<div class="form-group col-md-2">
					<label for="estado">Estado</label> <input type="text"
						class="form-control" name="estado" id="estado" required
						maxlength="2" placeholder="UF" value="${cartorio.estado}" readonly="true"> 
				</div>

			</div>

			<hr />

		

			
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
							seu Cartorio?</div>
						<div class="modal-footer">
							<form action="cadastro.do" method="post">
								<button type="submit" class="btn btn-primary" name="command"
									value="AlterarCartorioLogado">Sim</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">N&atilde;o</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal -->
			
			
		</form>
	</div>


	<hr />
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/funcao.js"></script>
</body>

</html>