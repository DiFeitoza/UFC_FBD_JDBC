package com.ufc.controller;

import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.dao.ProdutoDAO;
import com.ufc.entity.Produto;

public class ProdutoController {
	Connection_Postgres connection_Postgres = new Connection_Postgres();
	ProdutoDAO produtoDao = new ProdutoDAO(connection_Postgres);

	public boolean addProduto(Integer id, String nome, Integer qtd) {
		if (nome.equals("") || id <= 0 || qtd <= 0) {
			return false;
		} else if (!nome.matches("[a-zA-Z �?ÂÃÀÇÉÊ�?ÓÔÕÚÜáâãàçéêíóôõúü]*")){
			System.out.println("Nome so pode conter letras");
			return false;
		}
		
		Produto prod = new Produto();
		
		prod.setId(id);
		prod.setNome(nome);
		
		prod.setQtd(qtd);
		
		return produtoDao.create(prod);
	}

	public Produto searchProdutoById(Integer id) {
		return produtoDao.read(id);
	}
	
	public boolean delProduto(Integer id) {
		return produtoDao.delete(id);	
	}
	
	public ArrayList<Produto> getProdutosList() {
		return produtoDao.getProdutosList();
	}	
}
