package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Cartorio;
import Model.Usuario;

public class CartorioDao {

	ConnectionFactory cf = new ConnectionFactory();
	Cartorio cartorio;

	public int criar(Cartorio cartorio) {
		String sqlInsert = "INSERT INTO cartorio(cartorioCNPJ, numeroCartorio, razaoSocial, logradouro, cidade, estado, cep,"
				+ "tabeliaoNome, tabeliaoCPF,tabeliaoEmail, substitutoNome, substitutoCPF, substitutoEmail, telCartorio, situacaoCadastral,"
				+ " site, dataHoraFuncionamento) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, cartorio.getCartorioCNPJ());
			stm.setString(2, cartorio.getNumeroCartorio());
			stm.setString(3, cartorio.getRazaoSocial());
			stm.setString(4, cartorio.getLogradouro());
			stm.setString(5, cartorio.getCidade());
			stm.setString(6, cartorio.getEstado());
			stm.setInt(7, cartorio.getCep());
			stm.setString(8, cartorio.getTabeliaoNome());
			stm.setString(9, cartorio.getTabeliaoCPF());
			stm.setString(10, cartorio.getTabeliaoEmail());
			stm.setString(11, cartorio.getSubstitutoNome());
			stm.setString(12, cartorio.getSubstitutoCPF());
			stm.setString(13, cartorio.getSubstitutoEmail());
			stm.setString(14, cartorio.getTelCartorio());
			stm.setString(15, cartorio.getSituacaoCadastral());
			stm.setString(16, cartorio.getSite());
			stm.setString(17, cartorio.getDataHoraFuncionamento());
			stm.execute();

			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					cartorio.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cartorio.getId();
	}

	public void atualizar(Cartorio cartorio) {
		String sqlUpdate = "UPDATE cartorio SET cartorioCNPJ=?, numeroCartorio=?, razaoSocial=?, logradouro=?, cidade=?, estado=?, cep=?,"
				+ "tabeliaoNome=?, tabeliaoCPF=?, tabeliaoEmail=?, substitutoNome=?, substitutoCPF=?, substitutoEmail=?, telCartorio=?, situacaoCadastral=?,"
				+ " site=?, dataHoraFuncionamento=?, tipoPerfil=?, senhaAcesso=?  WHERE id=?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, cartorio.getCartorioCNPJ());
			stm.setString(2, cartorio.getNumeroCartorio());
			stm.setString(3, cartorio.getRazaoSocial());
			stm.setString(4, cartorio.getLogradouro());
			stm.setString(5, cartorio.getCidade());
			stm.setString(6, cartorio.getEstado());
			stm.setInt(7, cartorio.getCep());
			stm.setString(8, cartorio.getTabeliaoNome());
			stm.setString(9, cartorio.getTabeliaoCPF());
			stm.setString(10, cartorio.getTabeliaoEmail());
			stm.setString(11, cartorio.getSubstitutoNome());
			stm.setString(12, cartorio.getSubstitutoCPF());
			stm.setString(13, cartorio.getSubstitutoEmail());
			stm.setString(14, cartorio.getTelCartorio());
			stm.setString(15, cartorio.getSituacaoCadastral());
			stm.setString(16, cartorio.getSite());
			stm.setString(17, cartorio.getDataHoraFuncionamento());
			stm.setString(18, cartorio.getTipoPerfil());
			stm.setString(19, cartorio.getSenhaAcesso());
			stm.setInt(20, cartorio.getId());

			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	
	public void atualizarCartorioLogado(Cartorio cartorio) {
		String sqlUpdate = "UPDATE cartorio SET numeroCartorio=?, razaoSocial=?, logradouro=?, cidade=?, estado=?, cep=?,"
				+ "tabeliaoNome=?, tabeliaoCPF=?, tabeliaoEmail=?, substitutoNome=?, substitutoCPF=?, substitutoEmail=?, telCartorio=?,"
				+ " site=?, dataHoraFuncionamento=? WHERE id=?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, cartorio.getNumeroCartorio());
			stm.setString(2, cartorio.getRazaoSocial());
			stm.setString(3, cartorio.getLogradouro());
			stm.setString(4, cartorio.getCidade());
			stm.setString(5, cartorio.getEstado());
			stm.setInt   (6, cartorio.getCep());
			stm.setString(7, cartorio.getTabeliaoNome());
			stm.setString(8, cartorio.getTabeliaoCPF());
			stm.setString(9, cartorio.getTabeliaoEmail());
			stm.setString(10, cartorio.getSubstitutoNome());
			stm.setString(11, cartorio.getSubstitutoCPF());
			stm.setString(12, cartorio.getSubstitutoEmail());
			stm.setString(13, cartorio.getTelCartorio());
			stm.setString(14, cartorio.getSite());
			stm.setString(15, cartorio.getDataHoraFuncionamento());
			stm.setInt(16, cartorio.getId());

			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public void atualizarPrimeiroAcesso(Cartorio cartorio, Usuario usuario) {
		String sqlUpdate = "UPDATE cartorio SET cartorioCNPJ=?, numeroCartorio=?, razaoSocial=?, logradouro=?, cidade=?, estado=?, cep=?,"
				+ "tabeliaoNome=?, tabeliaoCPF=?, tabeliaoEmail=?, substitutoNome=?, substitutoCPF=?, substitutoEmail=?, telCartorio=?, situacaoCadastral=?,"
				+ " site=?, dataHoraFuncionamento=?, tipoPerfil=?, senhaAcesso=? WHERE id=?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, cartorio.getCartorioCNPJ());
			stm.setString(2, cartorio.getNumeroCartorio());
			stm.setString(3, cartorio.getRazaoSocial());
			stm.setString(4, cartorio.getLogradouro());
			stm.setString(5, cartorio.getCidade());
			stm.setString(6, cartorio.getEstado());
			stm.setInt(7, cartorio.getCep());
			stm.setString(8, cartorio.getTabeliaoNome());
			stm.setString(9, cartorio.getTabeliaoCPF());
			stm.setString(10, cartorio.getTabeliaoEmail());
			stm.setString(11, cartorio.getSubstitutoNome());
			stm.setString(12, cartorio.getSubstitutoCPF());
			stm.setString(13, cartorio.getSubstitutoEmail());
			stm.setString(14, cartorio.getTelCartorio());
			stm.setString(15, cartorio.getSituacaoCadastral());
			stm.setString(16, cartorio.getSite());
			stm.setString(17, cartorio.getDataHoraFuncionamento());
			stm.setString(18, cartorio.getTipoPerfil());
			stm.setString(19, cartorio.getSenhaAcesso());
			stm.setInt(20, cartorio.getId());

			stm.execute();
			try {
				String sqlInsert = "INSERT INTO usuario (nomeUsuario,emailusuario,documentocpf_cnpj,situacaocadastral,documentoempresa,idperfil,tipoCadastro,senha) VALUES(?,?,?,?,?,?,?,?)";
				Connection conn2 = cf.obtemConexao();
				PreparedStatement stm2 = conn2.prepareStatement(sqlInsert);

				stm2.setString(1, usuario.getNomeUsuario());
				stm2.setString(2, usuario.getEmailUsuario());
				stm2.setString(3, usuario.getDocumentoCPFCNPJEmpresa());
				stm2.setString(4, usuario.getSituacaoCadastral());
				stm2.setString(5, usuario.getDocumentoEmpresa());
				stm2.setInt(6, usuario.getIdTipoPerfil());
				stm2.setString(7, usuario.getTipoCadastro());
				stm2.setString(8, usuario.getSenha());

				stm2.execute();

			} catch (Exception erro) {
				erro.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM cartorio WHERE id = ?";
		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {

			stm.setInt(1, id); /* stm.setInt(1, empresa.getId()); */

			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Cartorio carregarCarDocumento(String documento) {
		Cartorio cartorio = new Cartorio();
		String sqlSelect = "SELECT id, cartorioCNPJ, numeroCartorio, razaoSocial, logradouro, cidade, estado,"
				+ "cep, tabeliaoNome, tabeliaoCPF, tabeliaoEmail, substitutoNome, substitutoCPF,"
				+ "substitutoEmail, telCartorio, situacaoCadastral,  site, dataHoraFuncionamento, tipoPerfil, senhaAcesso FROM Cartorio WHERE cartorio.cartorioCNPJ = ?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, documento);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					cartorio.setCartorioCNPJ(rs.getString("cartorioCNPJ"));
					cartorio.setNumeroCartorio(rs.getString("numeroCartorio"));
					cartorio.setRazaoSocial(rs.getString("razaoSocial"));
					cartorio.setLogradouro(rs.getString("logradouro"));
					cartorio.setCidade(rs.getString("cidade"));
					cartorio.setEstado(rs.getString("estado"));
					cartorio.setCep(rs.getInt("cep"));
					cartorio.setTabeliaoNome(rs.getString("tabeliaoNome"));
					cartorio.setTabeliaoCPF(rs.getString("tabeliaoCPF"));
					cartorio.setTabeliaoEmail(rs.getString("tabeliaoEmail"));
					cartorio.setSubstitutoNome(rs.getString("substitutoNome"));
					cartorio.setSubstitutoCPF(rs.getString("substitutoCPF"));
					cartorio.setSubstitutoEmail(rs.getString("substitutoEmail"));
					cartorio.setTelCartorio(rs.getString("telCartorio"));
					cartorio.setSituacaoCadastral(rs.getString("situacaoCadastral"));
					cartorio.setSite(rs.getString("site"));
					cartorio.setDataHoraFuncionamento(rs.getString("dataHoraFuncionamento"));
					cartorio.setTipoPerfil(rs.getString("tipoPerfil"));
					cartorio.setSenhaAcesso(rs.getString("senhaAcesso"));
					cartorio.setId(rs.getInt("id"));
				} else {
					cartorio.setCartorioCNPJ(null);
					cartorio.setNumeroCartorio(null);
					cartorio.setRazaoSocial(null);
					cartorio.setLogradouro(null);
					cartorio.setCidade(null);
					cartorio.setEstado(null);
					cartorio.setCep(-1);
					cartorio.setTabeliaoNome(null);
					cartorio.setTabeliaoCPF(null);
					cartorio.setTabeliaoEmail(null);
					cartorio.setSubstitutoNome(null);
					cartorio.setSubstitutoCPF(null);
					cartorio.setSubstitutoEmail(null);
					cartorio.setTelCartorio(null);
					cartorio.setSituacaoCadastral(null);
					cartorio.setSite(null);
					cartorio.setDataHoraFuncionamento(null);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return cartorio;
	}

	public Cartorio carregar(int id) {
		Cartorio cartorio = new Cartorio();
		cartorio.setId(id);
		String sqlSelect = "SELECT cartorioCNPJ, numeroCartorio, razaoSocial, logradouro, cidade, estado,"
				+ "cep, tabeliaoNome, tabeliaoCPF, tabeliaoEmail, substitutoNome, substitutoCPF,"
				+ "substitutoEmail, telCartorio, situacaoCadastral,  site, dataHoraFuncionamento, tipoPerfil, senhaAcesso FROM Cartorio WHERE cartorio.id = ?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, cartorio.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					cartorio.setCartorioCNPJ(rs.getString("cartorioCNPJ"));
					cartorio.setNumeroCartorio(rs.getString("numeroCartorio"));
					cartorio.setRazaoSocial(rs.getString("razaoSocial"));
					cartorio.setLogradouro(rs.getString("logradouro"));
					cartorio.setCidade(rs.getString("cidade"));
					cartorio.setEstado(rs.getString("estado"));
					cartorio.setCep(rs.getInt("cep"));
					cartorio.setTabeliaoNome(rs.getString("tabeliaoNome"));
					cartorio.setTabeliaoCPF(rs.getString("tabeliaoCPF"));
					cartorio.setTabeliaoEmail(rs.getString("tabeliaoEmail"));
					cartorio.setSubstitutoNome(rs.getString("substitutoNome"));
					cartorio.setSubstitutoCPF(rs.getString("substitutoCPF"));
					cartorio.setSubstitutoEmail(rs.getString("substitutoEmail"));
					cartorio.setTelCartorio(rs.getString("telCartorio"));
					cartorio.setSituacaoCadastral(rs.getString("situacaoCadastral"));
					cartorio.setSite(rs.getString("site"));
					cartorio.setDataHoraFuncionamento(rs.getString("dataHoraFuncionamento"));
					cartorio.setTipoPerfil(rs.getString("tipoPerfil"));
					cartorio.setSenhaAcesso(rs.getString("senhaAcesso"));
				} else {
					cartorio.setCartorioCNPJ(null);
					cartorio.setNumeroCartorio(null);
					cartorio.setRazaoSocial(null);
					cartorio.setLogradouro(null);
					cartorio.setCidade(null);
					cartorio.setEstado(null);
					cartorio.setCep(-1);
					cartorio.setTabeliaoNome(null);
					cartorio.setTabeliaoCPF(null);
					cartorio.setTabeliaoEmail(null);
					cartorio.setSubstitutoNome(null);
					cartorio.setSubstitutoCPF(null);
					cartorio.setSubstitutoEmail(null);
					cartorio.setTelCartorio(null);
					cartorio.setSituacaoCadastral(null);
					cartorio.setSite(null);
					cartorio.setDataHoraFuncionamento(null);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return cartorio;
	}

	public ArrayList<Cartorio> listarCartorio() {
		Cartorio cartorio;
		ArrayList<Cartorio> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, cartorioCNPJ, razaoSocial, situacaoCadastral, tipoPerfil FROM Cartorio";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					cartorio = new Cartorio();
					cartorio.setId(rs.getInt("id"));
					cartorio.setCartorioCNPJ(rs.getString("cartorioCNPJ"));
					cartorio.setRazaoSocial(rs.getString("razaoSocial"));
					cartorio.setSituacaoCadastral(rs.getString("situacaoCadastral"));
					cartorio.setTipoPerfil(rs.getString("tipoPerfil"));
					lista.add(cartorio);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Cartorio> listarCartorio(String chave) {
		Cartorio cartorio;
		ArrayList<Cartorio> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, cartorioCNPJ, razaoSocial, situacaoCadastral, tipoPerfil FROM Cartorio where upper(nomeCartorio) like ?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					cartorio = new Cartorio();
					cartorio.setId(rs.getInt("id"));
					cartorio.setCartorioCNPJ(rs.getString("cartorioCNPJ"));
					cartorio.setRazaoSocial(rs.getString("razaoSocial"));
					cartorio.setSituacaoCadastral(rs.getString("situacaoCadastral"));
					cartorio.setTipoPerfil(rs.getString("tipoPerfil"));
					lista.add(cartorio);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}
