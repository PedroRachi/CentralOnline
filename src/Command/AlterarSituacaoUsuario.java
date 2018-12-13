package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Usuario;
import Service.UsuarioAdicionalService;

public class AlterarSituacaoUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		      String pId = request.getParameter("id");

		int idPre = -1;

		try {
			idPre = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
		}

		Usuario objPre = new Usuario();
		objPre.setId(idPre);

		UsuarioAdicionalService es = new UsuarioAdicionalService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		int codPreCad = es.MudarSituacaoCadastral(objPre);
		ListarUsuarioBuscar consuta = new ListarUsuarioBuscar();
		consuta.executar(request, response);
		/*session.setAttribute("PreCad", codPreCad);
		view = request.getRequestDispatcher("ListarPreCadastroEmpresa.jsp");
		
		view.forward(request, response);*/

	}

}
