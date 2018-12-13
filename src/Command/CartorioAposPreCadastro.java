package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cartorio;
import Model.Email;
import Model.Usuario;
import Service.CartorioService;

public class CartorioAposPreCadastro implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
        String pSituacaoCadastral = "Ativo";
        String pSite = request.getParameter("site");
        String pDataHoraFuncionamento = request.getParameter("dataHoraFuncionamento");
        String pTipoPerfil = request.getParameter("tipoPerfil");
        String pSenhaAcesso = request.getParameter("senhaAcesso");
        
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

  		
  		Email em = new Email();
		em.enviarPadrao(pTabeliaoEmail, "Olá somos o grupo KIDEAMIRUM, Seu cadastro foi aprovado ",
				"Boas Vindas, Agora você tem total acesso a central como um Cartorio'"
				+ "\n\n\n\n\n\n\n\n\n\n\n"
				+ "Esse é um e-mail automatico, favor não responder");
  		
  		
  		
  		
  		CartorioService cs = new CartorioService();

  		RequestDispatcher view = null;
  		HttpSession session = request.getSession();
  		
  		Usuario usuario = new Usuario();
  		
  		
  		usuario.setId(cartorio.getId());
  		usuario.setDocumentoCPFCNPJEmpresa(cartorio.getTabeliaoCPF());
		usuario.setDocumentoEmpresa(cartorio.getCartorioCNPJ());
		usuario.setNomeUsuario(cartorio.getTabeliaoNome());
		usuario.setEmailUsuario(cartorio.getTabeliaoEmail());
		usuario.setSituacaoCadastral("Ativo");
		
		//aqui controla o perfil
		usuario.setIdTipoPerfil(1);
		usuario.setSenha(pSenhaAcesso);
		usuario.setTipoCadastro(cartorio.getTipoPerfil());	

  		cs.atualizarPrimeiroAcesso(cartorio, usuario);
  		
  		request.setAttribute("cartorio", cartorio);
  		view = request.getRequestDispatcher("index.jsp");
  		
  		view.forward(request, response);

  	}


  }
