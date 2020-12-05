package com.jas.arquivomultiplosformatos.dominio;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@ToString
public class Cliente {
	private String nome;
	private String sobrenome;
	private String idade;
	private String email;
	private List<Transacao> transacoes = new ArrayList<>();
}
