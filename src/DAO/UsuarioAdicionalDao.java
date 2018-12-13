package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import Model.Usuario;
import Service.CartorioService;
import Service.EmpresaService;

public class UsuarioAdicionalDao {

	ConnectionFactory cf = new ConnectionFactory();
	Usuario usuarioCartorio;

	public int MudarSituacaoCadastral(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET situacaoCadastral=? WHERE id=?";
		int ret = -1;
		try (Connection conn4 = cf.obtemConexao(); PreparedStatement stm4 = conn4.prepareStatement(sqlUpdate);) {
			stm4.setString(1, "Bloqueado");
			stm4.setInt(2, usuario.getId());
			stm4.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public int AtivarSituacaoCadastral(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET situacaoCadastral=? WHERE id=?";
		int ret = -1;
		try (Connection conn4 = cf.obtemConexao(); PreparedStatement stm4 = conn4.prepareStatement(sqlUpdate);) {
			stm4.setString(1, "Ativo");
			stm4.setInt(2, usuario.getId());
			stm4.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public Usuario validarUsuario(Usuario usuario) {
		String sqlSelect = "select id, nomeUsuario, emailUsuario, situacaoCadastral, idPerfil, senha, tipoCadastro, DocumentoCPF_CNPJ, documentoEmpresa from usuario where DocumentoCPF_CNPJ = ?";
		Usuario pre = new Usuario();
		try {
			Connection conn = cf.obtemConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, usuario.getDocumentoCPFCNPJEmpresa());

				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						// atribuindo valores no objeto;

						pre.setId(rs.getInt("id"));
						pre.setNomeUsuario(rs.getString("nomeUsuario"));
						pre.setEmailUsuario(rs.getString("emailUsuario"));
						pre.setSituacaoCadastral(rs.getString("situacaoCadastral"));
						pre.setIdTipoPerfil(rs.getInt("idPerfil"));
						pre.setSenha(rs.getString("senha"));
						pre.setTipoCadastro(rs.getString("tipoCadastro"));
						pre.setDocumentoCPFCNPJEmpresa(rs.getString("DocumentoCPF_CNPJ"));
						pre.setDocumentoEmpresa(rs.getString("documentoEmpresa"));

						// return false;

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return pre;
	}

	public int criar(Usuario usuarioCartorio) {
		String sqlInsert = "INSERT INTO Usuario(nomeUsuario, emailUsuario, documentoCPF_CNPJ,  situacaoCadastral, "
				+ "documentoEmpresa) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuarioCartorio.getNomeUsuario());
			stm.setString(2, usuarioCartorio.getEmailUsuario());
			stm.setString(3, usuarioCartorio.getDocumentoCPFCNPJEmpresa());
			stm.setString(4, usuarioCartorio.getSituacaoCadastral());
			stm.setString(5, usuarioCartorio.getDocumentoEmpresa());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuarioCartorio.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioCartorio.getId();
	}

	public int CriarUsuarioComumEmpresa(Usuario usuario) {
		String sqlInsert = "INSERT INTO Usuario(nomeUsuario,emailusuario,documentocpf_cnpj,situacaocadastral,documentoempresa,idperfil,tipoCadastro,senha) VALUES(?,?,?,?,?,?,?,?)";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getNomeUsuario());
			stm.setString(2, usuario.getEmailUsuario());
			stm.setString(3, usuario.getDocumentoCPFCNPJEmpresa());
			stm.setString(4, usuario.getSituacaoCadastral());
			stm.setString(5, usuario.getDocumentoEmpresa());
			stm.setInt(6, usuario.getIdTipoPerfil());
			stm.setString(7, usuario.getTipoCadastro());
			stm.setString(8, usuario.getSenha());

			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getId();
	}

	public void atualizar(Usuario usuarioCartorio) {
		String sqlUpdate = "UPDATE Usuario SET nomeUsuario=?, emailUsuario=?, documentoCPF_CNPJ=?,  situacaoCadastral=?,"
				+ "documentoEmpresa=? WHERE id=?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuarioCartorio.getNomeUsuario());
			stm.setString(2, usuarioCartorio.getEmailUsuario());
			stm.setString(3, usuarioCartorio.getDocumentoCPFCNPJEmpresa());
			stm.setString(4, usuarioCartorio.getSituacaoCadastral());
			stm.setString(5, usuarioCartorio.getDocumentoEmpresa());
			stm.setInt(6, usuarioCartorio.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizarUsuarioEmpresa(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET senha =?  WHERE id=?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			// stm.setString(1, usuario.getEmailUsuario());
			stm.setString(1, usuario.getSenha());
			stm.setInt(2, usuario.getId());

			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM usuario WHERE id = ?";
		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {

			stm.setInt(1, id); /* stm.setInt(1, empresa.getId()); */

			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario carregar(int id) {
		Usuario usuarioCartorio = new Usuario();
		usuarioCartorio.setId(id);
		String sqlSelect = "SELECT nomeUsuario, emailUsuario, documentoCPF_CNPJ, situacaoCadastral, documentoEmpresa FROM usuario WHERE usuario.id = ?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuarioCartorio.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuarioCartorio.setNomeUsuario(rs.getString("nomeUsuario"));
					usuarioCartorio.setEmailUsuario(rs.getString("emailUsuario"));
					usuarioCartorio.setDocumentoCPFCNPJEmpresa(rs.getString("documentoCPF_CNPJ"));
					usuarioCartorio.setSituacaoCadastral(rs.getString("situacaoCadastral"));
					usuarioCartorio.setDocumentoEmpresa(rs.getString("documentoEmpresa"));

				} else {
					usuarioCartorio.setId(-1);
					usuarioCartorio.setNomeUsuario(null);
					usuarioCartorio.setEmailUsuario(null);
					usuarioCartorio.setDocumentoCPFCNPJEmpresa(null);
					usuarioCartorio.setSituacaoCadastral(null);
					usuarioCartorio.setDocumentoEmpresa(null);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuarioCartorio;
	}

	public Object carregarObjetoLogado(String documento, String tipoCadastro) {
		Object obj = new Object();
		switch (tipoCadastro) {
		case "EMPRESA":
			EmpresaService es = new EmpresaService();
			obj = es.carregarEmpDocumento(documento);
			break;
		case "CARTORIO":
			CartorioService cs = new CartorioService();
			obj = cs.carregarCarDocumento(documento);
			break;
		}
		return obj;
	}

	public Usuario carregarLogin(String documento, String senha) {
		Usuario usuario = new Usuario();

		String sqlSelect = "SELECT id,nomeUsuario, emailUsuario, documentoCPF_CNPJ, situacaoCadastral, documentoEmpresa,tipoCadastro,idPerfil, senha FROM usuario WHERE usuario.documentoCPF_CNPJ = ? and senha = ? ";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, documento);
			stm.setString(2, senha);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setId(Integer.parseInt(rs.getString("id")));
					usuario.setNomeUsuario(rs.getString("nomeUsuario"));
					usuario.setEmailUsuario(rs.getString("emailUsuario"));
					usuario.setDocumentoCPFCNPJEmpresa(rs.getString("documentoCPF_CNPJ"));
					usuario.setSituacaoCadastral(rs.getString("situacaoCadastral"));
					usuario.setDocumentoEmpresa(rs.getString("documentoEmpresa"));
					usuario.setTipoCadastro(rs.getString("tipoCadastro"));
					usuario.setIdTipoPerfil(Integer.parseInt(rs.getString("idPerfil")));
					usuario.setSenha(rs.getString("senha"));
				} else {
					usuario.setId(-1);
					usuario.setNomeUsuario(null);
					usuario.setEmailUsuario(null);
					usuario.setDocumentoCPFCNPJEmpresa(null);
					usuario.setSituacaoCadastral(null);
					usuario.setDocumentoEmpresa(null);
					usuario.setSenha(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}

	public ArrayList<Usuario> listarUsuarioCartorio1(String documento) {
		Usuario usuarioCartorio = new Usuario();
		ArrayList<Usuario> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nomeUsuario, documentoEmpresa, situacaoCadastral, tipoCadastro FROM usuario WHERE documentoEmpresa = ?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, documento);

			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					usuarioCartorio = new Usuario();
					usuarioCartorio.setId(rs.getInt("id"));
					usuarioCartorio.setNomeUsuario(rs.getString("nomeUsuario"));
					usuarioCartorio.setDocumentoEmpresa(rs.getString("documentoEmpresa"));
					usuarioCartorio.setSituacaoCadastral(rs.getString("situacaoCadastral"));
					usuarioCartorio.setTipoCadastro(rs.getString("tipoCadastro"));
					lista.add(usuarioCartorio);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Usuario> listarUsuarioCartorio() {
		Usuario usuarioCartorio;
		ArrayList<Usuario> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nomeUsuario, documentoEmpresa, situacaoCadastral, tipoCadastro FROM usuario";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					usuarioCartorio = new Usuario();
					usuarioCartorio.setId(rs.getInt("id"));
					usuarioCartorio.setNomeUsuario(rs.getString("nomeUsuario"));
					usuarioCartorio.setDocumentoEmpresa(rs.getString("documentoEmpresa"));
					usuarioCartorio.setSituacaoCadastral(rs.getString("situacaoCadastral"));
					usuarioCartorio.setTipoCadastro(rs.getString("tipoCadastro"));
					lista.add(usuarioCartorio);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Usuario> listarUsuarioCartorio(String chave) {
		Usuario usuarioCartorio;
		ArrayList<Usuario> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nomeUsuario, documentoEmpresa, situacaoCadastral, tipoCadastro FROM usuario where upper(nomeUsuario) like ?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					usuarioCartorio = new Usuario();
					usuarioCartorio.setId(rs.getInt("id"));
					usuarioCartorio.setNomeUsuario(rs.getString("nomeUsuario"));
					usuarioCartorio.setDocumentoEmpresa(rs.getString("documentoEmpresa"));
					usuarioCartorio.setSituacaoCadastral(rs.getString("situacaoCadastral"));
					usuarioCartorio.setTipoCadastro(rs.getString("tipoCadastro"));
					lista.add(usuarioCartorio);
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
