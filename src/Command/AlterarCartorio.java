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

public class AlterarCartorio implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pId = request.getParameter("id");
		String pCartorioCNPJ = request.getParameter("cartorioCNPJ");
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
        String pSituacaoCadastral = ("Ativo");
        String pSite = request.getParameter("site");
        String pDataHoraFuncionamento = request.getParameter("dataHoraFuncionamento");
        String pSenhaAcesso = request.getParameter("senhaAcesso");
        String pTipoPerfil = request.getParameter("tipoPerfil");
        
        int idCartorio = -1;
        
          try {
        	  	idCartorio = Integer.parseInt(pId);
		 		} catch (NumberFormatException e) {
		 		}
         Cartorio cartorio = new Cartorio();

         cartorio.setId(idCartorio);
         
         cartorio.setCartorioCNPJ(pCartorioCNPJ);
  		 
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
  		cartorio.setSituacaoCadastral(pSituacaoCadastral);
  		cartorio.setSite(pSite);
  		cartorio.setDataHoraFuncionamento(pDataHoraFuncionamento);
  		cartorio.setTipoPerfil(pTipoPerfil);
  		cartorio.setSenhaAcesso(pSenhaAcesso);
  		
  		CartorioService cs = new CartorioService();

  		RequestDispatcher view = null;
  		HttpSession session = request.getSession();
  		
		cs.atualizar(cartorio);
  		
		@SuppressWarnings("unchecked")
		ArrayList<Cartorio> lista = (ArrayList<Cartorio>) session
				.getAttribute("lista");
		int pos = busca(cartorio, lista);
		lista.remove(pos);
		lista.add(pos, cartorio);
		session.setAttribute("lista", lista);
		request.setAttribute("cartorio", cartorio);
		view = request.getRequestDispatcher("VisualizarCartorio.jsp");

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
