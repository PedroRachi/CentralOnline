package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		RequestDispatcher view = null;
  		HttpSession session = request.getSession();
  		
  		session.invalidate();
  		
  		view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);

	
	}

}
