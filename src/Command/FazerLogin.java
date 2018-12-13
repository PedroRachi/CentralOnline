package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.UsuarioAdicionalService;
import Model.Cartorio;
import Model.Empresa;

import Model.Usuario;

public class FazerLogin implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter		("username");
		String senha = request.getParameter		("password");

		// String pTipoPerfil = request.getParameter("tipoPerfil");

		Usuario usuario = new Usuario();

		/*
		 * usuario.setDocumentoCPFCNPJEmpresa(nome); usuario.setSenha(senha);
		 */
		UsuarioAdicionalService service = new UsuarioAdicionalService();
		// int pTipoPerfil
		usuario = service.carregarLogin(nome, senha);

		if (usuario.getId() > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			switch (usuario.getIdTipoPerfil()) {
			case 1:
			case 2:
				if (usuario.getTipoCadastro().equalsIgnoreCase("EMPRESA")
						&& usuario.getSituacaoCadastral().equalsIgnoreCase("Ativo")) {
					Empresa empLogada = new Empresa();
					empLogada = (Empresa) service.carregarObjetoLogado(usuario.documentoEmpresa, usuario.tipoCadastro);
					session.setAttribute("empresa_logada", empLogada);
					response.sendRedirect("IndexEmpresa.jsp");
				} else if (usuario.getTipoCadastro().equalsIgnoreCase("CARTORIO")
						&& usuario.getSituacaoCadastral().equalsIgnoreCase("Ativo")) {
					Cartorio carLogado = new Cartorio();
					carLogado = (Cartorio) service.carregarObjetoLogado(usuario.documentoEmpresa, usuario.tipoCadastro);
					session.setAttribute("cartorio_logado", carLogado);
					response.sendRedirect("IndexCartorio.jsp");
				} else {
					request.setAttribute("mensagem", "Login não autorizado !!");
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
				break;
			// Criar um if para Colaboradores
			case 3:
				if (usuario.getTipoCadastro().equalsIgnoreCase("EMPRESA")
						&& usuario.getSituacaoCadastral().equalsIgnoreCase("Ativo")) {
					Empresa colEmpLogado = new Empresa();
					colEmpLogado = (Empresa) service.carregarObjetoLogado(usuario.documentoEmpresa,
							usuario.tipoCadastro);
					session.setAttribute("user_logado", colEmpLogado);
					response.sendRedirect("IndexUsuario.jsp");
				} else if (usuario.getTipoCadastro().equalsIgnoreCase("CARTORIO")
						&& usuario.getSituacaoCadastral().equalsIgnoreCase("Ativo")) {
					Cartorio colCarLogado = new Cartorio();
					colCarLogado = (Cartorio) service.carregarObjetoLogado(usuario.documentoEmpresa,
							usuario.tipoCadastro);
					session.setAttribute("userCar_logado", colCarLogado);
					response.sendRedirect("IndexUsuarioCartorio.jsp");
				} else {
					request.setAttribute("mensagem", "Login não autorizado !!");
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
				break;
			case 4:
				response.sendRedirect("IndexAdm.jsp");
				break;

			default:
				System.out.println("Tipo perfil não identificado " + usuario.getId());
				throw new ServletException("Tipo perfil não identificado" + usuario.getId());
			}
		} else {
			request.setAttribute("mensagem", "Tente novamente, não encontrei seus dados !!");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		/*
		 * if (pTipoPerfil.equals("empresadono"))
		 * response.sendRedirect("IndexEmpresa.jsp");
		 * 
		 * if (pTipoPerfil.equals("cartoriodono"))
		 * response.sendRedirect("IndexCartorio.jsp");
		 * 
		 * if (pTipoPerfil.equals("admin"))
		 * response.sendRedirect("IndexAdm.jsp");
		 * 
		 * if (pTipoPerfil.equals("empresacolaborador"))
		 * response.sendRedirect("IndexUsuario.jsp");
		 */
	}

}
