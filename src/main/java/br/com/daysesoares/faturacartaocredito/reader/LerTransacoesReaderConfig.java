package br.com.daysesoares.faturacartaocredito.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import br.com.daysesoares.faturacartaocredito.dominio.CartaoCredito;
import br.com.daysesoares.faturacartaocredito.dominio.Cliente;
import br.com.daysesoares.faturacartaocredito.dominio.Transacao;

@Configuration
public class LerTransacoesReaderConfig {

	@Bean
	public JdbcCursorItemReader<Transacao> lerTransacoesReader(
			@Qualifier("appDataSource") DataSource dataSource){
		
		return new JdbcCursorItemReaderBuilder<Transacao>()
				.name("lerTransacoesReader")
				.dataSource(dataSource)
				.sql("selet * transacao "
						+ "join cartao_credito using (numero_cartao_credito) "
						+ "order by numero_cartao_credito ")
				.rowMapper(rowMapperTransacao())
				.build();
		
	}

	private RowMapper<Transacao> rowMapperTransacao() {
		return new RowMapper<Transacao>() {
			
			@Override
			public Transacao mapRow(ResultSet rs, int rowNum) throws SQLException{				
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("cliente"));
				
				CartaoCredito cartaoCredito = new CartaoCredito();
				cartaoCredito.setNumeroCartaoCredito(rs.getInt("numero_cartao_credito"));
				cartaoCredito.setCliente(cliente);
				
				Transacao transacao = new Transacao();
				transacao.setId(rs.getInt("id"));
				transacao.setCartaoCredito(cartaoCredito);
				transacao.setData(rs.getDate("data"));
				transacao.setValor(rs.getDouble("valor"));
				transacao.setDescricao(rs.getString("descricao"));
				
				return transacao;
			}
			
		};
	}
	
}
