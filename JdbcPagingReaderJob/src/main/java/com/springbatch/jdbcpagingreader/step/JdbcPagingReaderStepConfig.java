package com.springbatch.jdbcpagingreader.step;

import com.springbatch.jdbcpagingreader.dominio.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class JdbcPagingReaderStepConfig {

	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step jdbcPagingReaderStep(ItemReader<Cliente> jdbcPagingReader, ItemWriter<Cliente> jdbcPagingWriter) {
		return stepBuilderFactory
				.get("jdbcPagingReaderStep")
				.<Cliente, Cliente>chunk(1)
				.reader(jdbcPagingReader)
				.writer(jdbcPagingWriter)
				.build();
	}
}
