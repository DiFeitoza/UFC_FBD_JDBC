package com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.entity.Funcionario;

public class FuncionarioDAO{
	private Connection connection;
	private Connection_Postgres connection_Postgres;
	
	public FuncionarioDAO(Connection_Postgres connection_Postgres) {
		this.connection_Postgres = connection_Postgres;
	}	
	
	public boolean create(Funcionario func) {
		String sql = "INSERT INTO Funcionarios (cpf, nome, telefone_residencial, telefone_comercial,"
				+ "logradouro, CEP, numero, bairro, salario) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, func.getCpf());
			stmt.setString(2, func.getNome());
			stmt.setLong(3, func.getTel_residencial());
			stmt.setLong(4, func.getTel_comercial());
			stmt.setString(5, func.getLogradouro());
			stmt.setLong(6, func.getCep());
			stmt.setLong(7, func.getNum_endereco());
			stmt.setString(8, func.getBairro());
			stmt.setFloat(9, func.getSalario());
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("ERROR FuncionarioDao: " + e);
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public Funcionario read(String cpf) {
		String sql = "SELECT * FROM funcionarios where cpf = ?";
		Funcionario func = null;
				
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				func = new Funcionario();
				func.setCpf(rs.getString("cpf"));
				func.setNome(rs.getString("nome"));
				func.setTel_residencial(rs.getLong("telefone_residencial"));
				func.setTel_comercial(rs.getLong("telefone_comercial"));
				func.setLogradouro(rs.getString("logradouro"));
				func.setCep(rs.getLong("CEP"));
				func.setNum_endereco(rs.getLong("numero"));
				func.setBairro(rs.getString("bairro"));
				func.setSalario(rs.getFloat("salario"));
			}
			stmt.close();			
		} catch (SQLException e) {
			System.out.println("");
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return func;
	}

	public boolean update(Funcionario func) {
		String sql = "UPDATE funcionarios SET cpf = ?, nome = ?, telefone_residencial = ?,"
				+ "telefone_comercial = ?, logradouro = ?, cep = ?, numero = ?, bairro = ?"
				+ "WHERE cpf = ?";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, func.getCpf());
			stmt.setString(2, func.getNome());
			stmt.setLong(3, func.getTel_residencial());
			stmt.setLong(4, func.getTel_comercial());
			stmt.setString(5, func.getLogradouro());
			stmt.setLong(6, func.getCep());
			stmt.setLong(7, func.getNum_endereco());
			stmt.setString(8, func.getBairro());
			stmt.setFloat(9, func.getSalario());
				
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) return true;
			return false;
		} catch (SQLException e) {
			System.out.println("");
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean delete(String cpf) {
		String sql = "DELETE FROM funcionarios WHERE cpf = ?";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpf);

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("Erro FuncionarioDAO: " + e);
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Funcionario> getFuncionarioList() {
		String sql = "SELECT * FROM funcionarios;";
		ArrayList<Funcionario> funcionarioList = new ArrayList<Funcionario>();
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Funcionario func = new Funcionario();
					func = new Funcionario();
					func.setCpf(rs.getString("cpf"));
					func.setNome(rs.getString("nome"));
					func.setTel_residencial(rs.getLong("telefone_residencial"));
					func.setTel_comercial(rs.getLong("telefone_comercial"));
					func.setLogradouro(rs.getString("logradouro"));
					func.setCep(rs.getLong("CEP"));
					func.setNum_endereco(rs.getLong("numero"));
					func.setBairro(rs.getString("bairro"));
					func.setSalario(rs.getFloat("salario"));
				funcionarioList.add(func);
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("");
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return funcionarioList;
	}
	
}