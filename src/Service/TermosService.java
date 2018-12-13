package Service;

import java.util.ArrayList;

import DAO.TermosDao;
import Model.Termos;

public class TermosService {
	TermosDao dao;

	public TermosService() {
		dao = new TermosDao();
	}

	public ArrayList<Termos> listarTermos1(String documento) {
		return dao.listarTermos1(documento);
	}

	public ArrayList<Termos> listarTermos(String chave) {
		return dao.listarTermos(chave);
	}

}
