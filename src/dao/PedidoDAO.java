package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pedido;

public class PedidoDAO {

	public void criar(Pedido pedido) {
		String sqlInsert = "INSERT INTO PEDIDO(dataEntrada, numeroMesa, valorTotal, status, prioridade, garcom, cpf, quantidade) VALUES (?, ?, ?, ?, ?, ?, ?, ? )";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, pedido.getDataHora());
			stm.setInt(2, pedido.getNumeroMesa());
			stm.setDouble(3, pedido.getValorTotal());
			stm.setString(4, pedido.getStatus());
			stm.setInt(5, pedido.getPrioridade());
			stm.setString(6, pedido.getGarcom());
			stm.setString(7, pedido.getCpf());
			stm.setInt(8, pedido.getQuantidade());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Pedido pedido) {
		String sqlUpdate = "UPDATE PEDIDO SET dataEntrada=?, numeroMesa=?, numeroPedido=?, valorTotal=?, status=?, prioridade=?, garcom=?, cpf=?, quantidade=? WHERE numeroMesa=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, pedido.getDataHora());
			stm.setInt(2, pedido.getNumeroMesa());
			stm.setInt(3, pedido.getNumeroPedido());
			stm.setDouble(4, pedido.getValorTotal());
			stm.setString(5, pedido.getStatus());
			stm.setInt(6, pedido.getPrioridade());
			stm.setString(7, pedido.getGarcom());
			stm.setString(8, pedido.getCpf());
			stm.setInt(9, pedido.getQuantidade());
			stm.setInt(10, 1);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM pedido WHERE numeroMesa = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, 1);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Pedido carregar(int id) {
		Pedido pedido = new Pedido();
		String sqlSelect = "SELECT dataEntrada, numeroMesa, numeroPedido, valorTotal, status, prioridade, garcom, cpf, quantidade FROM pedido WHERE pedido.numeroPedido = 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					pedido.setDataHora(rs.getString("dataEntrada"));
					pedido.setNumeroMesa(rs.getInt("numeroMesa"));
					pedido.setNumeroPedido(rs.getInt("numeroPedido"));
					pedido.setValorTotal(rs.getDouble("valorTotal"));
					pedido.setStatus(rs.getString("status"));
					pedido.setPrioridade(rs.getInt("prioridade"));
					pedido.setGarcom(rs.getString("garcom"));
					pedido.setCpf(rs.getString("cpf"));
					pedido.setQuantidade(rs.getInt("quantidade"));


				} else {
					pedido.setDataHora(null);
					pedido.setNumeroMesa(0);
					pedido.setNumeroPedido(0);
					pedido.setValorTotal(0);
					pedido.setStatus(null);
					pedido.setPrioridade(0);
					pedido.setGarcom(null);
					pedido.setCpf(null);
					pedido.setQuantidade(0);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pedido;
	}

}
