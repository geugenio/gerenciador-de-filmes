package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Conexão com o banco de dados
 * 
 * 
 * */

public class Conexao {
	private static final String urlBanco = "jdbc:mysql://localhost:3306/j_gerenciador_de_contatos";
	private static final String userBanco = "root";
	private static final String passwordBanco = "123456";
	
	public static Connection conn;
	public static Connection getConexao() {
		try {
			if(conn == null) {
				conn = DriverManager.getConnection(urlBanco, userBanco, passwordBanco);
				return conn;
			} else {
				return conn;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
