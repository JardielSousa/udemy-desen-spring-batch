package com.jas.arquivomultiplosformatos.reader;

import com.jas.arquivomultiplosformatos.dominio.Cliente;
import com.jas.arquivomultiplosformatos.dominio.Transacao;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

public class ArquivoClienteTrasacaoReader implements ItemStreamReader<Cliente> {

    private Object objAtual;

    private ItemStreamReader<Object> delegate;

    public ArquivoClienteTrasacaoReader(ItemStreamReader<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Cliente read() throws Exception {
        if (objAtual == null) {
            objAtual = delegate.read();
        }
        Cliente cliente = (Cliente) objAtual;
        objAtual = null;

        if (cliente != null) {
            while (peek() instanceof Transacao) {
                cliente.getTransacoes().add((Transacao) objAtual);
            }
        }

        return cliente;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }

    private Object peek() throws Exception {
        objAtual = delegate.read();
        return objAtual;
    }
}
