package com.springbatch.skipexception.job;

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
public class SkipExceptionJobConfig {

	private final JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job skipExceptionJob(Step skipExceptionStep) {
		return jobBuilderFactory
				.get("skipExceptionJob")
				.start(skipExceptionStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
