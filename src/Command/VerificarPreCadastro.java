package Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.java.swing.plaf.windows.resources.windows_zh_CN;

import Model.Cartorio;
import Model.Empresa;
import Model.PreCadastro;
import Service.EmpresaService;
import Service.PreCadastroService;

public class VerificarPreCadastro implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String documento = request.getParameter("documento");

		PreCadastro usuario = new PreCadastro();
		usuario.setCnpf_cnpj(documento);
		PreCadastroService service = new PreCadastroService();
		Cartorio cartorio = service.validarCartorio(usuario);
		// Empresa empresa = service.validarEmpresa(usuario);

		// dentro do if é empresa alterei para cartorio para testar
		if (cartorio.getId() > 0) {
			if (cartorio.getSituacaoCadastral().equals("Ativo")) {
				HttpSession session = request.getSession();
				session.setAttribute("cartorio", cartorio);
				request.setAttribute("mensagem", "Cadastrado, digite login e senha");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("cartorio", cartorio);
				request.setAttribute("mensagem", "Cadastro Aprovado pela Central!");
				RequestDispatcher rd = request.getRequestDispatcher("/CadastroCartorio.jsp");
				rd.forward(request, response);
			}
		} else {
			/*
			 * System.out.println("NÃ£o Logou " + usuario); throw new
			 * ServletException("UsuÃ¡rio invÃ¡lidos ou nao cadastrado");
			 */
			Empresa empresa = service.validarEmpresa(usuario);
			if (empresa.getId() > 0) {
				if (empresa.getSituacaoCadastral().equals("Ativo")) {
					HttpSession session = request.getSession();
					session.setAttribute("empresa", empresa);
					request.setAttribute("mensagem", "Cadastrado, digite login e senha");
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				} else {
				HttpSession session = request.getSession();
				session.setAttribute("empresa", empresa);
				request.setAttribute("mensagem", "Cadastro Aprovado pela Central!");
				RequestDispatcher rd = request.getRequestDispatcher("/CadastroEmpresa.jsp");
				rd.forward(request, response);
				}
			} else {
				request.setAttribute("mensagem", "Documento não cadastrado!!");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
		}
		/*
		 * if(cartorio.getTipoPerfil().equals("EMPRESA")){
		 * request.setAttribute("mensagem", "Cadastro Aprovado pela Central!");
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("/CadastroEmpresa.jsp");
		 * rd.forward(request, response);
		 * //response.sendRedirect("CadastroEmpresa.jsp");
		 * 
		 * }
		 * 
		 * if(cartorio.getTipoPerfil().equals("CARTORIO")) {
		 * request.setAttribute("mensagem", "Cadastro Aprovado pela Central!");
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("/CadastroCartorio.jsp");
		 * rd.forward(request, response);
		 * 
		 * //response.sendRedirect("CadastroCartorio.jsp"); }
		 * 
		 * if(cartorio.getTipoPerfil() == null){
		 * request.setAttribute("mensagem", "Documento não cadastrado!!");
		 * RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		 * rd.forward(request, response); }
		 */
	}
	// Aqui também o array e cartorio n
	/*
	 * public int busca(Cartorio pais, ArrayList<Cartorio> lista) { Cartorio to;
	 * for (int i = 0; i < lista.size(); i++) { to = lista.get(i); if
	 * (to.getId() == pais.getId()) { return i; } } return -1; }
	 */

}
