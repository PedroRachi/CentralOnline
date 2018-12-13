<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>cerveja.biz - Criar cartorio</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
	<c:import url="MenuTelaPrincipal.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Incluir cartorio</h3>
        
        <form action="cadastro.do" method="post">
            
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="cartorioCNPJ">cartorioCNPJ</label>
                    <input type="text" class="form-control" name="cartorioCNPJ" id="cartorioCNPJ" required maxlength="100" placeholder="nome completo">
                </div>
                <div class="form-group col-md-6">
                    <label for="numeroCartorio">numeroCartorio</label>
                    <input type="text" class="form-control" name="numeroCartorio" id="numeroCartorio" placeholder="pop pais" required>
                </div>
				</div>
				<div class="row">
                <div class="form-group col-md-6">
                    <label for="nomeCartorio">nomeCartorio</label>
                    <input type="text" class="form-control" name="nomeCartorio" id="nomeCartorio" required maxlength="60" placeholder="area" required>
                </div>
                </div>
                <!--  <div class="form-group col-md-6">
                    <label for="logradouro">logradouro</label>
                    <input type="text" class="form-control" name="logradouro" id="logradouro" placeholder="pop pais">
                </div>
                 </div>
                 <div class="row">
                <div class="form-group col-md-6">
                    <label for="cidade">cidade</label>
                    <input type="text" class="form-control" name="cidade" id="cidade" placeholder="pop pais">
                </div> 
                <div class="form-group col-md-6">
                    <label for="estado">estado</label>
                    <input type="text" class="form-control" name="estado" id="estado" placeholder="pop pais">
                </div>
                </div>
                <div class="row">
                <div class="form-group col-md-6">
                    <label for="cep">cep</label>
                    <input type="text" class="form-control" name="cep" id="cep" placeholder="pop pais">
                </div>
                <div class="form-group col-md-6">
                    <label for="tabeliaoNome">tabeliaoNome</label>
                    <input type="text" class="form-control" name="tabeliaoNome" id="tabeliaoNome" placeholder="pop pais">
                </div>
                </div>
                <div class="row">
                <div class="form-group col-md-6">
                    <label for="tabeliaoCPF">tabeliaoCPF</label>
                    <input type="text" class="form-control" name="tabeliaoCPF" id="tabeliaoCPF" placeholder="pop pais">
                </div>
                <div class="form-group col-md-6">
                    <label for="tabeliaoEmail">tabeliaoEmail</label>
                    <input type="text" class="form-control" name="tabeliaoEmail" id="tabeliaoEmail" placeholder="pop pais">
                </div>
                </div>
                <div class="row">
                <div class="form-group col-md-6">
                    <label for="substitutoNome">substitutoNome</label>
                    <input type="text" class="form-control" name="substitutoNome" id="substitutoNome" placeholder="pop pais">
                </div>
                <div class="form-group col-md-6">
                    <label for="substitutoCPF">substitutoCPF</label>
                    <input type="text" class="form-control" name="substitutoCPF" id="substitutoCPF" placeholder="pop pais">
                </div>
                </div>
                <div class="row">
                <div class="form-group col-md-6">
                    <label for="substitutoEmail">substitutoEmail</label>
                    <input type="text" class="form-control" name="substitutoEmail" id="substitutoEmail" placeholder="pop pais">
                </div>
                <div class="form-group col-md-6">
                    <label for="telCartorio">telCartorio</label>
                    <input type="text" class="form-control" name="telCartorio" id="telCartorio" placeholder="pop pais">
                </div>
                </div>
                <div class="row">
                <div class="form-group col-md-6">
                    <label for="site">site</label>
                    <input type="text" class="form-control" name="site" id="site" placeholder="pop pais">
                </div>
                <div class="form-group col-md-6">
                    <label for="dataHoraFuncionamento">dataHoraFuncionamento</label>
                    <input type="text" class="form-control" name=dataHoraFuncionamento id="telCartorio" placeholder="pop pais">
                </div>
                </div>
                    <div id="actions" class="row">-->
                    
                <h4>
				Para efetivar o Cadastro leia atentamente o<a data-toggle="modal"
					data-target="#myModal"> Termo de Adesão </a>
			</h4>
			<input type="checkbox" name="termo" value="male" id="termo" required> Li e
			concordo com os termos
			<hr />         
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarCartorio">Salvar</button>
                    <a href="index.jsp" class="btn btn-default">Cancelar</a>
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
								<h4 class="modal-title text-center" id="myModalLabel">Termo
									de Adesão</h4>
							</div>
							<div class="modal-body">

								<p><strong>1. Aceitação das Condições de Uso</strong></p>
								<p>A cartório já qualificado na ficha pré-cadastral afirma que após aceitar o
								termo de adesão que todas informações prestadas ao site são verídicas para presente
								termo para realização cadastral em nosso site. Ao usar tal Sistema, o usuário está ciente de
								que estará sujeito aos manuais e regras aplicáveis a ele. O usuário assume que leu e
								concordou com a versão mais recente do Termo e se vincula, automática e
								irrevogavelmente, às regras nele contidas. com as seguintes cláusulas e condições.</p>
								<p><strong>2. Descrição do serviço</strong></p>
								<p>Através do Sistema de Central Online de ME e EPP, que coleta e armazena informações de
								empresas e cartórios, necessárias ao cumprimento de seu serviço: Para promover cadastro
								de empresas e cartórios. Para realização de uma comunicação mais ágil entre os mesmos;
								assegurando informações prestadas ao nosso serviço.</p>
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
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>