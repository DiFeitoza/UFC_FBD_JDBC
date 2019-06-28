package com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.entity.Recibo;

public class QueryDAO{
	private Connection connection;
	private Connection_Postgres connection_Postgres;
	
	public QueryDAO(Connection_Postgres connection_Postgres) {
		this.connection_Postgres = connection_Postgres;
	}	
	
	public ArrayList<Recibo> getReciboList() {
		String sql = "SELECT * FROM recibo;";
		ArrayList<Recibo> reciboList = new ArrayList<Recibo>();
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			Recibo recib = new Recibo();
			
			while (rs.next()) {
				recib = new Recibo();
				recib.setAtendId(rs.getInt("atendid"));
				recib.setFuncNome(rs.getString("funcnome"));
				recib.setCliNome(rs.getString("clinome"));
				recib.setValTotal(rs.getFloat("valtotal"));
				
				reciboList.add(recib);
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
		return reciboList;
	}
}