package br.com.daysesoares.faturacartaocredito.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import br.com.daysesoares.faturacartaocredito.dominio.FaturaCartaoCredito;

@Component
public class CarregarDadosClienteProcessor implements ItemProcessor<FaturaCartaoCredito, FaturaCartaoCredito> {

	//private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public FaturaCartaoCredito process(FaturaCartaoCredito faturaCartaoCredito) throws Exception {
		//String url = String.format("http://my-json-server.typicode.com/giuliana-bezerra/demo/profile/%d", faturaCartaoCredito.getCartaoCredito().getCliente());
//		ResponseEntity<Cliente> response = restTemplate.getForEntity(url, Cliente.class);
//		
//		if(response.getStatusCode() != HttpStatus.OK) {
//			throw new ValidationException("cliente não encontrado.");
//		}
//		
//		faturaCartaoCredito.setCliente(response.getBody());
		return faturaCartaoCredito;
	}

}
