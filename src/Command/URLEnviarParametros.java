package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Empresa;
import Model.Usuario;
//import Model.Usuario;


public class URLEnviarParametros implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Empresa usua1 = (Empresa) session.getAttribute("empresa_logado");
		Usuario usua = (Usuario) session.getAttribute("logado");

		String documento = request.getParameter("empresaCNPJ");

		Usuario usuario = new Usuario();

		//UsuarioAdicionalService us = new UsuarioAdicionalService();
		//Usuario usuario1 = us.validarUsuario(usuario);

		request.setAttribute("empresa", usua);
		// request.setAttribute("mensagem", "OK !!, Senha alterada com
		// sucesso!!");
		RequestDispatcher rd = request
				.getRequestDispatcher("/TermoEmpresaAMD.jsp?empresaCNPJ="+documento);

		
		request.setAttribute("empresa", usua);
		request.setAttribute("empresa", usua1);

		rd.forward(request, response);
	}

}
