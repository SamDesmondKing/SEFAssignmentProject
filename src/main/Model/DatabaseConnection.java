package main.Model;
import java.sql.*;


public class DatabaseConnection {
	public static String URL = "jdbc:mysql://localhost:3306/SNL";
    private static String username = "root"; private static String password = "root";
    public static Connection con = null;
	public static Connection getConnection() {
		
        try { // load the driver

        	con = DriverManager.getConnection (URL, username, password);
          
        	if(con !=  null) {
        	  System.out.println("Success"); 
        	}else {
        	  System.out.println("fail");
        	}
                   
        }catch(SQLException se) {
             System.out.println("SQLException: " + se);
        }
        return con;
	}    
}


