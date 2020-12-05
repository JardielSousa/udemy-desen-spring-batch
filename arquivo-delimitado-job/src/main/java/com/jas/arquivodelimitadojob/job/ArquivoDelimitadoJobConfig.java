package com.jas.arquivodelimitadojob.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@EnableBatchProcessing
@Configuration
public class ArquivoDelimitadoJobConfig {

	public final JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job arquivoDelimitadoJob(Step leituraArquivoDelimitadoStep) {
		return jobBuilderFactory
				.get("arquivoDelimitadoJob")
				.start(leituraArquivoDelimitadoStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
