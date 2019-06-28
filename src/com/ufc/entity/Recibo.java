package com.ufc.entity;

public class Recibo {
	private Integer atendId;
	private String funcNome;
	private String cliNome;
	private Float valTotal;
	
	public Recibo(Integer atendId, String funcNome, String cliNome, Float valTotal) {
		super();
		this.atendId = atendId;
		this.funcNome = funcNome;
		this.cliNome = cliNome;
		this.valTotal = valTotal;
	}
	
	public Recibo () {}

	public Integer getAtendId() {
		return atendId;
	}

	public void setAtendId(Integer atendId) {
		this.atendId = atendId;
	}

	public String getFuncNome() {
		return funcNome;
	}

	public void setFuncNome(String funcNome) {
		this.funcNome = funcNome;
	}

	public String getCliNome() {
		return cliNome;
	}

	public void setCliNome(String cliNome) {
		this.cliNome = cliNome;
	}

	public Float getValTotal() {
		return valTotal;
	}

	public void setValTotal(Float valTotal) {
		this.valTotal = valTotal;
	}
}
	
