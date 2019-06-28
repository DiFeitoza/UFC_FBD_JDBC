package com.ufc.controller;

import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.dao.AvaliacaoDAO;
import com.ufc.entity.Avaliacao;

public class AvaliacaoController {
	Connection_Postgres connection_Postgres = new Connection_Postgres();
	AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO(connection_Postgres);

	public boolean addAvaliacao(Integer id, Integer idAtend, String coment,
			Integer notaFunc, Integer notaServ, Integer notaMaq) {
		if (id < 0 || idAtend < 0) {
			System.out.println("id inválido, use números não negativos");
			return false;
		} else if (notaFunc < 0 || notaFunc > 10 || notaServ < 0 || notaServ > 10 ||
			notaMaq < 0 || notaMaq > 10) {
			System.out.println("A nota deve ser um valor natural de 0 a 10");
		}
		
		Avaliacao ava = new Avaliacao();
		
		ava.setId(id);
		ava.setIdAtend(idAtend);
		ava.setComent(coment);
		ava.setNotaFunc(notaFunc);
		ava.setNotaServ(notaServ);
		ava.setNotaMaq(notaMaq);
		
		return avaliacaoDao.create(ava);
	}

	public Avaliacao searchAvaliacaoById(Integer id) {
		return avaliacaoDao.read(id);
	}
	
	public boolean delAvaliacao(Integer id) {
		return avaliacaoDao.delete(id);	
	}
	
	public ArrayList<Avaliacao> getAvaliacaoList() {
		return avaliacaoDao.getAvaliacaoList();
	}	
}
