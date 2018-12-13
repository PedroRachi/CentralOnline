package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Empresa;
import Model.PreCadastro;
import Service.EmpresaService;
import Service.PreCadastroService;
import Model.Cartorio;
import Model.Email;

public class CriarPreCadastro implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pId = request.getParameter("id");
		String pEmpresaCNPJ = request.getParameter("empresaCNPJ");
		String pRazaoSocial = request.getParameter("razaoSocial");
		String pEmail = request.getParameter("contatoPrincipalEmail");
		String pTipoCad = request.getParameter("tipoCadastro");

		int idPre = -1;

		try {
			idPre = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
		}

		// PreCadastro objPre = new PreCadastro();
		// objPre.setId(idPre);

		// PreCadastroService es = new PreCadastroService();
		// es.TrasferirPreEmp(objPre);

		PreCadastro usuario = new PreCadastro();
		usuario.setCnpf_cnpj(pEmpresaCNPJ);
		usuario.setEmail(pEmail);
		usuario.setRazaoSocial(pRazaoSocial);
		usuario.setId(idPre);
		usuario.setSituacaoCadastral("pendente");
		usuario.setTipoCadastro(pTipoCad);

		PreCadastroService service = new PreCadastroService();
		Cartorio cartorio = service.validarCartorio(usuario);
		// Empresa empresa = service.validarEmpresa(usuario);

		// dentro do if é empresa alterei para cartorio para testar

		if (cartorio.getCartorioCNPJ() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("cartorio", cartorio);
			request.setAttribute("mensagem", "Cadastrado, digite login e senha");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);

		} else {

			PreCadastroService service1 = new PreCadastroService();
			Empresa empresa = service1.validarEmpresa(usuario);
			if (empresa.getEmpresaCNPJ() != null) {
				HttpSession session1 = request.getSession();
				session1.setAttribute("empresa", empresa);
				request.setAttribute("mensagem", "Você já possui cadastro, entre com login e senha");
				RequestDispatcher rd1 = request.getRequestDispatcher("/index.jsp");
				rd1.forward(request, response);
			
			}else{
				PreCadastroService service2 = new PreCadastroService();
				PreCadastro precadastro = service2.validarPrecadastro(usuario);
				if(precadastro.getCnpf_cnpj() != null){
					HttpSession session2 = request.getSession();
					session2.setAttribute("precadasro", precadastro);
					request.setAttribute("mensagem", "Você já possui cadastro, entre com login e senha");
					RequestDispatcher rd1 = request.getRequestDispatcher("/index.jsp");
					rd1.forward(request, response);
				
				}else{
					
					Email em = new Email();
					em.enviarPadrao(pEmail, "Cadastro concluido", "Boas Vindas, Cadastro Pendente’ ");

					PreCadastroService es = new PreCadastroService();
					RequestDispatcher view = null;
					HttpSession session = request.getSession();

					int codPreCad = es.criar(usuario);

					session.setAttribute("PreCad", codPreCad);
					request.setAttribute("mensagem", "Fique atento a seu E-mail nós iremos verificar seus dados");
					view = request.getRequestDispatcher("index.jsp");

					view.forward(request, response);
				}
			}

			
		}
	}

}
