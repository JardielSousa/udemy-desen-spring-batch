package com.jas.arquivodelimitadojob.step;

import com.jas.arquivodelimitadojob.dominio.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class LeituraArquivoDelimitadoStepConfig {

	public final StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step leituraArquivoDelimitadoStep(ItemReader<Cliente> leituraArquivoDelimitadoReader,
			ItemWriter<Cliente> leituraArquivoDelimitadoWriter) {
		return stepBuilderFactory
				.get("leituraArquivoDelimitadoStep")
				.<Cliente, Cliente>chunk(1)
				.reader(leituraArquivoDelimitadoReader)
				.writer(leituraArquivoDelimitadoWriter)
				.build();
	}
}
