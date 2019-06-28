package com.ufc.controller;

import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.dao.MaquinaDAO;
import com.ufc.entity.Maquina;

public class MaquinaController {
	Connection_Postgres connection_Postgres = new Connection_Postgres();
	MaquinaDAO maquinaDao = new MaquinaDAO(connection_Postgres);

	public boolean addMaquina(Integer id, String nome, boolean status, float preco) {
		if (nome.equals("") || id <= 0) {
			return false;
		} else if (!nome.matches("[a-zA-Z �?ÂÃÀÇÉÊ�?ÓÔÕÚÜáâãàçéêíóôõúü]*")){
			System.out.println("Nome so pode conter letras");
			return false;
		}
		
		Maquina maq = new Maquina();
		
		maq.setId(id);
		maq.setNome(nome);
		maq.setStatus(status);
		
		return maquinaDao.create(maq);
	}

	public Maquina searchMaquinaById(Integer id) {
		return maquinaDao.read(id);
	}
	
	public boolean delMaquina(Integer id) {
		return maquinaDao.delete(id);	
	}
	
	public ArrayList<Maquina> getMaquinasList() {
		return maquinaDao.getMaquinasList();
	}	
}
