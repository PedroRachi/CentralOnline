<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Empresa - Cadastros</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
	<c:import url="MenuEmpresa.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Termo de Adesão</h3>
       </div>
       <div id="main" class="container">
        <div class="row">
   <div class="col-md-12">
   
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
                     
 			</div></div>
					<h3>Não deixe para depois assine o contrato de uso do sistema. </h3>
					<h5>Se aprovado o seu termo será atualizado pelo Administrador da central</h5>
	    <form method="post" action="uploadServlet" enctype="multipart/form-data">
					<br>
					<div><input type="file" name="photo" size="50"/></div>
					
					<br>
					
					<div colspan="2">
						<strong>Escolha o arquivo antes de salvar  </strong><input type="submit" value="salvar">
					</div>
		</form>
	
	</br>
	
	<form action="downloadFileServlet" method="get" enctype="application/x-www-form-urlencoded">
	<strong>Baixer o termo clicando aqui  </strong><input type="submit" value="download"/>
	</form>
</br>   		 
   		 </div>
   		 
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>