package com.jas.arquivolargurafixajob.step;

import com.jas.arquivolargurafixajob.dominio.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class LeituraArquivoLarguraFixaStepConfig {

	public final StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step leituraArquivoLarguraFixaStep(ItemReader<Cliente> leituraArquivoLarguraFixaReader,
											  ItemWriter<Cliente> leituraArquivoLarguraFixaWriter) {
		return stepBuilderFactory
				.get("leituraArquivoLarguraFixaStep")
				.<Cliente, Cliente>chunk(1)
				.reader(leituraArquivoLarguraFixaReader)
				.writer(leituraArquivoLarguraFixaWriter)
				.build();
	}
}
