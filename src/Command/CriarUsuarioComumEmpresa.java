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

public class CriarUsuarioComumEmpresa implements Command {

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
        String pTipoCadastro = "EMPRESA";
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
  		usuario.setIdTipoPerfil(1);
  		usuario.setSenha(pSenha);
  		usuario.setTipoCadastro(pTipoCadastro);

  		UsuarioAdicionalService us = new UsuarioAdicionalService();
  		
  		RequestDispatcher view = null;
  		HttpSession session = request.getSession();
  		
  		us.CriarUsuarioComumEmpresa(usuario);
  		
  		//ArrayList<Usuario> lista = new ArrayList<>();
  		//lista.add(usuario);
  		//session.setAttribute("lista", lista);
  		view = request.getRequestDispatcher("IndexEmpresa.jsp");
  		
  		view.forward(request, response);


	}
	/*public int busca(Usuario usuario, ArrayList<Usuario> lista) {
  		Usuario to;
  		for(int i = 0; i < lista.size(); i++){
  			to = lista.get(i);
  			if(to.getId() == usuario.getId()){
  				return i;
  			}
  		}
  		return -1;*/
  	}
	


