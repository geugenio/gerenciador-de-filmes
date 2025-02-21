package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import entity.Contato;

public class ContatoDAO {
	public void cadastrarContato(Contato ctt) {
		String sql = "INSERT INTO CONTATO (NOMECOMPLETO, EMAIL, TELEFONE) VALUES (?, ?, ?)";
		
		try (PreparedStatement pstmt = Conexao.getConexao().prepareStatement(sql)){
			pstmt.setString(1, ctt.getNomeCompleto());
			pstmt.setString(2, ctt.getEmail());
			pstmt.setString(3, ctt.getTelefone());
			
			pstmt.execute();
						
		} catch (SQLException e) {
			System.err.println("ERRO AO CADASTRAR CONTATO: " +e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public List<Contato> listaContatos(){
		String sql = "SELECT * FROM CONTATO";
		List<Contato> contatos = new ArrayList<>();
		
		try(PreparedStatement pstmt = Conexao.getConexao().prepareStatement(sql)){
			ResultSet rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				Contato ctt = new Contato();
				ctt.setId(rs.getInt("IDCONTATO"));
				ctt.setNomeCompleto(rs.getString("NOMECOMPLETO"));
				ctt.setEmail( rs.getString("EMAIL"));
				ctt.setTelefone(rs.getString("TELEFONE"));
				contatos.add(ctt);
			}
			
			rs.close();
		} catch(SQLException e) {
			System.err.println("ERRO AO SELECIONAR CONTATOS: " +e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		return contatos;
	}
	
	
	
	public Contato selecaoContato(int id) {
		String sql = "SELECT * FROM CONTATO WHERE IDCONTATO = ?";
		Contato ctt = null;
		
		try(PreparedStatement pstmt = Conexao.getConexao().prepareStatement(sql)){
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				ctt = new Contato();
				ctt.setId(id);
				ctt.setNomeCompleto(rs.getString("NOMECOMPLETO"));
				ctt.setEmail( rs.getString("EMAIL"));
				ctt.setTelefone(rs.getString("TELEFONE"));
			}
			rs.close();
			
		} catch(SQLException e) {
			System.err.println("ERRO AO SELECIONAR CONTATO: " +e.getMessage());
			e.printStackTrace();
			return null;
		}
		return ctt;	
	}
	
	
	public int atualizarContato(int id, Contato ctt) {
		int colunasAtt = 0;
		String sql = "UPDATE CONTATO SET NOMECOMPLETO = ?, EMAIL = ?, TELEFONE = ? WHERE IDCONTATO = ?";
		try (PreparedStatement pstmt = Conexao.getConexao().prepareStatement(sql)){
			pstmt.setString(1, ctt.getNomeCompleto());
			pstmt.setString(2, ctt.getEmail());
			pstmt.setString(3, ctt.getTelefone());
			pstmt.setInt(4, id);
			colunasAtt = pstmt.executeUpdate();			
		} catch(SQLException e) {
			System.err.println("ERRO AO ATUALIZAR CONTATO: " +e.getMessage());
			e.printStackTrace();
		}
		return colunasAtt;
			
	}
	
	public int removerContato(int id) {
		int colunasAtt = 0;
		String sql = "DELETE FROM CONTATO WHERE IDCONTATO =?";
		try (PreparedStatement pstmt = Conexao.getConexao().prepareStatement(sql)){
			pstmt.setInt(1, id);
			colunasAtt = pstmt.executeUpdate();			
		} catch(SQLException e) {
			System.err.println("ERRO AO DELETAR CONTATO: " +e.getMessage());
			e.printStackTrace();
		}
		return colunasAtt;
	}
	
}
