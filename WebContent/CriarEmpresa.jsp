<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cerveja.biz - Criar Pais</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="MenuTelaPrincipal.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Incluir empresa</h3>

		<form action="cadastro.do" method="post">



			<!-- <div class="row">
				<div class="col-md-12">
					<p>
						<strong>cnpj</strong>
					</p>
					<p>${empresa.empresaCNPJ}</p>
				</div>
			</div> -->


			<div class="row">
				<div class="form-group col-md-6">
					<label for="razaoSocial">razaosocial</label> <input type="text"
						class="form-control" name="razaoSocial" id="razaoSocial"
						placeholder="pop pais"" >
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="area">logradouro</label> <input type="text"
						class="form-control" name="logradouro" id="logradouro" required
						maxlength="60" placeholder="area">
				</div>
				<div class="form-group col-md-6">
					<label for="populacao">cidade</label> <input type="text"
						class="form-control" name="cidade" id="cidade"
						placeholder="pop pais">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="populacao">estado</label> <input type="text"
						class="form-control" name="estado" id="estado"
						placeholder="pop pais">
				</div>
				<div class="form-group col-md-6">
					<label for="populacao">cep</label> <input type="text"
						class="form-control" name="cep" id="cep" placeholder="pop pais">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="populacao">telefone</label> <input type="text"
						class="form-control" name="telefone" id="telefone"
						placeholder="pop pais">
				</div>
				<div class="form-group col-md-6">
					<label for="populacao">contatoPrincipalNome</label> <input
						type="text" class="form-control" name="contatoPrincipalNome"
						id="contatoPrincipalNome" placeholder="pop pais">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="populacao">contatoPrincipalCPF</label> <input
						type="text" class="form-control" name="contatoPrincipalCPF"
						id="contatoPrincipalCPF" placeholder="pop pais">
				</div>
			</div>

			<div class="form-group col-md-6">
				<label for="populacao">contatoPrincipalEmail</label> <input
					type="text" class="form-control" name="contatoPrincipalEmail"
					id="contatoPrincipalEmail" placeholder="pop pais">
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="populacao">site</label> <input type="text"
						class="form-control" name="site" id="site" placeholder="pop pais">
				</div>
				<div class="form-group col-md-6">
					<label for="populacao">contatoPrincipalEmail</label> <input
						type="text" class="form-control" name="dataAbertura"
						id="dataAbertura" placeholder="pop pais">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="populacao">descriAtvEconomicas</label> <input
						type="text" class="form-control" name="descriAtvEconomicas"
						id="descriAtvEconomicas" placeholder="pop pais">
				</div>

			</div>
			<h4>
				Para efetivar o Cadastro leia atentamente o<a data-toggle="modal"
					data-target="#myModal"> Termo de Adesão </a>
			</h4>

			<input type="checkbox" name="termo" value="male" id="termo" required>
			Li e concordo com os termos
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command"
						value="CriarEmpresa">Salvar</button>
					<a href="index.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title text-center" id="myModalLabel">Termo de
						Adesão</h4>
				</div>
				<div class="modal-body">

					<p>
						<strong>1. Aceitação das Condições de Uso</strong>
					</p>
					<p>A empresa já qualificado na ficha pre-cadastral afirma que
						apos aceitar o termo de adesao que todas informações prestadas ao
						site são verídicas para presente termo para realização cadastral
						em nosso site. Ao usar tal Sistema, o usuário está ciente de que
						estará sujeito aos manuais e regras aplicáveis a ele. O usuário
						assume que leu e concordou com a versão mais recente do Termo e se
						vincula, automática e irrevogavelmente, às regras nele contidas.
						com as seguintes cláusulas e condições.</p>
					<p>
						<strong>2. Descrição do serviço</strong>
					</p>
					<p>Através do Sistema de Central Online de ME e EPP, que coleta
						e armazena informações de empresas e cartórios, necessárias ao
						cumprimento de seu serviço: Para promover cadastro de empresas e
						cartórios. Para realização de uma comunicação mais ágil entre os
						mesmos; assegurando informações prestadas ao nosso serviço.
					<p>
						<strong>3. Senha e segurança</strong>
					</p>
					<p>​3.1. Todo usuário que utilizar o serviço é responsável pela
						guarda segura e pela confidencialidade da sua senha, além de ser
						inteiramente responsável por toda e qualquer atividade, lançamento
						e registro de informações que ocorram sob o uso da mesma,
						inclusive para efeitos legais.</p>
					<p>3.2. O usuário concorda em notificar imediatamente ao ADM
						sobre qualquer uso não autorizado da sua senha ou qualquer quebra
						de segurança de que tome conhecimento.
					<p>3.3. O ADM não será responsável por qualquer perda que possa
						ocorrer como conseqüência do uso não-autorizado por terceiros de
						sua senha, com ou sem seu conhecimento.</p>
					<p>3.4. Para proteger o sigilo de sua senha, recomenda-se ao
						usuário: a) sair de sua conta ao final de cada sessão e assegurar
						que a mesma não seja acessada por terceiros não autorizados; e, b)
						não informar sua senha, nem mesmo ao ADM, por e-mail, telefone ou
						outros meios.</p>


				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>