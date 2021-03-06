package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cartorio;
import Service.CartorioService;



public class ListarCartorioBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");
		CartorioService cartorioser = new CartorioService();
		ArrayList<Cartorio> lista = null;
		HttpSession session = request.getSession();
			if (chave != null && chave.length() > 0) {
				lista = cartorioser.listarCartorio(chave);
			} else {
				lista = cartorioser.listarCartorio();
			}
			session.setAttribute("lista", lista);
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("ListarCartorio.jsp");
			dispatcher.forward(request, response);
		}
}
