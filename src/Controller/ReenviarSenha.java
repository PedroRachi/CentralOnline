package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmpresaDao;
import Model.Email;
import Model.Empresa;

@WebServlet("/ReenviarSenha")
public class ReenviarSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReenviarSenha() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	Email email = new Email();
		String usuario = request.getParameter("usuario");
		
		//EmpresaDAO empresaDAO = new EmpresaDAO();
	//	Empresa empresa = empresaDAO.logar(usuario);
	
//	if (empresa.getId() != -1) {
	//	email.enviarPadrao(empresa.getEmail(), "Confirmação de senha", "Sua senha é "+empresa.getSenha());
		
        RequestDispatcher view =  request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
        }
	}
		
		
	


