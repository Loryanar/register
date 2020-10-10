package helpers;

import java.sql.Connection;
import java.sql.DriverManager;

public class Condb {

	public static Connection crearCon() {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Registro","postgres","1234");
			System.out.println("hplo");
			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
		return con;
	}
}
