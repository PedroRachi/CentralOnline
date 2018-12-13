<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link href="css/style.css" rel="stylesheet">
<link href="css/TelaPrincipal.css" rel="stylesheet">
<script type="text/javascript" src="js/funcao.js"></script>




<nav class="navbar navbar-default">
	<div class="container-fluid">

		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">KideaMirum</a>

		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">




				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><b>Meu Pré Cadastro foi Aprovado</b> <span
						class="glyphicon glyphicon-send"></span></a>
					<ul id="login-dp" class="dropdown-menu">
						<li>
							<div class="row">

								<div class="col-md-12">
									Certo, comece digitando o seu
									<form class="form" role="form" action="cadastro.do"
										method="post" accept-charset="UTF-8" id="login-nav">
										<div class="form-group">
											<label class="sr-only" for="#"> </label> <input type="text"
												class="form-control" name="documento" id="documento"
												placeholder="CPF/CNPJ" onkeyup="FormataCnpj(this,event)"
												onblur="if(!validarCNPJ(this.value)){alert('CNPJ Informado é inválido'); this.value='';}"
												maxlength="18" class="form-control input-md"
												ng-model="cadastro.cnpj" required>
										</div>
										<div class="form-group">


											<button type="submit" class="btn btn-default btn-block"
												name="command" value="VerificarPreCadastro">Verificar</button>

										</div>

										<div class="form-group"></div>

									</form>
								</div>
								<div class="bottom text-center">
									Novo aqui ? <b>Junte-se a nós</b><br /> <br />
									<button type="button" class="btn primary btn-md">
										<a href="PreCadastroEmpresa.jsp"><span
											class="glyphicon glyphicon-briefcase"></span>Pré-Cadastro</a>
									</button>


								</div>
							</div>
						</li>
					</ul></li>



			</ul>





		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
	<div class="login-box">
		<div class="login-box-interno">




			<div class="login-box-label">
				Acesso a Central

				<div class="alert-info" role="alert">
					<h9>${mensagem}</h9>
				</div>


			</div>

			<div id="main" class="container">
				<h3 class="page-header">Login</h3>
				<!-- Formulario de Login -->
				<form action="controller.do" method="post">
					<div class="row col-md-12">
						<div class="form-group">
							<div class="input-group col-md-4">
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
								</div>
								<input type="cnpj" name="username" id="username"
									class="form-control" maxlength="20" placeholder="CNPJ" required />
							</div>
						</div>
						<div class="form-group">
							<div class="input-group col-md-4">
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-option-horizontal"
										aria-hidden="true"></span>
								</div>
								<input type="password" name="password" id="password"
									class="form-control" placeholder="Senha" required />
							</div>
						</div>
					</div>
					<div class="row col-md-12">
						<button type="submit" class="btn btn-primary" name="command"
							value="FazerLogin">
							<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
							Logar
						</button>




						<!--  Recuperar Senha -->

						</br> </br> <a href="#" data-toggle="modal" data-target="#delete-modal">Esqueci
							minha senha</a> </br> </br> Novo aqui ? <b>Junte-se a nós</b>&#160;
						<button type="button" class="btn primary btn-md">
							<a href="PreCadastroEmpresa.jsp"><span
								class="glyphicon glyphicon-briefcase"></span>Pré-Cadastro</a>
						</button>

					</div>



				</form>
			</div>

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

					<div class="modal-body">
						<h4>Não se preocupe sua senha será enviada no seu E-mail</h4>
					</div>

					<div class="row">

						<div class="col-md-12">
							Certo, comece digitando o seu
							<form class="form" role="form" action="cadastro.do" method="post"
								accept-charset="UTF-8" id="login-nav">


								<div class="form-group">
									<label class="sr-only" for="#"> </label> <input type="text"
										class="form-control" name="documento" id="documento"
										placeholder="CPF/CNPJ" onkeyup="FormataCnpj(this,event)"
										onblur="if(!validarCNPJ(this.value)){alert('CNPJ Informado é inválido'); this.value='';}"
										maxlength="18" class="form-control input-md"
										ng-model="cadastro.cnpj" required> <br> <br>
									<label class="sr-only" for="#"> </label> <input type="text"
										class="form-control" name="email" id="email"
										placeholder="email" required>
									<div class="modal-body">Deseja realmente fazer esta
										operação?</div>


									<div class="modal-footer">

										<button type="submit" class="btn btn-primary" name="command"
											value="RecuperarSenha">Sim</button>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">N&atilde;o</button>
									</div>
								</div>

							</form>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
	<!-- /.modal -->




</nav>



