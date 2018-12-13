package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Model.Empresa;
import Model.Usuario;

public class UserEmpresaListarTermosReiniciar implements Command {


		public void executar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			HttpSession session = request.getSession();
			Usuario usua = (Usuario) session.getAttribute("logada");
			
			//Cartorio usua1 = (Cartorio) session.getAttribute("cartorio_logado");
			
			//session.setAttribute("lista", usua1);
			
			session.setAttribute("lista", usua);
			
			session.setAttribute("lista", null);
			
			
			RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarTermosUsuarioEmpresa.jsp");
			       //.getRequestDispatcher("ListarUsuario.jsp");
			dispatcher.forward(request, response);

		}
}
