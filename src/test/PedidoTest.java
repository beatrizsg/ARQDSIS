package test;
import static org.junit.Assert.*;

import org.junit.Test;
import model.Pedido;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import service.PedidoService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PedidoTest {

	Pedido pedido, copia;
	PedidoService pedidoService;
	static int id = 1;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pedido = new Pedido();
		pedido.setCpf("123456");
		pedido.setDataHora("1111");
		pedido.setGarcom("Beatriz");
		pedido.setNumeroMesa(10);
		pedido.setPrioridade(1);
		pedido.setQuantidade(1);
		pedido.setStatus("fazendo");
		pedido.setValorTotal(100);
		copia = new Pedido();
		copia = new Pedido();
		copia.setCpf("123456");
		copia.setDataHora("1111");
		copia.setGarcom("Beatriz");
		copia.setNumeroMesa(10);
		copia.setPrioridade(1);
		copia.setQuantidade(1);
		copia.setStatus("fazendo");
		copia.setValorTotal(100);
		pedidoService = new PedidoService();
		System.out.println(pedido);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Pedido fixture = new Pedido();	
		fixture.setCpf("123456");
		fixture.setDataHora("1111");
		fixture.setGarcom("Beatriz");
		fixture.setNumeroMesa(10);
		fixture.setPrioridade(1);
		fixture.setQuantidade(1);
		fixture.setStatus("fazendo");
		fixture.setValorTotal(100);
		
		PedidoService novoService = new PedidoService();
		Pedido novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		pedidoService.criar(pedido);
		System.out.println(id);
		assertEquals("testa criacao", pedido, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pedido.setGarcom("Renan");
		copia.setGarcom("Renan");		
		pedidoService.atualizar(pedido);
		pedido = pedidoService.carregar(1);
		assertEquals("testa atualizacao", pedido, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setCpf("654121");
		copia.setDataHora("2222");
		copia.setGarcom("Aline");
		copia.setNumeroMesa(20);
		copia.setPrioridade(2);
		copia.setQuantidade(2);
		copia.setStatus("pronto");
		copia.setValorTotal(200);
		pedidoService.excluir(id);
		pedido = pedidoService.carregar(id);
		assertEquals("testa exclusao", pedido, copia);
	}

}
