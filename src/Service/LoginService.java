package Service;

import Model.Login;
import DAO.LoginDao;

public class LoginService {
	LoginDao dao;
	
	public LoginService() {
		 dao = new LoginDao();
		}
	
	public String validar(Login login){
		LoginDao dao = new LoginDao();
		return dao.validar(login);
	}

	public void criar(Login login) {		
	}

	public void atualizar(Login login) {
		
	}

	}
