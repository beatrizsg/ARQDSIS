package service;

import model.Pedido;
import dao.PedidoDAO;

public class PedidoService {
	PedidoDAO dao = new PedidoDAO();

	public void criar(Pedido pedido) {
		dao.criar(pedido);
	}

	public void atualizar(Pedido pedido){
		dao.atualizar(pedido);
	}

	public void excluir(int id){
		dao.excluir(id);
	}

	public Pedido carregar(int id){
		return dao.carregar(id);
	}
}
