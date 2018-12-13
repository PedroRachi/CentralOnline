package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Empresa;
import Service.EmpresaService;

public class VisualizarEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pId = request.getParameter("id");
		/*
		 * String pEmpresaCNPJ = request.getParameter("empresaCNPJ"); String
		 * pRazaoSocial = request.getParameter("razaoSocial"); String
		 * pLogradouro = request.getParameter("logradouro"); String pCidade =
		 * request.getParameter("cidade"); String pEstado =
		 * request.getParameter("estado"); String pCep =
		 * request.getParameter("cep"); String pTelefone =
		 * request.getParameter("telefone"); String pContatoPrincipalNome =
		 * request.getParameter("contatoPrincipalNome"); String
		 * pContatoPrincipalCPF = request.getParameter("contatoPrincipalCPF");
		 * String pContatoPrincipalEmail =
		 * request.getParameter("contatoPrincipalEmail"); String
		 * pSituacaoCadastral = request.getParameter("situacaoCadastral");
		 * String pSite = request.getParameter("site"); String pDataAbertura =
		 * request.getParameter("dataAbertura"); String pDescriAtvEconomicas =
		 * request.getParameter("descriAtvEconomicas");
		 */

		int idEmpresa = -1;

		try {
			idEmpresa = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
		}
		Empresa emp = new Empresa();

		emp.setId(idEmpresa);

		/*
		 * emp.setEmpresaCNPJ(pEmpresaCNPJ); emp.setRazaoSocial(pRazaoSocial);
		 * emp.setLogradouro(pLogradouro); emp.setCidade(pCidade);
		 * emp.setEstado(pEstado); if(pCep!=null && pCep.length() > 0) {
		 * emp.setCep(Integer.parseInt(pCep)); } emp.setTelefone(pTelefone);
		 * emp.setContatoPrincipalNome(pContatoPrincipalNome);
		 * emp.setContatoPrincipalCPF(pContatoPrincipalCPF);
		 * emp.setContatoPrincipalEmail(pContatoPrincipalEmail);
		 * emp.setSituacaoCadastral(pSituacaoCadastral); emp.setSite(pSite);
		 * emp.setDataAbertura(pDataAbertura);
		 * emp.setDescriAtvEconomicas(pDescriAtvEconomicas);
		 */

		EmpresaService es = new EmpresaService();

		RequestDispatcher view = null;

		emp = es.carregar(emp.getId());
		request.setAttribute("empresa", emp);
		view = request.getRequestDispatcher("VisualizarEmpresa.jsp");

		view.forward(request, response);
	}

}
