package br.com.abtechi.application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.abtechi.db.DBConnection;

public class ProgramDBSelect {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from wp_posts");
						
			while (rs.next()) {
				System.out.println(rs.getInt("ID") + ", " + rs.getString("post_title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(st);
			DBConnection.closeConnection();
		}
	}

}
