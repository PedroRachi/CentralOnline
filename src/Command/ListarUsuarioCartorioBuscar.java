package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cartorio;

import Model.Usuario;
import Service.UsuarioAdicionalService;


public class ListarUsuarioCartorioBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
		
		Cartorio usua = (Cartorio) session.getAttribute("cartorio_logado");
		
		session.setAttribute("lista", usua);
		
		
		UsuarioAdicionalService usuarioservice = new UsuarioAdicionalService();
		
		ArrayList<Usuario> lista = null;
		
		
		//HttpSession session = request.getSession();
			//if (chave != null && chave.length() > 0) {
				lista = usuarioservice.listarUsuarioCartorio1(usua.getCartorioCNPJ());
			//} else {
				//lista = usuarioservice.listarUsuarioCartorio();
			//}
			
				session.setAttribute("lista", usua);
				session.setAttribute("lista", lista);
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("ListarUsuarioCartorio.jsp");
			dispatcher.forward(request, response);
		}
}
	

