package com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.entity.AvaCliByAtend;
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

	public ArrayList<AvaCliByAtend> getListAvaCliByAtend() {
		String sql = "SELECT * FROM ListAvaCliByAtend";
		ArrayList<AvaCliByAtend> avaCliByAtendList = new ArrayList<AvaCliByAtend>();
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			AvaCliByAtend avaCli = new AvaCliByAtend();
			
			while (rs.next()) {
				avaCli = new AvaCliByAtend();
				avaCli.setId_atend(rs.getInt("id_atendimento"));
				avaCli.setComent(rs.getString("comentario"));
				avaCli.setNome_func(rs.getString("funcionario"));
				avaCli.setNota_func(rs.getInt("nota_funcionario"));
				avaCli.setNome_serv(rs.getString("servico"));
				avaCli.setNota_serv(rs.getInt("nota_servico"));
				avaCli.setNome_maq(rs.getString("maquina"));
				avaCli.setNota_maq(rs.getInt("nota_maquina"));				
				avaCliByAtendList.add(avaCli);
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
		return avaCliByAtendList;
	}

}