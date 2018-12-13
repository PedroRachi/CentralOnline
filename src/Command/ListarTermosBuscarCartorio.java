package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cartorio;

import Model.Termos;

import Service.TermosService;

public class ListarTermosBuscarCartorio implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		Cartorio usua1 = (Cartorio) session.getAttribute("cartorio_logado");

		session.setAttribute("lista", usua1);

		TermosService termos = new TermosService();

		ArrayList<Termos> lista = null;

		lista = termos.listarTermos1(usua1.getCartorioCNPJ());

		
		session.setAttribute("lista", usua1);
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarTermosCartorio.jsp");
		dispatcher.forward(request, response);
	}
}
