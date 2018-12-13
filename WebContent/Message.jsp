<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/Tela.css" rel="stylesheet">
<script type="text/javascript" src="js/funcao.js"></script>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message</title>
</head>
<body>

	<div id="main" class="container">
		<div id="top" class="row">
			<div class="col-ls-12">

				<h3><%=request.getAttribute("Message")%></h3>
			</div>
		</div>
		
		
		<div class="row">
		<div class="col-ls-12">
			<button class="btn btn-primary" type="submit" name="" value="">Voltar</button>
		</div>
		</div>

	</div>
	


</body>
</html>