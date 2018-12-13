package Service;

import java.util.ArrayList;

import DAO.PreCadastroDao;
import Model.Cartorio;
import Model.Empresa;
import Model.PreCadastro;


public class PreCadastroService {
	PreCadastroDao dao;
	
	public PreCadastroService() {
		 dao = new PreCadastroDao();
		}
	
	public Empresa validarEmpresa(PreCadastro precadastro){
		PreCadastroDao dao = new PreCadastroDao();
		return dao.validarEmpresa(precadastro);
	}
	
	public Cartorio validarCartorio(PreCadastro precadastro){
		PreCadastroDao dao = new PreCadastroDao();
		return dao.validarCartorio(precadastro);
	}

	public int criar(PreCadastro preCadastro) {
		return dao.criar(preCadastro);
	}

	public int TrasferirPreEmp(PreCadastro objPre) {
		return dao.TrasferirPreEmp(objPre);
	}
	
	public ArrayList<PreCadastro> listarPreCadastro(){
		return dao.listarPreCadastro();
	}
	public ArrayList<PreCadastro> listarPreCadastro(String chave){
		return dao.listarPreCadastro(chave);
	}
	
	public void excluir(int id) {
		dao.excluir(id);
	}

	public PreCadastro validarPrecadastro(PreCadastro precadastro){
		PreCadastroDao dao = new PreCadastroDao();
		return dao.validarPrecadastro(precadastro);
	}
	
	
}
