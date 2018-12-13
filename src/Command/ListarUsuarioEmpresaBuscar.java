package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Empresa;
import Model.Usuario;
import Service.UsuarioAdicionalService;


public class ListarUsuarioEmpresaBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
		
		Empresa usua = (Empresa) session.getAttribute("empresa_logada");
		
		session.setAttribute("lista", usua);
		
		
		//String chave = request.getParameter("data[search]");
		UsuarioAdicionalService usuarioservice = new UsuarioAdicionalService();
		
		ArrayList<Usuario> lista = null;
		
		
		//HttpSession session = request.getSession();
			//if (chave != null && chave.length() > 0) {
				lista = usuarioservice.listarUsuarioCartorio1(usua.getEmpresaCNPJ());
			//} else {
				//lista = usuarioservice.listarUsuarioCartorio();
			//}
			
				session.setAttribute("lista", usua);
				session.setAttribute("lista", lista);
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("ListarUsuarioEmpresa.jsp");
			dispatcher.forward(request, response);
		}
}
	

