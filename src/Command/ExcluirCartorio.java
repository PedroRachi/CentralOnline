package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cartorio;
import Service.CartorioService;

public class ExcluirCartorio implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pId = request.getParameter("id");
		/*String pCartorioCNPJ = request.getParameter("cartorioCNPJ");
        String pNumeroCartorio = request.getParameter("numeroCartorio");
        String pNomeCartorio = request.getParameter("nomeCartorio");
        String pLogradouro = request.getParameter("logradouro");
        String pCidade = request.getParameter("cidade");
        String pEstado	   = request.getParameter("estado");
        String pCep = request.getParameter("cep");
        String pTabeliaoNome = request.getParameter("tabeliaoNome");
        String pTabeliaoCPF = request.getParameter("tabeliaoCPF");
        String pTabeliaoEmail = request.getParameter("tabeliaoEmail");
        String pSubstitutoNome = request.getParameter("substitutoNome");
        String pSubstitutoCPF = request.getParameter("substitutoCPF");
        String pSubstitutoEmail = request.getParameter("substitutoEmail");
        String pTelCartorio = request.getParameter("telCartorio");
        String pSituacaoCadastral = "pendente";
        String pSite = request.getParameter("site");
        String pDataHoraFuncionamento = request.getParameter("dataHoraFuncionamento");

        
      
        String pUsername = request.getParameter("username");
        String pPassword = request.getParameter("password");
        String pTipoPerfil = "cartoriodono";
        pTipoPerfil.toLowerCase();*/
        
        int idCartorio = -1;
        
        
          try {
        	  	idCartorio = Integer.parseInt(pId);
		 		} catch (NumberFormatException e) {
		 		}
         Cartorio cartorio = new Cartorio();

         cartorio.setId(idCartorio);
         
         /*cartorio.setCartorioCNPJ(pCartorioCNPJ);
  		 login.setDocumento(pCartorioCNPJ);
  		 
  		cartorio.setNumeroCartorio(pNumeroCartorio);
  		cartorio.setNomeCartorio(pNomeCartorio);
  		cartorio.setLogradouro(pLogradouro);
  		cartorio.setCidade(pCidade);
  		cartorio.setEstado(pEstado);
  		if(pCep!=null && pCep.length() > 0) {
  			cartorio.setCep(Integer.parseInt(pCep));
  		}
  		cartorio.setTabeliaoNome(pTabeliaoNome);
  		cartorio.setTabeliaoCPF(pTabeliaoCPF);
  		cartorio.setTabeliaoEmail(pTabeliaoEmail);
  		cartorio.setSubstitutoNome(pSubstitutoNome);
  		cartorio.setSubstitutoCPF(pSubstitutoCPF);
  		cartorio.setSubstitutoEmail(pSubstitutoEmail); 
  		cartorio.setTelCartorio(pTelCartorio);
  		cartorio.setSituacaoCadastral(pSituacaoCadastral);
  		cartorio.setSite(pSite);
  		cartorio.setDataHoraFuncionamento(pDataHoraFuncionamento);
  		
  		login.setUsername(pUsername);
  		login.setPassword(pPassword);
  		login.setTipoPerfil(pTipoPerfil);*/

  		
  		CartorioService cs = new CartorioService();

  		RequestDispatcher view = null;
  		HttpSession session = request.getSession();

  		cs.excluir(cartorio.getId());
		@SuppressWarnings("unchecked")
		ArrayList<Cartorio> lista = (ArrayList<Cartorio>) session
				.getAttribute("lista");
		lista.remove(busca(cartorio, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarCartorio.jsp");
		view.forward(request, response);

	}
	public int busca(Cartorio cartorio, ArrayList<Cartorio> lista) {
  		Cartorio to;
  		for(int i = 0; i < lista.size(); i++){
  			to = lista.get(i);
  			if(to.getId() == cartorio.getId()){
  				return i;
  			}
  		}
  		return -1;
  	}



}
