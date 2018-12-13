package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Empresa;
import Service.EmpresaService;

public class ListarEmpresaBuscarVerCartorio implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");
		EmpresaService emp = new EmpresaService();
		ArrayList<Empresa> lista = null;
		HttpSession session = request.getSession();
			if (chave != null && chave.length() > 0) {
				lista = emp.listarEmpresa(chave);
			} else {
				lista = emp.listarEmpresa();
			}
			session.setAttribute("lista", lista);
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("ListarEmpresaVerCartorio.jsp");
			dispatcher.forward(request, response);
		}
		
	}

