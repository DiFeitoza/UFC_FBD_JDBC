package com.ufc.entity;

public class AvaCliByAtend {
	
	private Integer id_atend;
	private String coment;
	private String nome_func;
	private Integer nota_func;
	private String nome_serv;
	private Integer nota_serv;
	private String nome_maq;
	private Integer nota_maq;
	
	public AvaCliByAtend(Integer id_atend, String coment, String nome_func, Integer nota_func, String nome_serv,
			Integer nota_serv, String nome_maq, Integer nota_maq) {
		super();
		this.id_atend = id_atend;
		this.coment = coment;
		this.nome_func = nome_func;
		this.nota_func = nota_func;
		this.nome_serv = nome_serv;
		this.nota_serv = nota_serv;
		this.nome_maq = nome_maq;
		this.nota_maq = nota_maq;
	}
	
	public AvaCliByAtend() {}

	public Integer getId_atend() {
		return id_atend;
	}

	public void setId_atend(Integer id_atend) {
		this.id_atend = id_atend;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public String getNome_func() {
		return nome_func;
	}

	public void setNome_func(String nome_func) {
		this.nome_func = nome_func;
	}

	public Integer getNota_func() {
		return nota_func;
	}

	public void setNota_func(Integer nota_func) {
		this.nota_func = nota_func;
	}

	public String getNome_serv() {
		return nome_serv;
	}

	public void setNome_serv(String nome_serv) {
		this.nome_serv = nome_serv;
	}

	public Integer getNota_serv() {
		return nota_serv;
	}

	public void setNota_serv(Integer nota_serv) {
		this.nota_serv = nota_serv;
	}

	public String getNome_maq() {
		return nome_maq;
	}

	public void setNome_maq(String nome_maq) {
		this.nome_maq = nome_maq;
	}

	public Integer getNota_maq() {
		return nota_maq;
	}

	public void setNota_maq(Integer nota_maq) {
		this.nota_maq = nota_maq;
	}

}