package com.ufc.entity;

public class CliAtendOrderByBairro {
	
	private String bairro;
	private String cpf;
	private String nomeCli;
	
	public CliAtendOrderByBairro(String bairro, String cpf, String nomeCli) {
		super();
		this.bairro = bairro;
		this.cpf = cpf;
		this.nomeCli = nomeCli;
	}
	
	public CliAtendOrderByBairro() {}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCli() {
		return nomeCli;
	}

	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}

}