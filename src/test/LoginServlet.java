package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.objects.*;
import com.mysql.jdbc.PreparedStatement;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection con = null;
		String email = request.getParameter("email");
		String location = request.getParameter("location");

		System.out.println("Email:" + email);
		System.out.println("Location: " + location);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql:///weatherdb", "root", "root");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("Connection done....");

		try {
			insertData(con, email, location);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("Data inserted....");

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("Success.jsp");
//		request.getRequestDispatcher("Success.jsp").forward(request, response);

	}

	public void insertData(Connection con, String email, String location) throws SQLException, IOException {

		Statement st = con.createStatement();

		String sql = "INSERT INTO user " + "VALUES ('" + email + "', '" + location + "')";

		st.executeUpdate(sql);

	}

}
