package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Email;
import Model.PreCadastro;
import Service.PreCadastroService;

public class AlterarSituacaoPreCadastro implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String email = request.getParameter("email");

		int idPre = -1;

		try {
			idPre = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
		}

		PreCadastro objPre = new PreCadastro();
		objPre.setId(idPre);
		objPre.setEmail(email);

		Email em = new Email();
		em.enviarPadrao(email, "Olá somos o grupo KIDEAMIRUM, Seu Pré cadastro foi aprovado ",
				"Boas Vindas, Agora entre em nossa pagina e clique em 'Meu Pré Cadastro foi aprovado'"
				+ " no menu superior a direita para concluir seu cadastro na central"
				+ "\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "Esse é um e-mail automatico, favor não responder");

		PreCadastroService es = new PreCadastroService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		int codPreCad = es.TrasferirPreEmp(objPre);
		ListarPreCadastroBuscar consuta = new ListarPreCadastroBuscar();
		consuta.executar(request, response);
		/*
		 * session.setAttribute("PreCad", codPreCad); view =
		 * request.getRequestDispatcher("ListarPreCadastroEmpresa.jsp");
		 * 
		 * view.forward(request, response);
		 */

	}

}
