package Service;

import java.util.ArrayList;

import DAO.UsuarioAdicionalDao;
import Model.Usuario;

public class UsuarioAdicionalService {
	UsuarioAdicionalDao dao;

	public UsuarioAdicionalService() {
		dao = new UsuarioAdicionalDao();
	}

	public int criar(Usuario usuarioCartorio) {
		return dao.criar(usuarioCartorio);
	}

	public void atualizar(Usuario usuarioCartorio) {
		dao.atualizar(usuarioCartorio);
	}

	public void excluir(int id) {
		dao.excluir(id);
	}

	public ArrayList<Usuario> listarUsuarioCartorio() {
		return dao.listarUsuarioCartorio();
	}
	
	public ArrayList<Usuario> listarUsuarioCartorio1(String documento) {
		return dao.listarUsuarioCartorio1(documento);
	}
	
	public ArrayList<Usuario> listarUsuarioCartorio(String chave) {
		return dao.listarUsuarioCartorio(chave);
	}

	public Usuario carregar(int id) {
		return dao.carregar(id);
	}

	public Usuario carregarLogin(String documento,String senha) {
		return dao.carregarLogin(documento,senha);
	}
	public Object carregarObjetoLogado(String documento,String tipoCadastro) {
		return dao.carregarObjetoLogado(documento,tipoCadastro);
	}

	public int CriarUsuarioComumEmpresa(Usuario usuario) {
		return dao.CriarUsuarioComumEmpresa(usuario);
		
	}

	public void atualizarUsuarioEmpresa(Usuario usuario) {
		dao.atualizarUsuarioEmpresa(usuario);
		
	}

	public Usuario validarUsuario(Usuario usuario) {
		UsuarioAdicionalDao dao = new UsuarioAdicionalDao();
		return dao.validarUsuario(usuario);
	}

	public int MudarSituacaoCadastral(Usuario usuario) {
		return dao.MudarSituacaoCadastral(usuario);
	}

	public int AtivarSituacaoCadastral(Usuario usuario) {
		return dao.AtivarSituacaoCadastral(usuario);
	}

	
}
