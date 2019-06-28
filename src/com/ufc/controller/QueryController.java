package com.ufc.controller;

import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.dao.QueryDAO;
import com.ufc.entity.Recibo;

public class QueryController {
	
	Connection_Postgres connection_Postgres = new Connection_Postgres();
	QueryDAO queryDao = new QueryDAO(connection_Postgres);

	public ArrayList<Recibo> getRecibos() {
		return queryDao.getReciboList();
	}
	
}