package com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.entity.Maquina;

public class MaquinaDAO{
	private Connection connection;
	private Connection_Postgres connection_Postgres;
	
	public MaquinaDAO(Connection_Postgres connection_Postgres) {
		this.connection_Postgres = connection_Postgres;
	}	
	
	public boolean create(Maquina maq) {
		String sql = "INSERT INTO Maquinas (id, nome, status) VALUES(?, ?, ?)";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, maq.getId());
			stmt.setString(2, maq.getNome());
			stmt.setBoolean(3, maq.isStatus());
			
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
	
	public Maquina read(Integer id) {
		String sql = "SELECT * FROM maquinas where id = ?";
		Maquina maq = null;
				
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				maq = new Maquina();
				maq.setId(rs.getInt("id"));
				maq.setNome(rs.getString("nome"));
				maq.setStatus(rs.getBoolean("status"));
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
		return maq;
	}

	public boolean update(Maquina maq) {
		String sql = "UPDATE maquinas SET id = ?, nome = ?, status = ?,";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, maq.getId());
			stmt.setString(2, maq.getNome());
			stmt.setBoolean(3, maq.isStatus());			
				
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
		String sql = "DELETE FROM maquinas WHERE id = ?";
		
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
			System.out.println("Erro MaquinaDAO: " + e);
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Maquina> getMaquinaList() {
		String sql = "SELECT * FROM maquinas;";
		ArrayList<Maquina> maquinaList = new ArrayList<Maquina>();
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			Maquina maq = new Maquina();
			
			while (rs.next()) {
				maq = new Maquina();
				maq.setId(rs.getInt("id"));
				maq.setNome(rs.getString("nome"));
				maq.setStatus(rs.getBoolean("status"));
				maquinaList.add(maq);
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
		return maquinaList;
	}
}