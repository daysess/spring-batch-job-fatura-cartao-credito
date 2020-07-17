package br.com.daysesoares.faturacartaocredito.dominio;

public class CartaoCredito {

	private int numeroCartaoCredito;
	private Cliente cliente; 
	
	public CartaoCredito() {
		
	}

	public CartaoCredito(int numeroCartaoCredito, Cliente cliente) {
		super();
		this.numeroCartaoCredito = numeroCartaoCredito;
		this.cliente = cliente;
	}

	public int getNumeroCartaoCredito() {
		return numeroCartaoCredito;
	}

	public void setNumeroCartaoCredito(int numeroCartaoCredito) {
		this.numeroCartaoCredito = numeroCartaoCredito;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
