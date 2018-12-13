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

public class ColaboradorVisualizarEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Empresa usua = (Empresa)session.getAttribute("user_logado");
		
		//int pId = usua.getId();
		
		//String pEmpresaCNPJ = request.getParameter("empresaCNPJ");
       /* String pRazaoSocial = request.getParameter("razaoSocial");
        String pLogradouro = request.getParameter("logradouro");
        String pCidade = request.getParameter("cidade");
        String pEstado = request.getParameter("estado");
        String	pCep	   = request.getParameter("cep");
        String pTelefone = request.getParameter("telEmpresa");
        String pContatoPrincipalNome = request.getParameter("contatoPrincipalNome");
        String pContatoPrincipalCPF = request.getParameter("contatoPrincipalCPF");
        String pContatoPrincipalEmail = request.getParameter("contatoPrincipalEmail");
        String pSite = request.getParameter("site");
        String pDataAbertura = request.getParameter("dataAbertura");
        String pDescriAtvEconomicas = request.getParameter("descriAtvEconomicas");
        //String pTipoPerfil = request.getParameter("tipoPerfil");*/
        //int idEmpresa = -1;*/
        
        /*try {
         	  idEmpresa = Integer.parseInt(pId);
		 	} catch (NumberFormatException e) {
		 		}*/
         Empresa emp = new Empresa();
     
         //emp.setId(pId);
  		 
         
         ///*emp.setEmpresaCNPJ(pEmpresaCNPJ);
  		/* emp.setRazaoSocial(pRazaoSocial);
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
  		emp.setSite(pSite);
  		emp.setDataAbertura(pDataAbertura);
  		emp.setDescriAtvEconomicas(pDescriAtvEconomicas);
  		//emp.setTipoPerfil(pTipoPerfil);*/
  		
  		EmpresaService es = new EmpresaService();
  		
  		RequestDispatcher view = null;
  		

  		
  		emp = es.carregarEmpDocumento(emp.getEmpresaCNPJ());
		request.setAttribute("empresa", usua);
		view = request.getRequestDispatcher("ColaboradorVisualizarEmpresa.jsp");		
		
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

