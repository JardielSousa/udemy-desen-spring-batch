package com.springbatch.jdbccursorreader.step;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.jdbccursorreader.dominio.Cliente;

@RequiredArgsConstructor
@Configuration
public class JdbcCursorReaderStepConfig {

	public final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step jdbcCursorReaderStep(ItemReader<Cliente> jdbcCursorReader, ItemWriter<Cliente> jdbcCursorWriter) {
		return stepBuilderFactory
				.get("jdbcCursorReaderStep")
				.<Cliente, Cliente>chunk(1)
				.reader(jdbcCursorReader)
				.writer(jdbcCursorWriter)
				.build();
	}
}
