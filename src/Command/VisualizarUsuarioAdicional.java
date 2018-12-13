package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Usuario;
import Service.UsuarioAdicionalService;

public class VisualizarUsuarioAdicional implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pId = request.getParameter("id");
		String pNomeUsuario  = request.getParameter("nomeUsuario");
        String pEmailUsuario = request.getParameter("emailUsuario");
        String pDocumentoCPFCNPJ = request.getParameter("documentoCPFCNPJ");
        String pSituacaoCadastral = request.getParameter("situacaoCadastral");
        String pDocumentoEmpresa = request.getParameter("documentoEmpresa");


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

  		UsuarioAdicionalService us = new UsuarioAdicionalService();
  		
  		RequestDispatcher view = null;
  		HttpSession session = request.getSession();
  		
  		usuario = us.carregar(usuario.getId());
		request.setAttribute("usuario", usuario);
		view = request.getRequestDispatcher("VisualizarUsuario.jsp");
		
		view.forward(request, response);

	}

}
