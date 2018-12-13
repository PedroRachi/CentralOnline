<%@page import="Model.Empresa"%>
<%@page import="Command.URLEnviarParametros"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
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
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Termo de Adesão</h3>
	</div>
	<div id="main" class="container">

		<c:if test="${not empty lista}">
			<div id="list" class="row">

				<div class="table-responsive col-md-12">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Documento</th>
								<th>Status<th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="empresa" items="${lista}">
								<tr>
									<td>${empresa.empresaCNPJ}</td>
									<td>${empresa.situacaoCadastral}</td>
									<td class="actions">
										<form method="post"
											action="uploadServletADM?empresaCNPJ=${empresa.empresaCNPJ}"
											enctype="multipart/form-data" >
											<br>
											
											   <input type="file" name="photo" size="50" class="btn btn-success btn-ls" />
											   <br/>
                                               <input class="btn btn-success btn-ls" type="submit" value="salvar">
											
										</form><br/>

										<form action="downloadFileServlet?id=${empresa.id}" method="post"
											enctype="application/x-www-form-urlencoded">
											<input class="btn btn-success btn-ls" type="submit"
												value="download" />
										</form></br></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>




	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>