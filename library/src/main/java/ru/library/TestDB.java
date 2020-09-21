package ru.library;

import java.sql.DriverManager;

public class TestDB {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/library";
		String user = "postgres";
		String pass = "230695";
		try {
			DriverManager.getConnection(url, user, pass);
			System.out.println("Connection successful");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
