<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="IndexCartorio">CentralOnline.KideAmirum</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="cadastro.do?command=EditarCartorioLogado">Dados Cadastrais</a>
                    </li>
                    <li><a href="cadastro.do?command=DadosUsuarioCartorio">Atualizar meus dados</a>
                    </li>
                    
                    <li><a href="AdicionarColaboradoresCartorio.jsp">Incluir um novo Colaborador </a>
                    </li>
                     <li><a href="UsuarioComumCartorio.jsp">Incluir Usuario Dono </a>
                    </li>
                   <li><a href="controller.do?command=ListarUsuarioReiniciarCartorio">Usuarios</a>
                    </li>   
                    <li><a href="controller.do?command=ListarEmpresaReiniciarVerCartorio">Empresas</a>
                    </li>
                    <li><a href="controller.do?command=ListarTermosReiniciarCartorio">Termos</a>
                    </li>               
                    <li><a href="controller.do?command=Logout">Sair</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <br>
    <br>
    <br>