package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Termos;

public class TermosDao {

	ConnectionFactory cf = new ConnectionFactory();
	Termos termo;

	public ArrayList<Termos> listarTermos1(String documento) {
		Termos termos = new Termos();
		ArrayList<Termos> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, dadoDoUpload, documento, pdf FROM termo WHERE documento = ? ";
		
		
		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, documento);
			
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					termos = new Termos();
					termos.setId(rs.getInt("id"));
					termos.setDadoDoUpload(rs.getString("dadoDoUpload"));
					termos.setDocumento(rs.getString("documento"));
					lista.add(termos);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Termos> listarTermos(String chave) {
		Termos termos;
		ArrayList<Termos> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, dadoDoUpload, documento, pdf FROM termo where upper(dadoDoUpload) like ?";

		try (Connection conn = cf.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					termos = new Termos();
					termos.setId(rs.getInt("id"));
					termos.setDadoDoUpload(rs.getString("dadoDoUpload"));
					termos.setDocumento(rs.getString("documento"));
					lista.add(termos);
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
