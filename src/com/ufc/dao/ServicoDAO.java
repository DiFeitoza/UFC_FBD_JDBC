package com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.entity.Servico;

public class ServicoDAO{
	private Connection connection;
	private Connection_Postgres connection_Postgres;
	
	public ServicoDAO(Connection_Postgres connection_Postgres) {
		this.connection_Postgres = connection_Postgres;
	}	
	
	public boolean create(Servico serv) {
		String sql = "INSERT INTO Servicos (id, nome, status, preco) VALUES(?, ?, ?, ?)";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, serv.getId());
			stmt.setString(2, serv.getNome());
			stmt.setFloat(3, serv.getPreco());
			stmt.setBoolean(4, serv.isStatus());
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("ERROR :" + e);
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public Servico read(Integer id) {
		String sql = "SELECT * FROM servicos where id = ?";
		Servico serv = null;
				
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				serv = new Servico();
				serv.setId(rs.getInt("id"));
				serv.setNome(rs.getString("nome"));
				serv.setStatus(rs.getBoolean("status"));
				serv.setPreco(rs.getFloat("preco"));
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
		return serv;
	}

	public boolean update(Servico serv) {
		String sql = "UPDATE servicos SET id = ?, nome = ?, preco = ?,"
				+ "status = ? WHERE id = ?";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, serv.getId());
			stmt.setString(2, serv.getNome());
			stmt.setFloat(3, serv.getPreco());
			stmt.setBoolean(4, serv.isStatus());
			stmt.setInt(5, serv.getId());
				
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

	public boolean delete(Integer id) {
		String sql = "DELETE FROM servicos WHERE id = ?";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);

			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("Erro ServicoDAO: " + e);
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Servico> getServicoList() {
		String sql = "SELECT * FROM servicos;";
		ArrayList<Servico> servicoList = new ArrayList<Servico>();
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			Servico serv = new Servico();
			
			while (rs.next()) {
				serv = new Servico();
				serv.setId(rs.getInt("id"));
				serv.setNome(rs.getString("nome"));
				serv.setStatus(rs.getBoolean("status"));
				serv.setPreco(rs.getFloat("preco"));
				servicoList.add(serv);
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
		return servicoList;
	}
}