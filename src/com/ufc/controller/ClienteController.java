package com.ufc.controller;

import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.dao.ClienteDAO;
import com.ufc.entity.Cliente;

public class ClienteController {
	Connection_Postgres connection_Postgres = new Connection_Postgres();
	ClienteDAO clienteDao = new ClienteDAO(connection_Postgres);

	public boolean addCliente(String cpf, String nome, long tel_residencial, long tel_comercial, String logradouro, long cep,
			long num_endereco, String bairro) {
		if (!cpf.matches("^[0-9]{11}") || nome.equals("") || tel_residencial <= 0 || tel_comercial <= 0 ||
				logradouro.equals("") || num_endereco <= 0 || bairro.equals("")) {
			return false;
		} else if (!nome.matches("[a-zA-Z �?ÂÃÀÇÉÊ�?ÓÔÕÚÜáâãàçéêíóôõúü]*") ||
				!logradouro.matches("[a-zA-Z �?ÂÃÀÇÉÊ�?ÓÔÕÚÜáâãàçéêíóôõúü]*") ||
				!bairro.matches("[a-zA-Z �?ÂÃÀÇÉÊ�?ÓÔÕÚÜáâãàçéêíóôõúü]*")) {
			System.out.println("Nome so pode conter letras");
			return false;
		}
		
		Cliente cli = new Cliente();
		
		cli.setCpf(cpf);
		cli.setNome(nome);
		cli.setTel_residencial(tel_residencial);
		cli.setTel_comercial(tel_comercial);
		cli.setLogradouro(logradouro);
		cli.setCep(cep);
		cli.setNum_endereco(num_endereco);
		cli.setBairro(bairro);
		
		return clienteDao.create(cli);
	}

	public Cliente searchClienteByCpf(String cpf) {
		return clienteDao.read(cpf);
	}
	
	public boolean delCliente(String cpf) {
		return clienteDao.delete(cpf);	
	}
	
	public ArrayList<Cliente> getClientesList() {
		return clienteDao.getClientesList();
	}	
}
