package Service;

import java.util.ArrayList;

import DAO.CartorioDao;
import Model.Cartorio;
import Model.Usuario;


public class CartorioService {
	CartorioDao dao;

	public CartorioService() {
		 dao = new CartorioDao();
		}
		
		public int criar(Cartorio cartorio) {
			return dao.criar(cartorio);
		}
		
		public void atualizar(Cartorio cartorio) {
			dao.atualizar(cartorio);
		}
		
		public void excluir(int id){
			dao.excluir(id);
		}
		
		public ArrayList<Cartorio> listarCartorio(){
			return dao.listarCartorio();
		}
		public ArrayList<Cartorio> listarCartorio(String chave){
			return dao.listarCartorio(chave);
		}
		public Cartorio carregar(int id) {
			return  dao.carregar(id);
			}
		
		public Cartorio carregarCarDocumento(String documento) {
			return dao.carregarCarDocumento(documento);
		}


		public void atualizarPrimeiroAcesso(Cartorio cartorio, Usuario usuario) {
			dao.atualizarPrimeiroAcesso(cartorio, usuario);
			
		}

		public void atualizarCartorioLogado(Cartorio cartorio) {
			dao.atualizarCartorioLogado(cartorio);
		}}





