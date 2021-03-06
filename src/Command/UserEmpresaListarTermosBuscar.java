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
import Model.Usuario;
import Service.TermosService;

public class UserEmpresaListarTermosBuscar implements Command {
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Usuario usua = (Usuario) session.getAttribute("logado");
		
		session.setAttribute("lista", usua);
		
		//String chave     = request.getParameter("data[search]");
		//String documento = request.getParameter("documento");

		TermosService termos = new TermosService();

		ArrayList<Termos> lista = null;

		
		//if (chave != null && chave.length() > 0) {

			lista = termos.listarTermos1(usua.getDocumentoEmpresa());
		//} else {
		    //lista = termos.listarTermos(chave);
		//}
		session.setAttribute("lista", usua);
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarTermosUsuarioEmpresa.jsp");
		dispatcher.forward(request, response);
	}
}
