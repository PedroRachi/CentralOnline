package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Login;
import DAO.ConnectionFactory;

public class LoginDao {
	ConnectionFactory cf = new ConnectionFactory();
	Login login;

	
	public String validar(Login usuario) {
		String sqlSelect = "SELECT username, password, tipoPerfil FROM Login "
				+ "WHERE username = ? and password = ?";
		String ret = "";
		//Login objLogin= new Login();
		try {
			Connection conn = cf.obtemConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, usuario.getUsername());
				stm.setString(2, usuario.getPassword());
				
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {						
						ret = rs.getString("tipoPerfil");
						//return true;
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
	
	public void criar(Login login) {
		String sqlInsert = "INSERT INTO Login(documento, username, password, tipoPerfil) VALUES(?,?,?,?)";
		
		try (Connection conn = cf.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setString(1, login.getDocumento());
				stm.setString(2, login.getUsername());
				stm.setString(3, login.getPassword());
				stm.setString(4, login.getTipoPerfil());
				stm.execute();
		
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

	public void atualizar(Login login) {
		String sqlUpdate ="UPDATE login set username=?, password=?, tipoPerfil=? WHERE username=?";
		try (Connection conn = cf.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
					stm.setString(1, login.getUsername());
					stm.setString(2, login.getPassword());
					stm.setString(3, login.getTipoPerfil());
					stm.setString(4, login.getUsername());
					stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
		
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM login WHERE username = ?";
		try (Connection conn = cf.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setString(1, login.getUsername());
				stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	}
	

