package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Usuario;
import Service.UsuarioAdicionalService;

public class CriarColaboradoresCartorio implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pId = request.getParameter("id");
		String pNomeUsuario  = request.getParameter("nomeUsuario");
        String pEmailUsuario = request.getParameter("emailUsuario");
        String pDocumentoCPFCNPJ = request.getParameter("documentoCPFCNPJ");
        String pSituacaoCadastral = "Ativo";
        String pDocumentoEmpresa = request.getParameter("documentoEmpresa");
        //String pIdTipoPerfil = request.getParameter("idperfil");
        String pTipoCadastro = "CARTORIO";
        String pSenha = request.getParameter("senha");

        int idUsuario = -1;
        
          try {
        	  idUsuario = Integer.parseInt(pId);
		 		} catch (NumberFormatException e) {
		 		}
         Usuario usuario = new Usuario();

         usuario.setId(idUsuario);

  		usuario.setNomeUsuario(pNomeUsuario);
  		usuario.setEmailUsuario(pEmailUsuario);
  		usuario.setDocumentoCPFCNPJEmpresa(pDocumentoCPFCNPJ);
  		usuario.setSituacaoCadastral(pSituacaoCadastral);
  		usuario.setDocumentoEmpresa(pDocumentoEmpresa);
  		usuario.setIdTipoPerfil(3);
  		usuario.setSenha(pSenha);
  		usuario.setTipoCadastro(pTipoCadastro);

  		UsuarioAdicionalService us = new UsuarioAdicionalService();
  		
  		RequestDispatcher view = null;
  		HttpSession session = request.getSession();
  		
  		us.CriarUsuarioComumEmpresa(usuario);
  		
  		view = request.getRequestDispatcher("IndexCartorio.jsp");
  		
  		view.forward(request, response);


	}
	
  	}
	


