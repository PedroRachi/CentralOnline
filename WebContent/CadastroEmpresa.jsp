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
<link href="css/style.css" rel="stylesheet">
<script type="text/javascript" src="js/funcao.js"></script>
</head>

<body>

	<!-- Container Principal -->

	<div id="main" class="container">

		<div class="alert alert-success">
			<h3>${mensagem}</h3>
		</div>

		<h3 class="page-header">Formulario de Cadastro</h3>
		<!-- Formulario para inclusao de Empresa -->
		<form action="cadastro.do" method="post" onSubmit="return validarFormulario()">

			<!-- area de campos do form -->

			<h5>Considere os Campos com asterisco (*) campos obrigatorios.</h5>

			<h3 class="page-header">Dados de Login</h3>

			<!--<div class="col-md-4">
				<p>
					<strong>empresaCNPJ</strong>
				</p>
				<p>${empresa.empresaCNPJ }</p>
			</div>-->


			<div class="row">
				<div class="form-group col-md-2">
					<label for="empresaCNPJ">CNPJ*</label> <input type="text"
						class="form-control" name="empresaCNPJ" id="empresaCNPJ"
						placeholder="CNPJ" onkeyup="FormataCnpj(this,event)"
						onblur="if(!validarCNPJ(this.value)){alert('CNPJ Informado é inválido'); this.value='';}"
						maxlength="18" class="form-control input-md"
						ng-model="cadastro.cnpj" required value="${empresa.empresaCNPJ}"
						readonly="true">
				</div>



				<div class="form-group col-md-2">
					<label for="id">Cadastro*</label> <input type="text"
						class="form-control" name="id" id="id" required maxlength="14"
						value="${empresa.id}" readonly="true">
				</div>




				<div class="form-group col-md-2">
					<label for="tipoPerfil">Perfil*</label> <input type="text"
						class="form-control" name="tipoPerfil" id="tipoPerfil" required
						maxlength="14" placeholder="CNPJ" value="${empresa.tipoPerfil}"
						readonly="true">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-4">
					<label for="senhaAcesso">Senha de acesso*</label> <input
						type="password" class="form-control" name="senhaAcesso"
						id="senhaAcesso" required maxlength="20" placeholder="Senha">
				</div>

			</div>


			<h3 class="page-header">Dados da Empresa</h3>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="razaoSocial">Razão Social*</label> <input type="text"
						class="form-control" name="razaoSocial" id="razaoSocial" required
						maxlength="100" placeholder="digite a razão social"
						value="${empresa.razaoSocial }">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="contatoPrincipalNome">Nome</label> <input type="text"
						class="form-control" name="contatoPrincipalNome"
						id="contatoPrincipalNome" required maxlength="30"
						placeholder="nome completo">

				</div>
				<div class="form-group col-md-6">
					<label for="contatoPrincipalEmail">E-Mail</label> <input
						type="email" class="form-control" name="contatoPrincipalEmail"
						id="contatoPrincipalEmail" required maxlength="50"
						placeholder="email obrigatório"
						value="${empresa.contatoPrincipalEmail }">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-4">
					<label for="contatoPrincipalCPF">CPF</label> <input type="text"
						class="form-control" name="contatoPrincipalCPF"
						id="contatoPrincipalCPF" required maxlength="14" placeholder="CPF">

				</div>
				<div class="form-group col-md-4">
					<label for="telEmpresa">Telefone</label> <input type="text"
						class="form-control" name="telEmpresa" id="telEmpresa" required
						maxlength="15" placeholder="informe o Telefone">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="site">Nome do site</label> <input type="text"
						class="form-control" name="site" id="site" required maxlength="50"
						placeholder="nome site">

				</div>
				
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="descriAtvEconomicas">Descrição das Atividades
						Econômicas e Jurídicas</label>
					<textarea class="form-control" rows="3" name="descriAtvEconomicas"
						id="descriAtvEconomicas" required maxlength="200"
						placeholder="Maximo de 200 caracteres"></textarea>
				</div>
			</div>

			<h3 class="page-header">Endereço completo</h3>
			<div class="row">
				<div class="form-group col-md-2">
					<label for="cep">CEP</label> <input type="text"
						class="form-control" name="cep" id="cep" required maxlength="9"
						placeholder="00000-000" />
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="logradouro">Logradouro</label> <input type="text"
						class="form-control" name="logradouro" id="logradouro" required
						maxlength="50" placeholder="informe o Logradouro">
				</div>

			</div>

			<div class="row">
				<div class="form-group col-md-4">
					<label for="cidade">Cidade</label> <input type="text"
						class="form-control" name="cidade" id="cidade" required
						maxlength="20" placeholder="informe a Cidade">
				</div>
				<div class="form-group col-md-2">
					<label for="estado">Estado</label> <input type="text"
						class="form-control" name="estado" id="estado" required
						maxlength="2" placeholder="UF">
				</div>

			</div>

			<h4>

				Para efetivar o Cadastro leia atentamente o<a data-toggle="modal"
					data-target="#myModal"> Termo de Adesão </a>
			</h4>

			<input type="checkbox" name="termo" value="male" id="termo">
			Li e concordo com os termos



			<hr />

			<div id="actions" class="row">

				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command"
						value="EmpresaAposPreCadastro">Salvar</button>
					<a href="index.jsp" class="btn btn-default">Cancelar</a>
					<!-- <button type="submit" class="btn btn-primary" name="command" value="AlterarEmpresa">Salvar</button>
                                <a href="ListarEmpresa.jsp" class="btn btn-default">Cancelar</a> -->


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
								<h4 class="modal-title text-center" id="myModalLabel">Termo
									de Adesão</h4>
							</div>
							<div class="modal-body">

								<p>
									<strong>1. Aceitação das Condições de Uso</strong>
								</p>
								<p>A empresa já qualificado na ficha pre-cadastral afirma
									que apos aceitar o termo de adesao que todas informações
									prestadas ao site são verídicas para presente termo para
									realização cadastral em nosso site. Ao usar tal Sistema, o
									usuário está ciente de que estará sujeito aos manuais e regras
									aplicáveis a ele. O usuário assume que leu e concordou com a
									versão mais recente do Termo e se vincula, automática e
									irrevogavelmente, às regras nele contidas. com as seguintes
									cláusulas e condições.</p>
								<p>
									<strong>2. Descrição do serviço</strong>
								</p>
								<p>Através do Sistema de Central Online de ME e EPP, que
									coleta e armazena informações de empresas e cartórios,
									necessárias ao cumprimento de seu serviço: Para promover
									cadastro de empresas e cartórios. Para realização de uma
									comunicação mais ágil entre os mesmos; assegurando informações
									prestadas ao nosso serviço.
								<p>
									<strong>3. Senha e segurança</strong>
								</p>
								<p>​3.1. Todo usuário que utilizar o serviço é responsável
									pela guarda segura e pela confidencialidade da sua senha, além
									de ser inteiramente responsável por toda e qualquer atividade,
									lançamento e registro de informações que ocorram sob o uso da
									mesma, inclusive para efeitos legais.</p>
								<p>3.2. O usuário concorda em notificar imediatamente ao ADM
									sobre qualquer uso não autorizado da sua senha ou qualquer
									quebra de segurança de que tome conhecimento.
								<p>3.3. O ADM não será responsável por qualquer perda que
									possa ocorrer como conseqüência do uso não-autorizado por
									terceiros de sua senha, com ou sem seu conhecimento.</p>
								<p>3.4. Para proteger o sigilo de sua senha, recomenda-se ao
									usuário: a) sair de sua conta ao final de cada sessão e
									assegurar que a mesma não seja acessada por terceiros não
									autorizados; e, b) não informar sua senha, nem mesmo ao ADM,
									por e-mail, telefone ou outros meios.</p>


							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>


	<hr />
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>