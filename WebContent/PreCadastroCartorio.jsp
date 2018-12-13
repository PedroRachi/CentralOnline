<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cartorio</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script type="text/javascript" src="js/funcao.js"></script>

</head>

<body>

	<!-- Container Principal -->

	<div id="main" class="container">

		<h3 class="page-header">Formulario de Pré Cadastro</h3>
		<!-- Formulario para inclusao de Empresa -->



		<div class="alert alert-danger">
			<strong>Atenção!</strong> Considere os Campos com asterisco (*)
			campos obrigatorios.
		</div>

		<form action="controller.do" method="post">
			<!-- area de campos do form -->



			<h3 class="page-header">Dados de Login</h3>

			<div class="row">
				<div class="form-group col-md-2">
					<label for="cartorioCNPJ">CNPJ*</label> <input type="text"
						name="cartorioCNPJ" id="cartorioCNPJ"
						onkeyup="FormataCnpj(this,event)"
						onblur="if(!validarCNPJ(this.value)){alert('CNPJ Informado é inválido'); this.value='';}"
						maxlength="18" class="form-control input-md"
						placeholder="digite o CNPJ">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-4">
					<label for="senhaAcesso">Senha de acesso*</label> <input
						type="text" class="form-control" name="senhaAcesso"
						id="senhaAcesso" required maxlength="20" placeholder="Senha">
				</div>

			</div>


			<h3 class="page-header">Dados da Cartorio</h3>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="nomeCartorio">Nome do Cartorio*</label> <input
						type="text" class="form-control" name="nomeCartorio"
						id="nomeCartorio" required maxlength="100"
						placeholder="digite o nome do cartorio">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="cartorioEmail">E-mail*</label> <input type="text"
						class="form-control" name="cartorioEmail" id="cartorioEmail"
						required maxlength="100" placeholder="digite seu e-mail">
				</div>

			</div>
		</form>

		<h4>

			Para efetivar o Pre-Cadastro leia atentamente o<a data-toggle="modal"
				data-target="#myModal"> Termo </a>
		</h4>

		<input type="checkbox" name="termo" value="male" id="termo">
		Li e concordo com os termos



		<hr />

		<div id="actions" class="row">
			<div class="form-group col-md-10">
				<div class="alert alert-info">
					<strong>Importante!</strong> Após clicar em salvar, aguarde a
					avaliação dos seus dados para concluir o cadastro da sua Empresa, a
					central agradece!
				</div>
			</div>

			<div class="col-md-12">
				<button onclick="redirecionar();" type="submit"
					class="btn btn-primary" name="#" value="#">Salvar</button>
				<a href="TelaPrincipalDefinitiva.jsp" class="btn btn-default">Cancelar</a>

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

							<h3>Este termo de adesão é apenas um exemplo</h3>
							<br>

							<p>Pelo presente,[número do CNPJ] com sede na [endereço da
								Instituição], declara, para os devidos fins, que está ciente e
								conforme com todos os termos, cláusulas, condições e normas do
								Código ABVCAP/ANBIMA de Regulação em Melhores Práticas para o
								Mercado de Fundos de Investimento em Participação e Fundos de
								Investimento em Empresas Emergentes, aderindo assim, em caráter
								irrevogável e irretratável, a seus respectivos teores integrais
								– inclusive a novas versões que venham a ser editadas, salvo
								manifestação contrária a ser expressa à ABVCAP ou ANBIMA –,
								obrigando-se a respeitá-los e a cumpri-los fielmente, assumindo
								todos os direitos e obrigações deles decorrentes, e
								sujeitando-se às penalidades cabíveis, quando e se for o caso.</p>

							<p>Ao firmar o presente, o(s) representante(s) da instituição
								atesta(m) perante a ABVCAP e a ANBIMA, para todos os fins e
								efeitos, ter os poderes necessários e suficientes para
								validamente vinculá-la nos termos da declaração dada neste
								documento, conforme disposto [mencionar o documento e anexar, se
								for o caso] nos instrumentos constitutivos e documentação
								societária pertinente da instituição, e que tais documentos
								estão regularmente em vigor e entregues neste ato à ANBIMA</p>

							<p>O presente termo é firmado em 2 (duas) duas vias de igual
								teor e forma, para que produza os devidos efeitos de fato e de
								direito.</p>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<hr />
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>

</html>