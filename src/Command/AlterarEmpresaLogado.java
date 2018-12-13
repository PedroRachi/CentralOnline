package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Empresa;
//import Model.Usuario;
import Service.EmpresaService;

public class AlterarEmpresaLogado implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pId = request.getParameter("id");
		
		String pRazaoSocial = request.getParameter("razaoSocial");
		String pLogradouro = request.getParameter("logradouro");
		String pCidade = request.getParameter("cidade");
		String pEstado = request.getParameter("estado");
		String pCep = request.getParameter("cep");
		String pTelefone = request.getParameter("telEmpresa");
		String pContatoPrincipalNome = request.getParameter("contatoPrincipalNome");
		String pContatoPrincipalCPF = request.getParameter("contatoPrincipalCPF");
		String pContatoPrincipalEmail = request.getParameter("contatoPrincipalEmail");
		String pSite = request.getParameter("site");
		String pDataAbertura = request.getParameter("dataAbertura");
		String pDescriAtvEconomicas = request.getParameter("descriAtvEconomicas");
		
		int idEmpresa = -1;

		try {
			idEmpresa = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
		}
		Empresa emp = new Empresa();

		emp.setId(idEmpresa);

		//emp.setEmpresaCNPJ(pEmpresaCNPJ);

		emp.setRazaoSocial(pRazaoSocial);
		emp.setLogradouro(pLogradouro);
		emp.setCidade(pCidade);
		emp.setEstado(pEstado);
		if (pCep != null && pCep.length() > 0) {
			emp.setCep(Integer.parseInt(pCep));
		}
		emp.setTelefone(pTelefone);
		emp.setContatoPrincipalNome(pContatoPrincipalNome);
		emp.setContatoPrincipalCPF(pContatoPrincipalCPF);
		emp.setContatoPrincipalEmail(pContatoPrincipalEmail);
		emp.setSite(pSite);
		emp.setDataAbertura(pDataAbertura);
		emp.setDescriAtvEconomicas(pDescriAtvEconomicas);
		//emp.setSituacaoCadastral(pSituacaoCadastral);
		//emp.setTipoPerfil(pTipoPerfil);
		//emp.setSenhaAcesso(pSenhaAcesso);

		EmpresaService es = new EmpresaService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		/*Usuario usuario = new Usuario();
		usuario.setDocumentoCPFCNPJEmpresa(emp.getContatoPrincipalCPF());
		usuario.setDocumentoEmpresa(emp.getEmpresaCNPJ());
		usuario.setNomeUsuario(emp.getContatoPrincipalNome());
		usuario.setEmailUsuario(emp.getContatoPrincipalEmail());
		usuario.setSituacaoCadastral("ativo");
		usuario.setIdTipoPerfil(4);
		usuario.setSenha(pSenhaAcesso);
		usuario.setTipoCadastro(emp.getTipoPerfil());*/	
		
		es.atualizarEmpresaLogado(emp);
		

		request.setAttribute("empresa", emp);
		view = request.getRequestDispatcher("IndexEmpresa.jsp");

		view.forward(request, response);

	}
}