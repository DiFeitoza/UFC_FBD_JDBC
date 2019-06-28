package com.ufc.controller;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.dao.AtendimentoDAO;
import com.ufc.entity.Atendimento;

public class AtendimentoController {
	Connection_Postgres connection_Postgres = new Connection_Postgres();
	AtendimentoDAO atendimentoDao = new AtendimentoDAO(connection_Postgres);

	public boolean addAtendimento(Integer id, String cpfCli, String cpfFunc,
			Timestamp timeBeg, Timestamp timeEnd, float preco, Integer idServ,
			Integer idMaq) {
		if (!cpfCli.matches("^[0-9]{11}") || !cpfFunc.matches("^[0-9]{11}") ||
				preco <= 0 || idServ <= 0 || idMaq <= 0) {
			return false;
		}
		
		Atendimento atend = new Atendimento();
				
		atend.setId(id);
		atend.setCpfCli(cpfCli);
		atend.setCpfFunc(cpfFunc);
		atend.setTimeBeg(timeBeg);
		atend.setTimeBeg(timeEnd);
		atend.setIdServ(idServ);
		atend.setIdServ(idMaq);
		
		return atendimentoDao.create(atend);
	}

	public Atendimento searchAtendimentoById(Integer id) {
		return atendimentoDao.read(id);
	}
	
	public boolean delAtendimento(Integer id) {
		return atendimentoDao.delete(id);	
	}
	
	public ArrayList<Atendimento> getAtendimentosList() {
		return atendimentoDao.getAtendimentosList();
	}	
}
