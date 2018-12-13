package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Empresa;
import Service.EmpresaService;

public class ExcluirEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pId = request.getParameter("id");
		/*String pEmpresaCNPJ = request.getParameter("empresaCNPJ");
        String pRazaoSocial = request.getParameter("razaoSocial");
        String pLogradouro = request.getParameter("logradouro");
        String pCidade = request.getParameter("cidade");
        String pEstado = request.getParameter("estado");
        String	pCep	   = request.getParameter("cep");
        String pTelefone = request.getParameter("telefone");
        String pContatoPrincipalNome = request.getParameter("contatoPrincipalNome");
        String pContatoPrincipalCPF = request.getParameter("contatoPrincipalCPF");
        String pContatoPrincipalEmail = request.getParameter("contatoPrincipalEmail");
        String pSite = request.getParameter("site");
        String pDataAbertura = request.getParameter("dataAbertura");
        String pDescriAtvEconomicas = request.getParameter("descriAtvEconomicas");
        String pSituacaoCadastral = request.getParameter("situacaoCadastral");*/
        int idEmpresa = -1;
        
          try {
         			idEmpresa = Integer.parseInt(pId);
		 		} catch (NumberFormatException e) {
		 		}
         
         Empresa emp = new Empresa();
         emp.setId(idEmpresa);
  		/* emp.setEmpresaCNPJ(pEmpresaCNPJ);
  		 emp.setRazaoSocial(pRazaoSocial);
  		 emp.setLogradouro(pLogradouro);
  		 emp.setCidade(pCidade);
  		 emp.setEstado(pEstado);
  		if(pCep!=null && pCep.length() > 0) {
  			emp.setCep(Integer.parseInt(pCep));
  		}
  		emp.setTelefone(pTelefone);
  		emp.setContatoPrincipalNome(pContatoPrincipalNome);
  		emp.setContatoPrincipalCPF(pContatoPrincipalCPF);
  		emp.setContatoPrincipalEmail(pContatoPrincipalEmail);
  		emp.setSituacaoCadastral(pSituacaoCadastral);
  		emp.setSite(pSite);
  		emp.setDataAbertura(pDataAbertura);
  		emp.setDescriAtvEconomicas(pDescriAtvEconomicas);*/
  		
  		EmpresaService es = new EmpresaService();

  		RequestDispatcher view = null;
  		HttpSession session = request.getSession();

  		es.excluir(emp.getId());
		@SuppressWarnings("unchecked")
		ArrayList<Empresa> lista = (ArrayList<Empresa>) session
				.getAttribute("lista");
		lista.remove(busca(emp, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarEmpresa.jsp");
		view.forward(request, response);
		
	}
		public int busca(Empresa emp, ArrayList<Empresa> lista) {
	  		Empresa to;
	  		for(int i = 0; i < lista.size(); i++){
	  			to = lista.get(i);
	  			if(to.getId() == emp.getId()){
	  				return i;
	  			}
	  		}
	  		return -1;
	  	}
	}


