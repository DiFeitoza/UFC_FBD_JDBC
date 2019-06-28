package com.ufc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ufc.connection.Connection_Postgres;
import com.ufc.entity.AvaCliByAtend;
import com.ufc.entity.CliAtendOrderByBairro;
import com.ufc.entity.CountCliAtendByBairro;
import com.ufc.entity.MaxAvaByServ;
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

	public ArrayList<CliAtendOrderByBairro> getListCliAtendOrderByBairro() {
		String sql = "SELECT * FROM CliAtendOrderByBairro";
		ArrayList<CliAtendOrderByBairro> cliAtendOrderByBairroList = new ArrayList<CliAtendOrderByBairro>();
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			CliAtendOrderByBairro cliAtend = new CliAtendOrderByBairro();
			
			while (rs.next()) {
				cliAtend = new CliAtendOrderByBairro();
				cliAtend.setBairro(rs.getString("bairro"));
				cliAtend.setCpf(rs.getString("cpf"));
				cliAtend.setNomeCli(rs.getString("nome"));	
				cliAtendOrderByBairroList.add(cliAtend);
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
		return cliAtendOrderByBairroList;
	}
	
	public ArrayList<CountCliAtendByBairro> getCountCliAtendByBairro() {
		String sql = "SELECT * FROM CountCliAtendByBairro";
		ArrayList<CountCliAtendByBairro> countCliAtendByBairroList = new ArrayList<CountCliAtendByBairro>();
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			CountCliAtendByBairro countCli = new CountCliAtendByBairro();
			
			while (rs.next()) {
				countCli = new CountCliAtendByBairro();
				countCli.setBairro("bairro");
				countCli.setCount("count");	
				countCliAtendByBairroList.add(countCli);
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
		return countCliAtendByBairroList;
	}
	
	public ArrayList<MaxAvaByServ> getMaxAvaByServList() {
		String sql = "SELECT * FROM MaxAvaByServ";
		ArrayList<MaxAvaByServ> maxAvaByServList = new ArrayList<MaxAvaByServ>();
		
		try {
			this.connection = connection_Postgres.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			MaxAvaByServ maxAva = new MaxAvaByServ();
			
			while (rs.next()) {
				maxAva = new MaxAvaByServ();
				maxAva.setId(rs.getInt("id"));
				maxAva.setNome(rs.getString("nome"));	
				maxAva.setMaxNota(rs.getInt("maior_nota"));
				maxAvaByServList.add(maxAva);
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
		return maxAvaByServList;
	}

}