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

		<h3 class="page-header">Formulario de Pré Cadastro</h3>
		<!-- Formulario para inclusao de Empresa -->


        <div class="alert-info" role="alert">
					<h9>${mensagem}</h9>
				</div>
        
        
        
        
		<div class="alert alert-danger">
			<strong>Atenção!</strong> Considere os Campos com asterisco (*)
			campos obrigatorios.
		</div>

		<form action="cadastro.do" method="post" onSubmit="return validarFormulario()" >

			<h4 class="page-header">Tipo Cadastro</h4>
			<div class="row">
				<div class="form-group col-md-4">
					<div class="form-check">
						<input name="tipoCadastro" type="radio" class="with-gap"
							id="tipoCadastro" data-toggle="modal" data-target="#ModalEmpresa"
							value="EMPRESA"> <label for="radio106">Empresa</label>




						&nbsp;&nbsp;&nbsp; <input name="tipoCadastro" type="radio"
							class="with-gap" id="tipoCadastro" data-toggle="modal"
							data-target="#ModalCartorio" value="CARTORIO"> <label
							for="radio106">Cartório</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-2">
					<label for="empresaCNPJ">CNPJ*</label> <input type="text"
						name="empresaCNPJ" id="empresaCNPJ" placeholder="CNPJ"
						onkeyup="FormataCnpj(this,event)"
						onblur="if(!validarCNPJ(this.value)){alert('CNPJ Informado é inválido'); this.value='';}"
						maxlength="18" class="form-control input-md" required>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="razaoSocial">Razão Social*</label> <input type="text"
						class="form-control" name="razaoSocial" id="razaoSocial" required
						maxlength="100" placeholder="digite a razão social">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="contatoPrincipalEmail">E-mail*</label> <input
						type="text" class="form-control" name="contatoPrincipalEmail"
						id="contatoPrincipalEmail" required maxlength="100"
						placeholder="digite seu e-mail">
				</div>
			</div>
			<hr />
			<input type="checkbox" name="termo" value="male" id="termo">

			<strong>Li e concordo com os termos</strong>


			<hr />

			<div id="actions" class="row">
				<div class="form-group col-md-10">
					<div class="alert alert-info">
						<strong>Importante!</strong> Após clicar em salvar, aguarde a
						avaliação dos seus dados para concluir o cadastro.<strong>
							A central agradece!</strong>
					</div>
				</div>

				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command"
						value="CriarPreCadastro">Salvar</button>
					<a href="index.jsp" class="btn btn-default">Cancelar</a>

				</div>
		
		</div>
		</form>
		
	</div>
	
				<!-- MODAL TERMO DE ADESÃO EMPRESA -->

				<div class="modal fade" id="ModalEmpresa" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title text-center" id="myModalLabel">
									<strong>Empresa</strong>
								</h4>
								<br/>
								<h4 class="modal-title text-center" id="myModalLabel">
									Leia atentamente o Termo antes de realizar seu <strong>Pré
										Cadastro</strong>
								</h4>
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



				<!-- MODAL TERMO DE ADESÃO CARTORIO -->
				<div class="modal fade" id="ModalCartorio" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								
								<h4 class="modal-title text-center" id="myModalLabel">
									<strong>Cartorio</strong>
								</h4>
								
								<br/>
								
								<h4 class="modal-title text-center" id="myModalLabel">
									Leia atentamente o Termo antes de realizar seu <strong>Pré
										Cadastro</strong>
								</h4>
							</div>
							<div class="modal-body">

								<p>
									<strong>1. Aceitação das Condições de Uso</strong>
								</p>
								<p>A cartório já qualificado na ficha pré-cadastral afirma
									que após aceitar o termo de adesão que todas informações
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
									prestadas ao nosso serviço.</p>
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
			
	<hr />
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>

</html>