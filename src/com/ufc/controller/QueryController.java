package com.ufc.controller;

import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.dao.QueryDAO;
import com.ufc.entity.AvaCliByAtend;
import com.ufc.entity.CliAtendOrderByBairro;
import com.ufc.entity.CountCliAtendByBairro;
import com.ufc.entity.MaxAvaByServ;
import com.ufc.entity.Recibo;

public class QueryController {
	
	Connection_Postgres connection_Postgres = new Connection_Postgres();
	QueryDAO queryDao = new QueryDAO(connection_Postgres);

	public ArrayList<Recibo> getRecibos() {
		return queryDao.getReciboList();
	}
	
	public ArrayList<AvaCliByAtend> getListAvaCliByAtend() {
		return queryDao.getListAvaCliByAtend();
	}
	
	public ArrayList<CliAtendOrderByBairro> getListCliAtendOrderByBairro() {
		return queryDao.getListCliAtendOrderByBairro();
	}

	public ArrayList<CountCliAtendByBairro> getCountCliAtendByBairro() {
		return queryDao.getCountCliAtendByBairro();
	}
	
	public ArrayList<MaxAvaByServ> getMaxAvaByServList() {
		return queryDao.getMaxAvaByServList();
	}
	
}
