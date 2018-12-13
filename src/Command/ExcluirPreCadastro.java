package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.PreCadastro;
import Service.PreCadastroService;

public class ExcluirPreCadastro implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pId = request.getParameter("id");
		
        int idEmpresa = -1;
        
          try {
         			idEmpresa = Integer.parseInt(pId);
		 		} catch (NumberFormatException e) {
		 		}
         
         PreCadastro pre = new PreCadastro();
         pre.setId(idEmpresa);
  		
  		
  		PreCadastroService es = new PreCadastroService();

  		RequestDispatcher view = null;
  		HttpSession session = request.getSession();

  		es.excluir(pre.getId());
		@SuppressWarnings("unchecked")
		ArrayList<PreCadastro> lista = (ArrayList<PreCadastro>) session
				.getAttribute("lista");
		lista.remove(busca(pre, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarPreCadastro.jsp");
		view.forward(request, response);
		
	}
		public int busca(PreCadastro emp, ArrayList<PreCadastro> lista) {
	  		PreCadastro to;
	  		for(int i = 0; i < lista.size(); i++){
	  			to = lista.get(i);
	  			if(to.getId() == emp.getId()){
	  				return i;
	  			}
	  		}
	  		return -1;
	  	}
	}


