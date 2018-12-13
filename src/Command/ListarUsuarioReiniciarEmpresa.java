package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListarUsuarioReiniciarEmpresa implements Command {


		public void executar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			HttpSession session = request.getSession();
			session.setAttribute("lista", null);
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("ListarUsuarioEmpresa.jsp");
			dispatcher.forward(request, response);

		}
}
