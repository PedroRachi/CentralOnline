package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Empresa;
import Model.Termos;

import Service.TermosService;

public class ListarTermosBuscar implements Command {
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Empresa usua = (Empresa) session.getAttribute("empresa_logada");
		
		session.setAttribute("lista", usua);
		
		//String chave     = request.getParameter("data[search]");
		//String documento = request.getParameter("documento");

		TermosService termos = new TermosService();

		ArrayList<Termos> lista = null;

		
		//if (chave != null && chave.length() > 0) {

			lista = termos.listarTermos1(usua.getEmpresaCNPJ());
		//} else {
		    //lista = termos.listarTermos(chave);
		//}
		session.setAttribute("lista", usua);
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarTermos.jsp");
		dispatcher.forward(request, response);
	}
}
