package com.ufc.entity;

import java.sql.Timestamp;

public class Atendimento {
	
	private Integer id;
	private String cpfCli;
	private String cpfFunc;
	private Timestamp timeBeg;
	private Timestamp timeEnd;
	private Integer idServ;
	private Integer idMaq;
	
	public Atendimento(Integer id, String cpfCli, String cpfFunc,
			Timestamp timeBeg, Timestamp timeEnd, float preco, Integer idServ,
			Integer idMaq) {
		super();
		this.id = id;
		this.cpfCli = cpfCli;
		this.cpfFunc = cpfFunc;
		this.timeBeg = timeBeg;
		this.timeEnd = timeEnd;
		this.idServ = idServ;
		this.idMaq = idMaq;
	}
	
	public Atendimento() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpfCli() {
		return cpfCli;
	}

	public void setCpfCli(String cpfCli) {
		this.cpfCli = cpfCli;
	}

	public String getCpfFunc() {
		return cpfFunc;
	}

	public void setCpfFunc(String cpfFunc) {
		this.cpfFunc = cpfFunc;
	}

	public Timestamp getTimeBeg() {
		return timeBeg;
	}

	public void setTimeBeg(Timestamp timeBeg) {
		this.timeBeg = timeBeg;
	}

	public Timestamp getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Timestamp timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Integer getIdServ() {
		return idServ;
	}

	public void setIdServ(Integer idServ) {
		this.idServ = idServ;
	}

	public Integer getIdMaq() {
		return idMaq;
	}

	public void setIdMaq(Integer idMaq) {
		this.idMaq = idMaq;
	}	
}