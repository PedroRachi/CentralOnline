package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Usuario;
//import Model.Usuario;
import Service.UsuarioAdicionalService;

public class AlterarUsuarioEmpresaColaborador implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Usuario usua = (Usuario)session.getAttribute("logado");
		
		String documento = request.getParameter("documento");
		String pSenha = request.getParameter("senha");
		String pSenhaNova = request.getParameter("senhaNova");

		/*
		 * int idEmpresa = -1;
		 * 
		 * try { idEmpresa = Integer.parseInt(pId); } catch
		 * (NumberFormatException e) { }
		 */
		Usuario usuario = new Usuario();

		// usuario.setId(idEmpresa);
		usuario.setSenha(pSenha);
		usuario.setDocumentoCPFCNPJEmpresa(documento);

		UsuarioAdicionalService us = new UsuarioAdicionalService();
		Usuario usuario1 = us.validarUsuario(usuario);

		if (usuario1.getSenha().equals(pSenha)) {

			//RequestDispatcher view = null;
			

			usuario1.setSenha(pSenhaNova);

			us.atualizarUsuarioEmpresa(usuario1);
			
			
			
			request.setAttribute("usuario", usuario1);
			request.setAttribute("mensagem", "OK !!, Senha alterada com sucesso!!");
			RequestDispatcher rd = request.getRequestDispatcher("/VisualizarLoginColaboradorEmpresa.jsp");
			
			request.setAttribute("usuario", usua);
			
			rd.forward(request, response);
		} else {
			request.setAttribute("mensagem", "Ops!! Você por algum motivo não digitou sua senha atual corretamente.");
			RequestDispatcher rd = request.getRequestDispatcher("/VisualizarLoginColaboradorEmpresa.jsp");
			
			request.setAttribute("usuario", usua);
			
			rd.forward(request, response);

		}

	}

}
