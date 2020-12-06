package com.jas.arquivomultiplosformatos.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MultiplosArquivosClienteTransacaoReaderConfig {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @StepScope
    @Bean
    public MultiResourceItemReader MultiplosArquivosClienteTransacaoReader(
            @Value("#{jobParameters['arquivosClientes']}") Resource[] arquivosClientes,
            FlatFileItemReader leituraArquivoMultiplosFormatosReader) {
        return new MultiResourceItemReaderBuilder<>()
                .name("MultiplosArquivosClienteTransacaoReader")
                .resources(arquivosClientes)
                .delegate(new ArquivoClienteTrasacaoReader(leituraArquivoMultiplosFormatosReader))
                .build();
    }
}
