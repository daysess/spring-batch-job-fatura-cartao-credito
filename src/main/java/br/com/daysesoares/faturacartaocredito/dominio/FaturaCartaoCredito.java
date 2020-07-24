package br.com.daysesoares.faturacartaocredito.dominio;

import java.util.ArrayList;
import java.util.List;

public class FaturaCartaoCredito {

	private Cliente cliente;
	private CartaoCredito cartaoCredito;
	private List<Transacao> transacoes = new ArrayList<>();
	
	public FaturaCartaoCredito() {
		
	}

	public FaturaCartaoCredito(Cliente cliente, CartaoCredito cartaoCredito, List<Transacao> transacoes) {
		super();
		this.cliente = cliente;
		this.cartaoCredito = cartaoCredito;
		this.transacoes = transacoes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public Double getTotal() {
		return transacoes
				.stream()
				.mapToDouble(Transacao::getValor)
				.reduce(0.0, Double::sum);
	}
	
	
	
}
