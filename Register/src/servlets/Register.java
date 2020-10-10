package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.Condb;
import helpers.Hashing;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String pass = request.getParameter("pass");
		String id = request.getParameter("id");
		String cell = request.getParameter("cell");
		String email = request.getParameter("email");
		String h = Hashing.hashPW(pass);
		try {
			Connection conexion = Condb.crearCon();
			PreparedStatement ps1 = conexion.prepareStatement("INSERT INTO reg VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps1.setString(1, user);
			ps1.setString(2, name);
			ps1.setString(3, lastname);
			ps1.setString(4, cell);
			ps1.setString(5, id);
			ps1.setString(6, email);
			ps1.setBoolean(7, false);
			ps1.setString(8, h);
			ps1.execute();
			out.println("{\"message\":\"Usuario creado satisfactoriamente\", \"status\": 200}");
			ps1.close();
		 } catch (SQLException e) {
			out.println("{\"message\":\"error\"}");	
		 }
	}


	}


