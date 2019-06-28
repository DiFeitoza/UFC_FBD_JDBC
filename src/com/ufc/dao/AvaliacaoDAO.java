package com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.entity.Avaliacao;

public class AvaliacaoDAO{
	private Connection connection;
	private Connection_Postgres connection_Postgres;
	
	public AvaliacaoDAO(Connection_Postgres connection_Postgres) {
		this.connection_Postgres = connection_Postgres;
	}	
	
	public boolean create(Avaliacao ava) {
		String sql = "INSERT INTO Avaliacoes (id, idAtend, coment, notaFunc,"
				+ "notaServ, notaMaq) VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, ava.getId());
			stmt.setInt(2, ava.getIdAtend());
			stmt.setString(3, ava.getComent());
			stmt.setInt(4, ava.getNotaFunc());
			stmt.setInt(5, ava.getNotaServ());
			stmt.setInt(6, ava.getNotaMaq());
			
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
	
	public Avaliacao read(Integer id) {
		String sql = "SELECT * FROM avaliacoes where id = ?";
		Avaliacao ava = null;
				
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				ava = new Avaliacao();
				ava.setId(rs.getInt("id"));
				ava.setIdAtend(rs.getInt("id_atendimento"));
				ava.setComent(rs.getString("comentario"));
				ava.setNotaFunc(rs.getInt("nota_func"));
				ava.setNotaServ(rs.getInt("nota_ser"));
				ava.setNotaMaq(rs.getInt("nota_maq"));
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
		return ava;
	}

	public boolean update(Avaliacao ava) {
		String sql = "UPDATE avaliacoes SET id = ?, id_atendimento = ?,"
				+ "comentario = ?, nota_func = ?, nota_ser = ?, nota_maq = ?";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, ava.getId());
			stmt.setInt(2, ava.getIdAtend());
			stmt.setString(3, ava.getComent());
			stmt.setInt(4, ava.getNotaFunc());
			stmt.setInt(5, ava.getNotaServ());
			stmt.setInt(6, ava.getNotaMaq());	
				
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
		String sql = "DELETE FROM avaliacoes WHERE id = ?";
		
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
			System.out.println("Erro AvaliacaoDAO: " + e);
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Avaliacao> getAvaliacaoList() {
		String sql = "SELECT * FROM avaliacoes;";
		ArrayList<Avaliacao> avaliacaoList = new ArrayList<Avaliacao>();
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			Avaliacao ava = new Avaliacao();
			
			while (rs.next()) {
				ava = new Avaliacao();
				ava.setId(rs.getInt("id"));
				ava.setIdAtend(rs.getInt("id_atendimento"));
				ava.setComent(rs.getString("comentario"));
				ava.setNotaFunc(rs.getInt("nota_func"));
				ava.setNotaServ(rs.getInt("nota_ser"));
				ava.setNotaMaq(rs.getInt("nota_maq"));
				
				avaliacaoList.add(ava);
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
		return avaliacaoList;
	}
}