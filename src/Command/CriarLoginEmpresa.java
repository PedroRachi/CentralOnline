package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Login;
import Service.LoginService;

public class CriarLoginEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pId = request.getParameter("id");
        String pDocumento = request.getParameter("documento");
		String pUsername  = request.getParameter("username");
        String pPassword = request.getParameter("password");
        String pTipoPerfil = "empresadono";
        int idLogin = -1;
        
          try {
        	  idLogin = Integer.parseInt(pId);
		 		} catch (NumberFormatException e) {
		 		}
         Login login = new Login();

         login.setId(idLogin);
         login.setDocumento(pDocumento);
         login.setUsername(pUsername);
         login.setPassword(pPassword);
         login.setTipoPerfil(pTipoPerfil);
  		

  		LoginService ls = new LoginService();
  		
  		RequestDispatcher view = null;
  		HttpSession session = request.getSession();
  		
  		ls.criar(login);
  	
  		view = request.getRequestDispatcher("indexEmpresa.jsp");
  		
  		view.forward(request, response);
	}
}
