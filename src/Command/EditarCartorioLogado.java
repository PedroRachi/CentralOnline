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

public class EditarCartorioLogado implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Cartorio car = (Cartorio) session.getAttribute("cartorio_logado");

		Cartorio cartorio = new Cartorio();

		CartorioService es = new CartorioService();

		RequestDispatcher view = null;

		// cartorio = es.carregarEmpDocumento(cartorio.getCartorioCNPJ());

		cartorio = es.carregarCarDocumento(cartorio.getCartorioCNPJ());
		request.setAttribute("cartorio", car);
		view = request.getRequestDispatcher("AlterarCartorioLogado.jsp");

		view.forward(request, response);

	}

	public int busca(Cartorio emp, ArrayList<Cartorio> lista) {
		Cartorio to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == emp.getId()) {
				return i;
			}
		}
		return -1;
	}

}
