import java.sql.*;

public class JDBC {
	public static final String url="jdbc:mysql://localhost:3306/coursework_db";
	public static final String user="root";
	public static final String password="";
	
//	public static void main(String args[]) {
//		JDBC jdbc=new JDBC();
//		jdbc.connect();
//	}
	
	private Connection connect() {
		try {
			Connection conn=DriverManager.getConnection(url,user,password);
			System.out.println("Database connection successfull");
			return conn;
		}catch(SQLException e){
			System.out.println("Database Connection failed");
			e.printStackTrace();
			return null;
		}
			
	}
}