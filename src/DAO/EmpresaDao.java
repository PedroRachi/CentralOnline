package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Empresa;
import Model.Usuario;

public class EmpresaDao {

	ConnectionFactory cf = new ConnectionFactory();
	Empresa empresa;

	public int MudarSituacaoCadastral(Empresa objPre) {
		String sqlUpdate = "UPDATE empresa SET situacaoCadastral=? WHERE id=?";
		int ret = -1;
		try (Connection conn4 = cf.obtemConexao(); PreparedStatement stm4 = conn4.prepareStatement(sqlUpdate);) {
			stm4.setString(1, "Bloqueado");
			stm4.setInt(2, objPre.getId());
			stm4.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public int AtivarSituacaoCadastral(Empresa objPre) {
		String sqlUpdate = "UPDATE empresa SET situacaoCadastral=? WHERE id=?";
		int ret = -1;
		try (Connection conn4 = cf.obtemConexao(); PreparedStatement stm4 = conn4.prepareStatement(sqlUpdate);) {
			stm4.setString(1, "Ativo");
			stm4.setInt(2, objPre.getId());
			stm4.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	
	
	
	
	public int criar(Empresa empresa) {
		String sqlInsert = "INSERT INTO empresa(empresaCNPJ, razaoSocial, logradouro, cidade, estado, cep,"
				+ "telEmpresa, contatoPrincipalNome, contatoPrincipalCPF, contatoPrincipalEmail, situacaoCadastral,"
				+ "site, dataAbertura, descriAtvEconomicas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, empresa.getEmpresaCNPJ());
			stm.setString(2, empresa.getRazaoSocial());
			stm.setString(3, empresa.getLogradouro());
			stm.setString(4, empresa.getCidade());
			stm.setString(5, empresa.getEstado());
			stm.setInt(6, empresa.getCep());
			stm.setString(7, empresa.getTelefone());
			stm.setString(8, empresa.getContatoPrincipalNome());
			stm.setString(9, empresa.getContatoPrincipalCPF());
			stm.setString(10, empresa.getContatoPrincipalEmail());
			stm.setString(11, empresa.getSituacaoCadastral());
			stm.setString(12, empresa.getSite());
			stm.setString(13, empresa.getDataAbertura());
			stm.setString(14, empresa.getDescriAtvEconomicas());
			stm.execute();

			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					empresa.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empresa.getId();
	}

	public void atualizar(Empresa empresa) {
		String sqlUpdate = "UPDATE empresa SET empresaCNPJ=?, razaoSocial=?, logradouro=?, cidade=?, estado=?, cep=?,"
				+ "telEmpresa=?, contatoPrincipalNome=?, contatoPrincipalCPF=?, contatoPrincipalEmail=?, situacaoCadastral=?,"
				+ "site=?, dataAbertura=?, descriAtvEconomicas=?, tipoPerfil=?, senhaAcesso=? WHERE id=?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, empresa.getEmpresaCNPJ());
			stm.setString(2, empresa.getRazaoSocial());
			stm.setString(3, empresa.getLogradouro());
			stm.setString(4, empresa.getCidade());
			stm.setString(5, empresa.getEstado());
			stm.setInt(6, empresa.getCep());
			stm.setString(7, empresa.getTelefone());
			stm.setString(8, empresa.getContatoPrincipalNome());
			stm.setString(9, empresa.getContatoPrincipalCPF());
			stm.setString(10, empresa.getContatoPrincipalEmail());
			stm.setString(11, empresa.getSituacaoCadastral());
			stm.setString(12, empresa.getSite());
			stm.setString(13, empresa.getDataAbertura());
			stm.setString(14, empresa.getDescriAtvEconomicas());
			stm.setString(15, empresa.getTipoPerfil());
			stm.setString(16, empresa.getSenhaAcesso());
			stm.setInt(17, empresa.getId());

			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void atualizarEmpresaLogado(Empresa empresa) {
		String sqlUpdate = "UPDATE empresa SET razaoSocial=?, logradouro=?, cidade=?, estado=?, cep=?,"
				+ "telEmpresa=?, contatoPrincipalNome=?, contatoPrincipalCPF=?, contatoPrincipalEmail=?,"
				+ "site=?, dataAbertura=?, descriAtvEconomicas=? WHERE id=?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, empresa.getRazaoSocial());
			stm.setString(2, empresa.getLogradouro());
			stm.setString(3, empresa.getCidade());
			stm.setString(4, empresa.getEstado());
			stm.setInt   (5, empresa.getCep());
			stm.setString(6, empresa.getTelefone());
			stm.setString(7, empresa.getContatoPrincipalNome());
			stm.setString(8, empresa.getContatoPrincipalCPF());
			stm.setString(9, empresa.getContatoPrincipalEmail());
			stm.setString(10, empresa.getSite());
			stm.setString(11, empresa.getDataAbertura());
			stm.setString(12, empresa.getDescriAtvEconomicas());
			stm.setInt   (13, empresa.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void atualizarPrimeiroAcesso(Empresa empresa, Usuario usuario) {
		String sqlUpdate = "UPDATE empresa SET empresaCNPJ=?, razaoSocial=?, logradouro=?, cidade=?, estado=?, cep=?,"
				+ "telEmpresa=?, contatoPrincipalNome=?, contatoPrincipalCPF=?, contatoPrincipalEmail=?, situacaoCadastral=?,"
				+ "site=?, dataAbertura=?, descriAtvEconomicas=?, tipoPerfil=?, senhaAcesso=? WHERE id=?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, empresa.getEmpresaCNPJ());
			stm.setString(2, empresa.getRazaoSocial());
			stm.setString(3, empresa.getLogradouro());
			stm.setString(4, empresa.getCidade());
			stm.setString(5, empresa.getEstado());
			stm.setInt(6, empresa.getCep());
			stm.setString(7, empresa.getTelefone());
			stm.setString(8, empresa.getContatoPrincipalNome());
			stm.setString(9, empresa.getContatoPrincipalCPF());
			stm.setString(10, empresa.getContatoPrincipalEmail());
			stm.setString(11, empresa.getSituacaoCadastral());
			stm.setString(12, empresa.getSite());
			stm.setString(13, empresa.getDataAbertura());
			stm.setString(14, empresa.getDescriAtvEconomicas());
			stm.setString(15, empresa.getTipoPerfil());
			stm.setString(16, empresa.getSenhaAcesso());
			stm.setInt(17, empresa.getId());

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
		String sqlDelete = "DELETE FROM empresa WHERE id = ?";
		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {

			stm.setInt(1, id); /* stm.setInt(1, empresa.getId()); */

			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Empresa carregarEmpDocumento(String documento) {
		Empresa empresa = new Empresa();
		
		String sqlSelect = "SELECT id, empresaCNPJ, razaoSocial, logradouro, cidade, estado, cep,"
				+ "telEmpresa, contatoPrincipalNome, contatoPrincipalCPF, contatoPrincipalEmail, situacaoCadastral,"
				+ "site, dataAbertura, descriAtvEconomicas, tipoPerfil, senhaAcesso FROM Empresa WHERE empresa.empresaCNPJ = ?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, documento);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					empresa.setEmpresaCNPJ(rs.getString("empresaCNPJ"));
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setLogradouro(rs.getString("logradouro"));
					empresa.setCidade(rs.getString("cidade"));
					empresa.setEstado(rs.getString("estado"));
					empresa.setCep(rs.getInt("cep"));
					empresa.setTelefone(rs.getString("telEmpresa"));
					empresa.setContatoPrincipalNome(rs.getString("contatoPrincipalNome"));
					empresa.setContatoPrincipalCPF(rs.getString("contatoPrincipalCPF"));
					empresa.setContatoPrincipalEmail(rs.getString("contatoPrincipalEmail"));
					empresa.setSituacaoCadastral(rs.getString("situacaoCadastral"));
					empresa.setSite(rs.getString("site"));
					empresa.setDataAbertura(rs.getString("dataAbertura"));
					empresa.setDescriAtvEconomicas(rs.getString("descriAtvEconomicas"));
					empresa.setTipoPerfil(rs.getString("tipoPerfil"));
					empresa.setSenhaAcesso(rs.getString("senhaAcesso"));
					empresa.setId(rs.getInt("id"));
				} else {
					empresa.setId(-1);
					empresa.setEmpresaCNPJ(null);
					empresa.setRazaoSocial(null);
					empresa.setLogradouro(null);
					empresa.setCidade(null);
					empresa.setEstado(null);
					empresa.setCep(-1);
					empresa.setTelefone(null);
					empresa.setContatoPrincipalNome(null);
					empresa.setContatoPrincipalCPF(null);
					empresa.setContatoPrincipalEmail(null);
					empresa.setSituacaoCadastral(null);
					empresa.setSite(null);
					empresa.setDataAbertura(null);
					empresa.setDescriAtvEconomicas(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return empresa;
	}

	public Empresa carregar(int id) {
		Empresa empresa = new Empresa();
		empresa.setId(id);
		String sqlSelect = "SELECT empresaCNPJ, razaoSocial, logradouro, cidade, estado, cep,"
				+ "telEmpresa, contatoPrincipalNome, contatoPrincipalCPF, contatoPrincipalEmail, situacaoCadastral,"
				+ "site, dataAbertura, descriAtvEconomicas, tipoPerfil, senhaAcesso FROM Empresa WHERE empresa.id = ?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, empresa.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					empresa.setEmpresaCNPJ(rs.getString("empresaCNPJ"));
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setLogradouro(rs.getString("logradouro"));
					empresa.setCidade(rs.getString("cidade"));
					empresa.setEstado(rs.getString("estado"));
					empresa.setCep(rs.getInt("cep"));
					empresa.setTelefone(rs.getString("telEmpresa"));
					empresa.setContatoPrincipalNome(rs.getString("contatoPrincipalNome"));
					empresa.setContatoPrincipalCPF(rs.getString("contatoPrincipalCPF"));
					empresa.setContatoPrincipalEmail(rs.getString("contatoPrincipalEmail"));
					empresa.setSituacaoCadastral(rs.getString("situacaoCadastral"));
					empresa.setSite(rs.getString("site"));
					empresa.setDataAbertura(rs.getString("dataAbertura"));
					empresa.setDescriAtvEconomicas(rs.getString("descriAtvEconomicas"));
					empresa.setTipoPerfil(rs.getString("tipoPerfil"));
					empresa.setSenhaAcesso(rs.getString("senhaAcesso"));
				} else {
					empresa.setId(-1);
					empresa.setEmpresaCNPJ(null);
					empresa.setRazaoSocial(null);
					empresa.setLogradouro(null);
					empresa.setCidade(null);
					empresa.setEstado(null);
					empresa.setCep(-1);
					empresa.setTelefone(null);
					empresa.setContatoPrincipalNome(null);
					empresa.setContatoPrincipalCPF(null);
					empresa.setContatoPrincipalEmail(null);
					empresa.setSituacaoCadastral(null);
					empresa.setSite(null);
					empresa.setDataAbertura(null);
					empresa.setDescriAtvEconomicas(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return empresa;
	}

	public ArrayList<Empresa> listarEmpresa() {
		Empresa empresa;
		ArrayList<Empresa> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, empresaCNPJ, razaoSocial, situacaoCadastral, tipoPerfil FROM Empresa";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					empresa = new Empresa();
					empresa.setId(rs.getInt("id"));
					empresa.setEmpresaCNPJ(rs.getString("empresaCNPJ"));
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setSituacaoCadastral(rs.getString("situacaoCadastral"));
					empresa.setTipoPerfil(rs.getString("tipoPerfil"));
					lista.add(empresa);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Empresa> listarEmpresa(String chave) {
		Empresa empresa;
		ArrayList<Empresa> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, empresaCNPJ, razaoSocial, situacaoCadastral, tipoPerfil FROM Empresa where upper(razaoSocial) like ?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					empresa = new Empresa();
					empresa.setId(rs.getInt("id"));
					empresa.setEmpresaCNPJ(rs.getString("empresaCNPJ"));
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setSituacaoCadastral(rs.getString("situacaoCadastral"));
					empresa.setTipoPerfil(rs.getString("tipoPerfil"));
					lista.add(empresa);
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
