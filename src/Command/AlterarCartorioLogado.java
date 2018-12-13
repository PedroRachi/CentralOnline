package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cartorio;
import Model.Usuario;
import Service.CartorioService;

public class AlterarCartorioLogado implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String pId = request.getParameter("id");
		
        String pNumeroCartorio = request.getParameter("numeroCartorio");
        String pRazaoSocial = request.getParameter("razaoSocial");
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
       
        String pSite = request.getParameter("site");
        String pDataHoraFuncionamento = request.getParameter("dataHoraFuncionamento");
      
        
        int idCartorio = -1;
        
        
          try {
        	  	idCartorio = Integer.parseInt(pId);
		 		} catch (NumberFormatException e) {
		 		}
        Cartorio cartorio = new Cartorio();

        cartorio.setId(idCartorio);
        
       
  		
        cartorio.setNumeroCartorio(pNumeroCartorio);
  		cartorio.setRazaoSocial(pRazaoSocial);
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
  		
  		cartorio.setSite(pSite);
  		cartorio.setDataHoraFuncionamento(pDataHoraFuncionamento);
  		
  		CartorioService cs = new CartorioService();

  		RequestDispatcher view = null;
  		HttpSession session = request.getSession();
  		
  	

  		cs.atualizarCartorioLogado(cartorio);
  		
  		request.setAttribute("cartorio", cartorio);
  		view = request.getRequestDispatcher("IndexCartorio.jsp");
  		
  		view.forward(request, response);

  	}


  }
