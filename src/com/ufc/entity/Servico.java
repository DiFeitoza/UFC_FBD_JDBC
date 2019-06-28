package com.ufc.entity;

public class Servico {
	
	private Integer id;
	private String nome;
	private boolean status;
	private float preco;
	
	public Servico(Integer id, String nome, boolean status, float preco) {
		this.id = id;
		this.nome = nome;
		this.status = status;
		this.preco = preco;
	}
	
	public Servico () {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}