package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cartorio;
import Service.CartorioService;

public class VisualizarCartorio implements Command {

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
        String pSituacaoCadastral = request.getParameter("situacaoCadastral");
        String pSite = request.getParameter("site");
        String pDataHoraFuncionamento = request.getParameter("dataHoraFuncionamento");*/

        int idCartorio = -1;
        
        
          try {
        	  	idCartorio = Integer.parseInt(pId);
		 		} catch (NumberFormatException e) {
		 		}
         Cartorio cartorio = new Cartorio();

         cartorio.setId(idCartorio);
         
         /*cartorio.setCartorioCNPJ(pCartorioCNPJ);
  		 
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
  		cartorio.setDataHoraFuncionamento(pDataHoraFuncionamento);*/

  		CartorioService cs = new CartorioService();
  		
  		RequestDispatcher view = null;
  		
  		cartorio = cs.carregar(cartorio.getId());
		request.setAttribute("cartorio", cartorio);
		view = request.getRequestDispatcher("VisualizarCartorio.jsp");
		
		view.forward(request, response);
	}

}
