package br.com.abtechi.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.abtechi.db.DBConnection;

public class ProgramDBInsert {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("INSERT INTO wp_term_taxonomy "
					+ "(term_id, taxonomy, description)"
					+ "VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, 1);
			ps.setString(2, "Categoria");
			ps.setInt(3, 1);
			
			int rowsAffected = ps.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = ps.getGeneratedKeys();

				while (rs.next()) {
					System.out.println(rs.getInt(1));
				}
				
				rs.close();
			} else {
				System.out.println("Nenhum registro atualizado!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection();
		}
	}

}
