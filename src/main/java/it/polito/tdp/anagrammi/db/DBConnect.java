package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/dizionario?user=root&password=rootMDB107";
		try {
			Connection conn = DriverManager.getConnection(url);
			return conn;
		} catch (SQLException e) {
			System.out.println("ERRORE di connessione al databese");
			e.printStackTrace();
			return null;
		}
	}
}
