package com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.entity.Atendimento;

public class AtendimentoDAO{
	private Connection connection;
	private Connection_Postgres connection_Postgres;
	
	public AtendimentoDAO(Connection_Postgres connection_Postgres) {
		this.connection_Postgres = connection_Postgres;
	}	
	
	public boolean create(Atendimento atend) {
		String sql = "INSERT INTO Atendimentos (id, cpfCli, cpfFunc, timeBeg,"
				+ "timeEnd, preco, idServ, idMaq) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, atend.getId());
			stmt.setString(2, atend.getCpfCli());
			stmt.setString(3, atend.getCpfFunc());
			stmt.setTimestamp(4, atend.getTimeBeg());
			stmt.setTimestamp(5, atend.getTimeEnd());
			stmt.setFloat(6, atend.getPreco());
			stmt.setInt(7, atend.getIdServ());
			stmt.setInt(8, atend.getIdMaq());
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("ERROR AtendimentoDao: " + e);
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public Atendimento read(String cpf) {
		String sql = "SELECT * FROM atendimentos where cpf = ?";
		Atendimento atend = null;
				
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				atend = new Atendimento();
				atend.setId(rs.getInt("Id"));
				atend.setCpfCli(rs.getString("cpf_cli"));
				atend.setCpfFunc(rs.getString("cpf_func"));
				atend.setTimeBeg(rs.getTimestamp("timestamp_ini"));
				atend.setTimeBeg(rs.getTimestamp("timestamp_fim"));
				atend.setIdServ(rs.getInt("id_serv"));
				atend.setIdServ(rs.getInt("id_maq"));
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
		return atend;
	}

	public boolean update(Atendimento atend) {
		String sql = "UPDATE atendimentos SET cpf = ?, nome = ?, telefone_residencial = ?,"
				+ "telefone_comercial = ?, logradouro = ?, cep = ?, numero = ?, bairro = ?"
				+ "WHERE cpf = ?";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, atend.getId());
			stmt.setString(2, atend.getCpfCli());
			stmt.setString(3, atend.getCpfFunc());
			stmt.setTimestamp(4, atend.getTimeBeg());
			stmt.setTimestamp(5, atend.getTimeEnd());
			stmt.setFloat(6, atend.getPreco());
			stmt.setInt(7, atend.getIdServ());
			stmt.setInt(8, atend.getIdMaq());			
				
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
		String sql = "DELETE FROM atendimentos WHERE cpf = ?";
		
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
			System.out.println("Erro AtendimentoDAO: " + e);
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Atendimento> getAtendimentosList() {
		String sql = "SELECT * FROM atendimentos;";
		ArrayList<Atendimento> atendimentoList = new ArrayList<Atendimento>();
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Atendimento atend = new Atendimento();
				atend = new Atendimento();
				atend.setId(rs.getInt("Id"));
				atend.setCpfCli(rs.getString("cpf_cli"));
				atend.setCpfFunc(rs.getString("cpf_func"));
				atend.setTimeBeg(rs.getTimestamp("timestamp_ini"));
				atend.setTimeBeg(rs.getTimestamp("timestamp_fim"));
				atend.setIdServ(rs.getInt("id_serv"));
				atend.setIdServ(rs.getInt("id_maq"));
				
				atendimentoList.add(atend);
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
		return atendimentoList;
	}
}