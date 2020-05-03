package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;

public class UsuarioDAO {
	
	public Cliente checkLogin(String nome , String senha) {
		Cliente cliente = new Cliente();
		String sqlSelect = "SELECT * FROM cliente.cliente WHERE nome =? and senha = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			stm.setString(1, nome);
			stm.setString(2, senha);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					cliente.setId(rs.getInt("id"));
					cliente.setNome(rs.getString("nome"));
					cliente.setEmail(rs.getString("email"));
					cliente.setSenha(rs.getString("senha"));
					cliente.setCidade(rs.getString("cidade"));
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return cliente;
	}
		
}
