<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cerveja.biz - Empresa</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/TelaCadastrado.css" rel="stylesheet">
</head>

<body>
	<div id="main" class="container-fluid">


		<div id="links">
			<ul>
				<li><a class="active" href="#home">Home</a></li>
				<li onclick="mostraResposta('usuarioAdicional')"><a href="#">Colaborador</a></li>
				<li onclick="mostraResposta('condicoesUso')"><a href="#">Condições de uso</a></li>
				<li onclick="mostraResposta('manutencao')"><a href="#">Manutenção</a></li>
				<li><a href="#">Colaboradores</a></li>
				<li><a href="#">Contato</a></li>
				<li><a href="TelaPrincipalDefinitiva.jsp">Sair</a></li>


			</ul>
		</div>

		<!-- INICIO TELA DE USUARIO ADICIONA -->

		<div id="conteudo">
			<div id="usuarioAdicional" class="faq">
				<div style="margin-left: 20%; padding: 1px 16px; height: 0px;">
					<!-- Formulario para inclusao de clientes -->
					<form action="controller.do" method="post">
						<!-- area de campos do form -->

						<div class="row">
							<div class="form-group col-md-8 ">
								<h3 class="page-header">Incluir Colaborador</h3>

								<label for="nome">Nome Completo</label> <input type="text"
									class="form-control" name="nomeUsuario" id="nomeUsuario" required
									maxlength="100" placeholder="nome completo">
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-4">
								<label for="fone">CPF</label> <input type="text"
									class="form-control" name="documentoCPFCNPJ" id="documentoCPFCNPJ" maxlength="15"
									pattern="#" placeholder="#">
							</div>

							<div class="form-group col-md-4">
								<label for="email">E-Mail</label> <input type="email"
									class="form-control" name="emailUsuario" id="emailUsuario" required
									maxlength="60" placeholder="email obrigatório">
							</div>
						</div>
							<div class="form-group">
							    <div class="form-group col-md-4">
								<label for="exampleSelect1">Tipo de Usuario</label> <select
									class="form-control" id="exampleSelect1">
									<option>--Selecione--</option>
									<option id="tipoPerfil" value="empresadono">Dono</option>
									<option id="tipoPerfil" value="empresacolaborador">Colaborador</option>
									
								</select>
							</div>
							</div>
						
						<br /> <br />

						<div id="actions" class="row">
							<div class="col-md-12">
								<button type="submit" class="btn btn-primary" name="command"
									value="CriarUsuarioAdicional">Salvar</button>
								<a href="index.jsp" class="btn btn-default">Cancelar</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<!-- FINAL TELA DE USUARIO ADICIONA -->
         
       


		<!-- INICIO TELA CONDIÇÕES DE USO (Termo de adesão) -->
		
		<div id="conteudo">
			<div id="condicoesUso" class="faq">
		<a data-toggle="modal"
					data-target="#myModal"> Termo de Adesão </a>
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
								<h4 class="modal-title text-center" id="myModalLabel">Termo
									de Adesão</h4>
							</div>
							<div class="modal-body">
							
								<p><strong>1. Aceitação das Condições de Uso</strong></p>
										<p>A empresa já qualificado na ficha pre-cadastral afirma que apos aceitar o
										termo de adesao que todas informações prestadas ao site são verídicas para
										presente termo para realização cadastral em nosso site. Ao usar tal Sistema, o usuário está
										ciente de que estará sujeito aos manuais e regras aplicáveis a ele. O usuário assume que
										leu e concordou com a versão mais recente do Termo e se vincula, automática e
										irrevogavelmente, às regras nele contidas. com as seguintes cláusulas e condições.</p>
								<p><strong>2. Descrição do serviço</strong></p>
										<p>Através do Sistema de Central Online de ME e EPP, que coleta e armazena informações de
										empresas e cartórios, necessárias ao cumprimento de seu serviço: Para promover cadastro
										de empresas e cartórios. Para realização de uma comunicação mais ágil entre os mesmos;
										assegurando informações prestadas ao nosso serviço.
								<p><strong>3. Senha e segurança</strong></p>
										<p>​3.1. Todo usuário que utilizar o serviço é responsável pela guarda segura e pela
										confidencialidade da sua senha, além de ser inteiramente responsável por toda e qualquer
										atividade, lançamento e registro de informações que ocorram sob o uso da mesma,
										inclusive para efeitos legais.</p>
										<p>3.2. O usuário concorda em notificar imediatamente ao ADM sobre qualquer uso não
										autorizado da sua senha ou qualquer quebra de segurança de que tome conhecimento.
										<p>3.3. O ADM não será responsável por qualquer perda que possa ocorrer como
										conseqüência do uso não-autorizado por terceiros de sua senha, com ou sem seu
										conhecimento.</p>
										<p>3.4. Para proteger o sigilo de sua senha, recomenda-se ao usuário: a) sair de sua conta ao
										final de cada sessão e assegurar que a mesma não seja acessada por terceiros não
										autorizados; e, b) não informar sua senha, nem mesmo ao ADM, por e-mail, telefone ou
										outros meios.</p>


							</div>
						</div>
					</div>
				</div>
				</div>
		<!-- FINAL TELA CONDIÇÕES DE USO (Termo de adesão) -->


		<!-- INICIO TELA MANUTENÇÃO DADOS CADASTRADOS -->

		<div id="conteudo">
			<div id="manutencao" class="faq">
				<div style="margin-left: 20%; padding: 1px 16px; height: 0px;">
					<!-- area de campos do form -->

					<!--<input type="hidden" name="id"  value="$" />
			<div class="row">
				<div class="form-group col-md-12">
					<label for="nome">Nome</label> <input type="text"
						class="form-control" name="nome" id="nome" required
						maxlength="100" placeholder="nome completo" value="$">
				</div>
			</div>-->

					<!-- Formulario para inclusao de Empresa -->

					<form action="controller.do" method="post">

						<!-- area de campos do form -->
						<h3 class="page-header">Dados de Login</h3>

						<div class="row">
							<div class="form-group col-md-2">
								<label for="empresaCNPJ">CNPJ*</label> <input type="text"
									class="form-control" name="empresaCNPJ" id="empresaCNPJ"
									required maxlength="14" placeholder="CNPJ" value="${empresa.empresaCNPJ}">
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-4">
								<label for="senhaAcesso">Senha de acesso*</label> <input
									type="text" class="form-control" name="senhaAcesso"
									id="senhaAcesso" required maxlength="20" placeholder="Senha"
									value=" ">
							</div>

						</div>


						<h3 class="page-header">Dados da Empresa</h3>

						<div class="row">
							<div class="form-group col-md-6">
								<label for="razaoSocial">Razão Social*</label> <input
									type="text" class="form-control" name="razaoSocial"
									id="razaoSocial" required maxlength="100"
									placeholder="digite a razão social" value="${empresa.razaoSocial}">
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-6">
								<label for="contatoPrincipalNome">Nome</label> <input
									type="text" class="form-control" name="contatoPrincipalNome"
									id="contatoPrincipalNome" required maxlength="30"
									placeholder="nome completo" value="${empresa.contatoPrincipalNome} ">

							</div>
							<div class="form-group col-md-6">
								<label for="contatoPrincipalEmail">E-Mail</label> <input
									type="email" class="form-control" name="contatoPrincipalEmail"
									id="contatoPrincipalEmail" required maxlength="50"
									placeholder="email obrigatório" value="${empresa.contatoPrincipalEmail}">
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-4">
								<label for="contatoPrincipalCPF">CPF</label> <input type="text"
									class="form-control" name="contatoPrincipalCPF"
									id="contatoPrincipalCPF" required maxlength="14"
									placeholder="CPF" value="${empresa.contatoPrincipalCPF}">

							</div>
							<div class="form-group col-md-4">
								<label for="telEmpresa">Telefone</label> <input type="text"
									class="form-control" name="telEmpresa" id="telEmpresa" required
									maxlength="15" pattern="#" placeholder="informe o Telefone"
									value=" ${empresa.telefone}">
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-6">
								<label for="site">Nome do site</label> <input type="text"
									class="form-control" name="site" id="site" required
									maxlength="50" placeholder="nome site" value=" ${empresa.site}">

							</div>
							<div class="form-group col-md-6">
								<label for="dataAbertura">data de abertura</label> <input
									type="text" class="form-control" name="dataAbertura"
									id="dataAbertura" required maxlength="15" placeholder="Data de abertura"
									value="${empresa.dataAbertura} ">

							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label for="descriAtvEconomicas">Descrição das
									Atividades Econômicas e Jurídicas</label>
								<input type="text" class="form-control"
									name="descriAtvEconomicas" id="descriAtvEconomicas" required
									maxlength="200" placeholder="Maximo de 200 caracteres"
									value=" ${empresa.descriAtvEconomicas}">
							</div>
						</div>

						<h3 class="page-header">Endereço completo</h3>
						<div class="row">
							<div class="form-group col-md-2">
								<label for="cep">CEP</label> <input type="text"
									class="form-control" name="cep" id="cep" required maxlength="9"
									placeholder="00000-000" required pattern="#" value="${empresa.cep}" />
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-6">
								<label for="logradouro">Logradouro</label> <input type="text"
									class="form-control" name="logradouro" id="logradouro" required
									maxlength="50" placeholder="informe o Logradouro" value="${empresa.logradouro} ">
							</div>

						</div>

						<div class="row">
							<div class="form-group col-md-4">
								<label for="cidade">Cidade</label> <input type="text"
									class="form-control" name="cidade" id="cidade" required
									maxlength="20" placeholder="informe a Cidade" value="${empresa.cidade} ">
							</div>
							<div class="form-group col-md-2">
								<label for="estado">Estado</label> <input type="text"
									class="form-control" name="estado" id="estado" required
									maxlength="2" placeholder="UF" value=" ${empresa.estado}">
							</div>

						</div>

						<hr />

						<div id="actions" class="row">

							<div class="col-md-12">
								<button onclick="redirecionar();" type="submit"
									class="btn btn-primary" name="command" value="AlterarEmpresa">Salvar</button>
								<a href="index.jsp" class="btn btn-default">Cancelar</a>

							</div>



						</div>
						<br /> <br />
					</form>
				</div>
			</div>
		</div>

		<!-- FINAL TELA MANUTENÇÃO  DADOS CADASTRADOS -->






		<!--<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
		<h2>Nome Da Empresa</h2>
		<h3>Try to scroll this area, and see how the sidenav sticks to
			the page</h3>
		<p>Notice that this div element has a left margin of 25%. This is
			because the side navigation is set to 25% width. If you remove the
			margin, the sidenav will overlay/sit on top of this div.</p>
		<p>Also notice that we have set overflow:auto to sidenav. This
			will add a scrollbar when the sidenav is too long (for example if it
			has over 50 links inside of it).</p>

	</div>-->

	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function mostraResposta(id) {
			respostas = document.getElementsByClassName('faq'); //recupera todos elementos da classe faq
			for (var i = 0; i < respostas.length; i++) { // coloca todos eles invisiveis
				respostas[i].style.display = 'none';
			}

			clicada = document.getElementById(id); //recupera o id passado por argumento
			clicada.style.display = 'inherit'; //faz ele ser exibido conforme o item pai
		}
	</script>
</body>
</html>