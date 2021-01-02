package com.springbatch.skipexception.dominio;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Cliente {
	private String nome;
	private String sobrenome;
	private String idade;
	private String email;
}