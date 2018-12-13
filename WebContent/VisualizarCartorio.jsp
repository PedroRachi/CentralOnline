<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cerveja.biz - Visualizar Cartorio</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
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
					<h4 class="modal-title" id="modalLabel">Excluir cartorio</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este
					cartorio?</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" value="${cartorio.id}" />
						<button type="submit" class="btn btn-primary" name="command"
							value="ExcluirCartorio">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Visualizar cartorio
			${cartorio.razaoSocial}</h3>
		<div class="row">
			<div class="col-md-2">
				<p>
					<strong>CNPJ do Cartorio</strong>
				</p>
				<p>${cartorio.cartorioCNPJ}</p>
			</div>


			<div class="col-md-2">
				<p>
					<strong>senha acesso</strong>
				</p>
				<p>${cartorio.senhaAcesso}</p>
			</div>


			<div class="col-md-2">
				<p>
					<strong>tipo de perfil</strong>
				</p>
				<p>${cartorio.tipoPerfil}</p>
			</div>

			<div class="col-md-2">
				<p>
					<strong>numeroCartorio</strong>
				</p>
				<p>${cartorio.numeroCartorio}</p>
			</div>

			<div class="col-md-2">
				<p>
					<strong>Nome Cartorio</strong>
				</p>
				<p>${cartorio.razaoSocial}</p>
			</div>


			<div class="col-md-2">
				<p>
					<strong>Logradouro</strong>
				</p>
				<p>${cartorio.logradouro}</p>
			</div>
			<h3 class="page-header"></h3>
			<h3 class="page-header"></h3>

			<div class="col-md-2">
				<p>
					<strong>Cidade</strong>
				</p>
				<p>${cartorio.cidade}</p>
			</div>


			<div class="col-md-2">
				<p>
					<strong>Estado</strong>
				</p>
				<p>${cartorio.estado}</p>
			</div>


			<div class="col-md-2">
				<p>
					<strong>Cep</strong>
				</p>
				<p>${cartorio.cep}</p>
			</div>


			<div class="col-ls-2">
				<p>
					<strong>Nome do Tabeliao</strong>
				</p>
				<p>${cartorio.tabeliaoNome}</p>
			</div>
			<h3 class="page-header"></h3>
			<h3 class="page-header"></h3>

			<div class="col-md-2">
				<p>
					<strong>CPF do Tabeliao</strong>
				</p>
				<p>${cartorio.tabeliaoCPF}</p>
			</div>


			<div class="col-md-3">
				<p>
					<strong>Email do Tabeliao</strong>
				</p>
				<p>${cartorio.tabeliaoEmail}</p>
			</div>


			<div class="col-md-2">
				<p>
					<strong>Nome do Substituto</strong>
				</p>
				<p>${cartorio.substitutoNome}</p>
			</div>


			<div class="col-md-2">
				<p>
					<strong>CPF do Substituto</strong>
				</p>
				<p>${cartorio.substitutoCPF}</p>
			</div>
			

			<div class="col-md-2">
				<p>
					<strong>Email do Substituto</strong>
				</p>
				<p>${cartorio.substitutoEmail}</p>
			</div>
			<br>
			<h3 class="page-header"></h3>
			<h3 class="page-header"></h3>

			<div class="col-md-2">
				<p>
					<strong>Telefone do Cartorio</strong>
				</p>
				<p>${cartorio.telCartorio}</p>
			</div>
		

			<div class="col-md-2">
				<p>
					<strong>Situacao Cadastral</strong>
				</p>
				<p>${cartorio.situacaoCadastral}</p>
			</div>
		

			<div class="col-md-2">
				<p>
					<strong>Site</strong>
				</p>
				<p>${cartorio.site}</p>
			</div>
		

			<div class="col-md-2">
				<p>
					<strong>Descrição da Atividade</strong>
				</p>
				<p>${cartorio.dataHoraFuncionamento}</p>
			</div>
			<br />
		</div>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="controller.do?command=EditarCartorio&id=${cartorio.id}"
					class="btn btn-primary">Editar</a> <a href="#"
					class="btn btn-danger" data-toggle="modal"
					data-target="#delete-modal">Excluir</a> <a
					href="ListarCartorio.jsp" class="btn btn-default">Voltar</a>
			</div>
		</div>
		<br><br>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>