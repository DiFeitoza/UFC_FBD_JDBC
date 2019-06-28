package com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.entity.Cliente;

public class ClienteDAO{
	private Connection connection;
	private Connection_Postgres connection_Postgres;
	
	public ClienteDAO(Connection_Postgres connection_Postgres) {
		this.connection_Postgres = connection_Postgres;
	}	
	
	public boolean create(Cliente cli) {
		String sql = "INSERT INTO Clientes (cpf, nome, telefone_residencial, telefone_comercial,"
				+ "logradouro, CEP, numero, bairro) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cli.getCpf());
			stmt.setString(2, cli.getNome());
			stmt.setLong(3, cli.getTel_residencial());
			stmt.setLong(4, cli.getTel_comercial());
			stmt.setString(5, cli.getLogradouro());
			stmt.setLong(6, cli.getCep());
			stmt.setLong(7, cli.getNum_endereco());
			stmt.setString(8, cli.getBairro());
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("ERROR ClienteDao: " + e);
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public Cliente read(String cpf) {
		String sql = "SELECT * FROM clientes where cpf = ?";
		Cliente cli = null;
				
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				cli = new Cliente();
				cli.setCpf(rs.getString("cpf"));
				cli.setNome(rs.getString("nome"));
				cli.setTel_residencial(rs.getLong("telefone_residencial"));
				cli.setTel_comercial(rs.getLong("telefone_comercial"));
				cli.setLogradouro(rs.getString("logradouro"));
				cli.setCep(rs.getLong("CEP"));
				cli.setNum_endereco(rs.getLong("numero"));
				cli.setBairro(rs.getString("bairro"));
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
		return cli;
	}

	public boolean update(Cliente cli) {
		String sql = "UPDATE clientes SET cpf = ?, nome = ?, telefone_residencial = ?,"
				+ "telefone_comercial = ?, logradouro = ?, cep = ?, numero = ?, bairro = ?"
				+ "WHERE cpf = ?";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cli.getCpf());
			stmt.setString(2, cli.getNome());
			stmt.setLong(3, cli.getTel_residencial());
			stmt.setLong(4, cli.getTel_comercial());
			stmt.setString(5, cli.getLogradouro());
			stmt.setLong(6, cli.getCep());
			stmt.setLong(7, cli.getNum_endereco());
			stmt.setString(8, cli.getBairro());
			stmt.setString(9, cli.getCpf());
				
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
		String sql = "DELETE FROM clientes WHERE cpf = ?";
		
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
			System.out.println("Erro ClienteDAO: " + e);
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Cliente> getClienteList() {
		String sql = "SELECT * FROM clientes;";
		ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Cliente cli = new Cliente();
					cli = new Cliente();
					cli.setCpf(rs.getString("cpf"));
					cli.setNome(rs.getString("nome"));
					cli.setTel_residencial(rs.getLong("telefone_residencial"));
					cli.setTel_comercial(rs.getLong("telefone_comercial"));
					cli.setLogradouro(rs.getString("logradouro"));
					cli.setCep(rs.getLong("CEP"));
					cli.setNum_endereco(rs.getLong("numero"));
					cli.setBairro(rs.getString("bairro"));
				clienteList.add(cli);
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
		return clienteList;
	}
}