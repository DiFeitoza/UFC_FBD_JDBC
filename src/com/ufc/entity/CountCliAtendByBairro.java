package com.ufc.entity;

public class CountCliAtendByBairro {
	
	private String bairro;
	private String count;
	
	public CountCliAtendByBairro(String bairro, String count) {
		super();
		this.bairro = bairro;
		this.count = count;
	}
	
	public CountCliAtendByBairro() {}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

}