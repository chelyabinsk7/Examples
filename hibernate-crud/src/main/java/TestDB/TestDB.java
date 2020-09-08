package TestDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Сервлет создавался особым образом (см. видео 212)
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TestDB() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=Europe/Moscow";
		String user = "springstudent";
		String pass = "springstudent";
		String driver = "com.mysql.jdbc.Driver";
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + url);
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, user, pass);
			out.println("Connection successful");
			connection.close();
		}
		catch (Exception exc) {
			exc.printStackTrace();
//			throw new ServletException(exc);
		}
	}

}

