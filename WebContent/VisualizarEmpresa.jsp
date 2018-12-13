<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cerveja.biz - Visualizar empresa</title>

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
					<h4 class="modal-title" id="modalLabel">Excluir empresa</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este empresa?
				</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" value="${empresa.id}" />
						<button type="submit" class="btn btn-primary" name="command"
							value="ExcluirEmpresa">Sim</button>
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
		<h3 class="page-header">Visualizar empresa ${empresa.razaoSocial}</h3>
		<div class="row">
			<div class="col-md-2">
				<p>
					<strong>CNPJ da Empresa</strong>
				</p>
				<p>${empresa.empresaCNPJ}</p>
			</div>
			<div class="col-md-2">
				<p>
					<strong>Razao Social</strong>
				</p>
				<p>${empresa.razaoSocial}</p>

			</div>

			<div class="col-md-2">
				<p>
					<strong>Logradouro</strong>
				</p>
				<p>${empresa.logradouro}</p>
			</div>

			<div class="col-md-2">
				<p>
					<strong>Cidade</strong>
				</p>
				<p>${empresa.cidade}</p>
			</div>

			<div class="col-md-2">
				<p>
					<strong>Estado</strong>
				</p>
				<p>${empresa.estado}</p>
			</div>

			<div class="col-md-2">
				<p>
					<strong>Cep</strong>
				</p>
				<p>${empresa.cep}</p>
			</div>
		</div>

		<h3 class="page-header"></h3>
		<h3 class="page-header"></h3>


		<div class="row">
			<div class="col-md-2">
				<p>
					<strong>Telefone Empresa</strong>
				</p>
				<p>${empresa.telefone}</p>
			</div>
		
			<div class="col-md-2">
				<p>
					<strong>Contato Principal Nome</strong>
				</p>
				<p>${empresa.contatoPrincipalNome}</p>
			</div>
		
			<div class="col-md-2">
				<p>
					<strong>Contato Principal CPF</strong>
				</p>
				<p>${empresa.contatoPrincipalCPF}</p>
			</div>
	
			<div class="col-md-2">
				<p>
					<strong>contatoPrincipalEmail</strong>
				</p>
				<p>${empresa.contatoPrincipalEmail}</p>
			</div>
	
			<div class="col-md-2">
				<p>
					<strong>Situacao Cadastral</strong>
				</p>
				<p>${empresa.situacaoCadastral}</p>
			</div>
		</div>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="controller.do?command=EditarEmpresa&id=${empresa.id}"
					class="btn btn-primary">Editar</a> <a href="#"
					class="btn btn-danger" data-toggle="modal"
					data-target="#delete-modal">Excluir</a> <a href="ListarEmpresa.jsp"
					class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>