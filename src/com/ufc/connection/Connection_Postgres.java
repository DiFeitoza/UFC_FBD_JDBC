package com.ufc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_Postgres{
	private final String ip = "localhost";
	private final Integer port = 5432;
	private final String user = "postgres";
	private final String password = "alunoufc";
	private final String database = "lavanderia";
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://"+ip+":"+port+"/"+database, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
