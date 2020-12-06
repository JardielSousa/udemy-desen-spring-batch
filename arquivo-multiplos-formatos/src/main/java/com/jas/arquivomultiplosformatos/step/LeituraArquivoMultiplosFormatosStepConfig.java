package com.jas.arquivomultiplosformatos.step;

import com.jas.arquivomultiplosformatos.dominio.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class LeituraArquivoMultiplosFormatosStepConfig {

	public final StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step leituraArquivoMultiplosFormatosStep(
			MultiResourceItemReader<Cliente> multiplosArquivosClienteTransacaoReader,
			ItemWriter<Cliente> leituraArquivoMultiplosFormatosItemWriter) {
		return stepBuilderFactory
				.get("leituraArquivoMultiplosFormatosStep")
				.<Object, Cliente>chunk(1)
				.reader(multiplosArquivosClienteTransacaoReader)
				.writer(leituraArquivoMultiplosFormatosItemWriter)
				.build();
	}
}
