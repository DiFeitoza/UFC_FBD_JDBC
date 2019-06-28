package com.ufc.entity;


public class Funcionario {
	
	private String cpf;
	private String nome;
	private long tel_residencial;
	private long tel_comercial;
	private String logradouro;
	private long cep;
	private long num_endereco;
	private String bairro;
	private Float salario;
	
	public Funcionario(String cpf, String nome, long tel_residencial, long tel_comercial, String logradouro, long cep,
			long num_endereco, String bairro, Float salario) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.tel_residencial = tel_residencial;
		this.tel_comercial = tel_comercial;
		this.logradouro = logradouro;
		this.cep = cep;
		this.num_endereco = num_endereco;
		this.bairro = bairro;
		this.salario = salario;
	}

	public Funcionario () {}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getTel_residencial() {
		return tel_residencial;
	}
	public void setTel_residencial(long tel_residencial) {
		this.tel_residencial = tel_residencial;
	}
	public long getTel_comercial() {
		return tel_comercial;
	}
	public void setTel_comercial(long tel_comercial) {
		this.tel_comercial = tel_comercial;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public long getCep() {
		return cep;
	}
	public void setCep(long cep) {
		this.cep = cep;
	}
	public long getNum_endereco() {
		return num_endereco;
	}
	public void setNum_endereco(long num_endereco) {
		this.num_endereco = num_endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Float getSalario() {
		return salario;
	}
	public void setSalario(Float salario) {
		this.salario = salario;
	}
	
}