package Service;

import java.util.ArrayList;

import DAO.EmpresaDao;
import Model.Empresa;
import Model.Usuario;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.ObjPtr;

public class EmpresaService {
	EmpresaDao dao;

	public EmpresaService() {
		dao = new EmpresaDao();
	}

	public int criar(Empresa empresa) {
		return dao.criar(empresa);
	}

	public void atualizar(Empresa empresa) {
		dao.atualizar(empresa);
	}

	public void atualizarPrimeiroAcesso(Empresa empresa, Usuario usuario) {
		dao.atualizarPrimeiroAcesso(empresa, usuario);
	}

	public ArrayList<Empresa> listarEmpresa() {
		return dao.listarEmpresa();
	}

	public ArrayList<Empresa> listarEmpresa(String chave) {
		return dao.listarEmpresa(chave);
	}

	public Empresa carregar(int id) {
		return dao.carregar(id);
	}
	public Empresa carregarEmpDocumento(String documento) {
		return dao.carregarEmpDocumento(documento);
	}
	public void excluir(int id) {
		dao.excluir(id);
	}

	public void atualizarEmpresaLogado(Empresa empresa) {
		 dao.atualizarEmpresaLogado(empresa);
		
	}

	public int MudarSituacaoCadastral(Empresa objPre) {
		return dao.MudarSituacaoCadastral(objPre);
	}

	public int AtivarSituacaoCadastral(Empresa objPre) {
		return dao.AtivarSituacaoCadastral(objPre);
	}

}
