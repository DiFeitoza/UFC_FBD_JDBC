package com.ufc.controller;

import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.dao.FuncionarioDAO;
import com.ufc.entity.Funcionario;

public class FuncionarioController {
	Connection_Postgres connection_Postgres = new Connection_Postgres();
	FuncionarioDAO funcionarioDao = new FuncionarioDAO(connection_Postgres);

	public boolean addFuncionario(String cpf, String nome, long tel_residencial, long tel_comercial, String logradouro, long cep,
			long num_endereco, String bairro, float salario) {
		if (!cpf.matches("^[0-9]{11}") || nome.equals("") || tel_residencial <= 0 || tel_comercial <= 0 ||
				logradouro.equals("") || num_endereco <= 0 || bairro.equals("") || salario <= 0) {
			return false;
		} else if (!nome.matches("[a-zA-Z �?ÂÃÀÇÉÊ�?ÓÔÕÚÜáâãàçéêíóôõúü]*") ||
				!logradouro.matches("[a-zA-Z �?ÂÃÀÇÉÊ�?ÓÔÕÚÜáâãàçéêíóôõúü]*") ||
				!bairro.matches("[a-zA-Z �?ÂÃÀÇÉÊ�?ÓÔÕÚÜáâãàçéêíóôõúü]*")) {
			System.out.println("Nome so pode conter letras");
			return false;
		}
		
		Funcionario func = new Funcionario();
		
		func.setCpf(cpf);
		func.setNome(nome);
		func.setTel_residencial(tel_residencial);
		func.setTel_comercial(tel_comercial);
		func.setLogradouro(logradouro);
		func.setCep(cep);
		func.setNum_endereco(num_endereco);
		func.setBairro(bairro);
		func.setSalario(salario);
		
		return funcionarioDao.create(func);
	}

	public Funcionario searchFuncionarioByCpf(String cpf) {
		return funcionarioDao.read(cpf);
	}
	
	public boolean delFuncionario(String cpf) {
		return funcionarioDao.delete(cpf);	
	}
	
	public ArrayList<Funcionario> getFuncionarioList() {
		return funcionarioDao.getFuncionarioList();
	}	
}
