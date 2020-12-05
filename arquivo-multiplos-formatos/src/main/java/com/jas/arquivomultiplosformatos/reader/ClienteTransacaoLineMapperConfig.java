package com.jas.arquivomultiplosformatos.reader;

import com.jas.arquivomultiplosformatos.dominio.Cliente;
import com.jas.arquivomultiplosformatos.dominio.Transacao;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ClienteTransacaoLineMapperConfig {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public PatternMatchingCompositeLineMapper lineMapper() {
        PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper();
        lineMapper.setTokenizers(tokenizers());
        lineMapper.setFieldSetMappers(fielSetMappers());

        return lineMapper;
    }

    private Map<String, LineTokenizer> tokenizers() {
        Map<String, LineTokenizer> tokenizers = new HashMap<>();
        tokenizers.put("0*", clienteLineTokenizer());
        tokenizers.put("1*", transacaoLineTokenizer());

        return tokenizers;
    }

    @SuppressWarnings("rawtypes")
    private Map<String, FieldSetMapper> fielSetMappers() {
        Map<String, FieldSetMapper> fieldSetMappers = new HashMap<>();
        fieldSetMappers.put("0*", fieldSetMapper(Cliente.class));
        fieldSetMappers.put("1*", fieldSetMapper(Transacao.class));

        return fieldSetMappers;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private FieldSetMapper fieldSetMapper(Class classe) {
        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper();
        fieldSetMapper.setTargetType(classe);

        return fieldSetMapper;
    }

    private LineTokenizer clienteLineTokenizer() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("nome", "sobrenome", "idade", "email");
        lineTokenizer.setIncludedFields(1, 2, 3, 4);

        return lineTokenizer;
    }

    private LineTokenizer transacaoLineTokenizer() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("id", "descricao", "valor");
        lineTokenizer.setIncludedFields(1, 2, 3);

        return lineTokenizer;
    }
}
