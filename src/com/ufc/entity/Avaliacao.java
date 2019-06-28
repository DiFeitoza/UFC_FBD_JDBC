package com.ufc.entity;

public class Avaliacao {
	
	private Integer id;
	private Integer idAtend;
	private String coment;
	private Integer notaFunc;
	private Integer notaServ;
	private Integer notaMaq;
	
	public Avaliacao(Integer id, Integer idAtend, String coment, Integer notaFunc, Integer notaServ, Integer notaMaq) {
		super();
		this.id = id;
		this.idAtend = idAtend;
		this.coment = coment;
		this.notaFunc = notaFunc;
		this.notaServ = notaServ;
		this.notaMaq = notaMaq;
	}

	public Avaliacao () {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAtend() {
		return idAtend;
	}

	public void setIdAtend(Integer idAtend) {
		this.idAtend = idAtend;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public Integer getNotaFunc() {
		return notaFunc;
	}

	public void setNotaFunc(Integer notaFunc) {
		this.notaFunc = notaFunc;
	}

	public Integer getNotaServ() {
		return notaServ;
	}

	public void setNotaServ(Integer notaServ) {
		this.notaServ = notaServ;
	}

	public Integer getNotaMaq() {
		return notaMaq;
	}

	public void setNotaMaq(Integer notaMaq) {
		this.notaMaq = notaMaq;
	}

}