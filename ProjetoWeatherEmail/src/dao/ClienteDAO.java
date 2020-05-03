package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;


import model.Cliente;
public class ClienteDAO {
		public int criar(Cliente cliente) {
		String sqlInsert = "INSERT INTO cliente.cliente(nome, email, senha, cidade) VALUES (?, ?, ?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getEmail());
			stm.setString(3, cliente.getSenha());
			stm.setString(4, cliente.getCidade());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					cliente.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente.getId();
	}
	public void atualizar(Cliente cliente) {
		String sqlUpdate = "UPDATE cliente.cliente SET nome=?, email=?, senha=? , cidade=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getEmail());
			stm.setString(3, cliente.getSenha());
			stm.setString(4, cliente.getCidade());
			stm.setInt(5, cliente.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM cliente.cliente WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Cliente carregar(int id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		String sqlSelect = "SELECT nome, email, senha, cidade FROM cliente.cliente WHERE id =?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, cliente.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					cliente.setNome(rs.getString("nome"));
					cliente.setEmail(rs.getString("email"));
					cliente.setSenha(rs.getString("senha"));
					cliente.setCidade(rs.getString("cidade"));

				} else {
					cliente.setId(-1);
					cliente.setNome(null);
					cliente.setEmail(null);
					cliente.setSenha(null);
					cliente.setCidade(null);
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
