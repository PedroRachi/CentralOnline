package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Cartorio;
import Model.Empresa;
import Model.PreCadastro;

public class PreCadastroDao {

	ConnectionFactory cf = new ConnectionFactory();
	PreCadastro precadastro;

	public Cartorio validarCartorio(PreCadastro precadastro) {
		String sqlSelect = "select id, cartorioCNPJ, tipoPerfil, razaoSocial, tabeliaoEmail, situacaoCadastral from Cartorio where cartorioCNPJ = ?";
		Cartorio pre = new Cartorio();
		try {
			Connection conn = cf.obtemConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, precadastro.getCnpf_cnpj());

				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						// atribuindo valores no objeto;

						pre.setId(rs.getInt("id"));
						pre.setTipoPerfil(rs.getString("tipoPerfil"));
						pre.setCartorioCNPJ(rs.getString("cartorioCNPJ"));
						pre.setRazaoSocial(rs.getString("razaoSocial"));
						pre.setTabeliaoEmail(rs.getString("tabeliaoEmail"));
						pre.setSituacaoCadastral(rs.getString("situacaoCadastral"));
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

	public Empresa validarEmpresa(PreCadastro precadastro) {
		String sqlSelect = "SELECT id, empresaCNPJ, tipoPerfil, razaoSocial, contatoPrincipalEmail, situacaoCadastral, dataAbertura  FROM Empresa WHERE empresaCNPJ = ?";
		Empresa pre = new Empresa();
		try {
			Connection conn = cf.obtemConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, precadastro.getCnpf_cnpj());

				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {

						// atribuindo valores no objeto;

						pre.setId(rs.getInt("id"));
						pre.setTipoPerfil(rs.getString("tipoPerfil"));
						pre.setEmpresaCNPJ(rs.getString("empresaCNPJ"));
						pre.setRazaoSocial(rs.getString("razaoSocial"));
						pre.setContatoPrincipalEmail(rs.getString("contatoPrincipalEmail"));
						pre.setSituacaoCadastral(rs.getString("situacaoCadastral"));
						pre.setDataAbertura(rs.getString("dataAbertura"));
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
	
	
	
	public PreCadastro validarPrecadastro(PreCadastro precadastro) {
		String sqlSelect = "SELECT id, documentoCpfCnpj, email, razao_social, tipoCadastro, situacao FROM precadastro WHERE documentoCpfCnpj = ?";
		PreCadastro pre = new PreCadastro();
		try {
			Connection conn = cf.obtemConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, precadastro.getCnpf_cnpj());

				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {

						// atribuindo valores no objeto;

						pre.setId(rs.getInt("id"));
						pre.setCnpf_cnpj(rs.getString("documentoCpfCnpj"));
						pre.setEmail(rs.getString("email"));
						pre.setRazaoSocial(rs.getString("razao_social"));
						pre.setTipoCadastro(rs.getString("tipoCadastro"));
						pre.setSituacaoCadastral(rs.getString("situacao"));
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

	public int criar(PreCadastro preCadastro) {
		String sqlInsert = "INSERT INTO precadastro(documentoCpfCnpj,email,razao_social,tipoCadastro,situacao) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, preCadastro.getCnpf_cnpj());
			stm.setString(2, preCadastro.getEmail());
			stm.setString(3, preCadastro.getRazaoSocial());
			stm.setString(4, preCadastro.getTipoCadastro());
			stm.setString(5, preCadastro.getSituacaoCadastral());

			stm.execute();

			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					preCadastro.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preCadastro.getId();
	}
	
	
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM precadastro WHERE id = ?";
		try (Connection conn = cf.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				
			     stm.setInt(1, id);  /*stm.setInt(1, empresa.getId());*/
				
				stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public int TrasferirPreEmp(PreCadastro objPre) {
		String sqlSelect = "SELECT documentoCpfCnpj,email,razao_social,situacao, tipoCadastro FROM PreCadastro WHERE id = ?";
		int ret = -1;

		try {
			Connection conn = cf.obtemConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, objPre.getId());

				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						objPre.setCnpf_cnpj(rs.getString			("documentoCpfCnpj"));
						objPre.setEmail(rs.getString				("email"));
						objPre.setRazaoSocial(rs.getString			("razao_social"));
						objPre.setSituacaoCadastral(rs.getString	("situacao"));
						objPre.setTipoCadastro(rs.getString			("tipoCadastro"));

						// return false;
						
						String sqlInsertEmp = "";
						if(objPre.getTipoCadastro().equals("EMPRESA"))
							sqlInsertEmp = "INSERT INTO EMPRESA(empresaCNPJ,razaoSocial,contatoPrincipalEmail,situacaoCadastral,tipoPerfil ) VALUES (?, ?, ?, ?, ?)";
						else
							sqlInsertEmp = "INSERT INTO CARTORIO(cartorioCNPJ,razaoSocial,tabeliaoEmail,situacaoCadastral,tipoPerfil ) VALUES (?, ?, ?, ?, ?)";
						
						try (Connection conn2 = cf.obtemConexao();
								PreparedStatement stm2 = conn2.prepareStatement(sqlInsertEmp);) {
							stm2.setString(1, objPre.getCnpf_cnpj());
							stm2.setString(2, objPre.getRazaoSocial());
							stm2.setString(3, objPre.getEmail());
							stm2.setString(4, objPre.getSituacaoCadastral());
							stm2.setString(5, objPre.getTipoCadastro());

							stm2.execute();

							String sqlQuery = "SELECT LAST_INSERT_ID()";
							try (PreparedStatement stm3 = conn2.prepareStatement(sqlQuery);
									ResultSet rs3 = stm3.executeQuery();) {
								if (rs3.next()) {
									ret = rs.getInt(1);

									// fazer update da situacao do precadastro
									String sqlUpdate = "UPDATE preCadastro SET situacao=? WHERE id=?";

									try (Connection conn4 = cf.obtemConexao();
											PreparedStatement stm4 = conn4.prepareStatement(sqlUpdate);) {
										stm4.setString(1, "Validado");
										stm4.setInt(2, objPre.getId());
										stm4.execute();

									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
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
		return ret;
	}

	public ArrayList<PreCadastro> listarPreCadastro() {
		PreCadastro preCadastro;
		ArrayList<PreCadastro> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, documentoCpfCnpj, razao_social, situacao, email, tipoCadastro FROM precadastro";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					preCadastro = new PreCadastro();
					preCadastro.setId(rs.getInt("id"));
					preCadastro.setCnpf_cnpj(rs.getString("documentoCpfCnpj"));
					preCadastro.setRazaoSocial(rs.getString("razao_social"));
					preCadastro.setSituacaoCadastral(rs.getString("situacao"));
					preCadastro.setEmail(rs.getString("email"));
					preCadastro.setTipoCadastro(rs.getString("tipoCadastro"));
					lista.add(preCadastro);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<PreCadastro> listarPreCadastro(String chave) {
		PreCadastro preCadastro;
		ArrayList<PreCadastro> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, documentoCpfCnpj, razao_social, situacao, email, tipoCadastro FROM precadastro where upper(razao_social) like ?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					preCadastro = new PreCadastro();
					preCadastro.setId(rs.getInt("id"));
					preCadastro.setCnpf_cnpj(rs.getString("documentoCpfCnpj"));
					preCadastro.setRazaoSocial(rs.getString("razao_social"));
					preCadastro.setSituacaoCadastral(rs.getString("situacao"));
					preCadastro.setEmail(rs.getString("email"));
					preCadastro.setTipoCadastro(rs.getString("tipoCadastro"));

					lista.add(preCadastro);
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
