package model;

public class Pedido {
	private int numeroMesa, numeroPedido, prioridade, quantidade; 
	private double valorTotal;
	private String garcom, cpf, dataHora, status;
	
	
	public Pedido() {
		super();
	}

	public Pedido(int numeroMesa, int numeroPedido, String status, int prioridade, int quantidade, double valorTotal,
			String garcom, String cpf, String dataHora) {
		super();
		this.numeroMesa = numeroMesa;
		this.numeroPedido = numeroPedido;
		this.status = status;
		this.prioridade = prioridade;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
		this.garcom = garcom;
		this.cpf = cpf;
		this.dataHora = dataHora;
	}

	public int getNumeroMesa() {
		return numeroMesa;
	}



	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}



	public int getNumeroPedido() {
		return numeroPedido;
	}



	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getPrioridade() {
		return prioridade;
	}



	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}



	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	public double getValorTotal() {
		return valorTotal;
	}



	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}



	public String getGarcom() {
		return garcom;
	}



	public void setGarcom(String garcom) {
		this.garcom = garcom;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getDataHora() {
		return dataHora;
	}



	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	
	
	
	
	
	
}
