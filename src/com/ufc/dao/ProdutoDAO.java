package com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.entity.Produto;

public class ProdutoDAO{
	private Connection connection;
	private Connection_Postgres connection_Postgres;
	
	public ProdutoDAO(Connection_Postgres connection_Postgres) {
		this.connection_Postgres = connection_Postgres;
	}	
	
	public boolean create(Produto prod) {
		String sql = "INSERT INTO Produtos (id, nome, qtd) VALUES(?, ?, ?)";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, prod.getId());
			stmt.setString(2, prod.getNome());
			stmt.setFloat(3, prod.getQtd());
			
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
	
	public Produto read(Integer id) {
		String sql = "SELECT * FROM produtos where id = ?";
		Produto prod = null;
				
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				prod = new Produto();
				prod.setId(rs.getInt("id"));
				prod.setNome(rs.getString("nome"));
				prod.setQtd(rs.getInt("qtd"));
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
		return prod;
	}

	public boolean update(Produto prod) {
		String sql = "UPDATE produtos SET id = ?, cpf = ?, qtd = ? WHERE cpf = ?";
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, prod.getId());
			stmt.setString(2, prod.getNome());
			stmt.setInt(3, prod.getQtd());
			stmt.setInt(4, prod.getId());
				
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
		String sql = "DELETE FROM produtos WHERE id = ?";
		
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
			System.out.println("Erro ProdutoDAO: " + e);
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Produto> getProdutoList() {
		String sql = "SELECT * FROM produtos";
		ArrayList<Produto> produtoList = new ArrayList<Produto>();
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			Produto prod = new Produto();
			
			while (rs.next()) {
				prod = new Produto();
				prod.setId(rs.getInt("id"));
				prod.setNome(rs.getString("nome"));
				prod.setQtd(rs.getInt("qtd"));
				produtoList.add(prod);
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
		return produtoList;
	}
	
	public ArrayList<Produto> getReposicaoProdutos() {
		String sql = "SELECT * FROM ReposicaoProdutos";
		ArrayList<Produto> produtoList = new ArrayList<Produto>();
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			Produto prod = new Produto();
			
			while (rs.next()) {
				prod = new Produto();
				prod.setId(rs.getInt("id"));
				prod.setNome(rs.getString("nome"));
				prod.setQtd(rs.getInt("qtd"));
				produtoList.add(prod);
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
		return produtoList;
	}
}