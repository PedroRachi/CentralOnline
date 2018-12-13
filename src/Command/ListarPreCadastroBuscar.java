package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Model.PreCadastro;

import Service.PreCadastroService;

public class ListarPreCadastroBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");
		PreCadastroService emp = new PreCadastroService();
		ArrayList<PreCadastro> lista = null;
		HttpSession session = request.getSession();
			if (chave != null && chave.length() > 0) {
				lista = emp.listarPreCadastro(chave);
			} else {
				lista = emp.listarPreCadastro();
			}
			session.setAttribute("lista", lista);
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("ListarPreCadastro.jsp");
			dispatcher.forward(request, response);
		
	}

}
