package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Usuario;
import Service.UsuarioAdicionalService;
import Model.Email;

public class RecuperarSenha implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String documento = request.getParameter("documento");
		String email = request.getParameter("email");

		Usuario usuario = new Usuario();

		usuario.setDocumentoCPFCNPJEmpresa(documento);

		usuario.setEmailUsuario(email);

		UsuarioAdicionalService service = new UsuarioAdicionalService();
		Usuario usuario1 = service.validarUsuario(usuario);

		if (usuario1.getEmailUsuario().equals(email)) {

			if (usuario1.getId() > 0) {
				if (usuario1.getSituacaoCadastral().equals("ativo")) {
					HttpSession session = request.getSession();
					session.setAttribute("cartorio", usuario1);
					
					
					
					//ENVIO DO E-MAIL COMPARANDO SE O E-MAIL DIGITADO E IGUAL AO CADASTRADO NA CENTRAL!
					
					Email em = new Email();
					em.enviarPadrao(email, "Cadastro concluido",
							"Olá " + usuario1.getNomeUsuario() + " sua senha é ( " + usuario1.getSenha() + " )"
									+ " por favor, cuide bem de sua senha a central agradece a sua colaboração!!!"
									+ "\n\n\n\n\n E-mail enviado automaticamente, favor não responder!!");

					request.setAttribute("mensagem", "Verifique seu E-mail");
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}

			}

		}else{
		
		request.setAttribute("mensagem", "Ops!! Digitou seus dados corretamente ? Tente mais uma vez.");
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
		}

	}

}
