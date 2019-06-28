package com.ufc.controller;

import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.dao.ServicoDAO;
import com.ufc.entity.Servico;

public class ServicoController {
	Connection_Postgres connection_Postgres = new Connection_Postgres();
	ServicoDAO servicoDao = new ServicoDAO(connection_Postgres);

	public boolean addServico(Integer id, String nome, boolean status, float preco) {
		if (nome.equals("") || id <= 0 || preco <= 0) {
			return false;
		} else if (!nome.matches("[a-zA-Z �?ÂÃÀÇÉÊ�?ÓÔÕÚÜáâãàçéêíóôõúü]*")){
			System.out.println("Nome so pode conter letras");
			return false;
		}
		
		Servico serv = new Servico();
		
		serv.setId(id);
		serv.setNome(nome);
		serv.setStatus(status);
		serv.setPreco(preco);
		
		return servicoDao.create(serv);
	}

	public Servico searchServicoById(Integer id) {
		return servicoDao.read(id);
	}
	
	public boolean delServico(Integer id) {
		return servicoDao.delete(id);	
	}
	
	public ArrayList<Servico> getServicosList() {
		return servicoDao.getServicosList();
	}	
}
