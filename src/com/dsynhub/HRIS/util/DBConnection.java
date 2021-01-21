package com.dsynhub.HRIS.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	private static String username="root";
	private static String password="root";
	private static String connectionURL="jdbc:mysql://localhost:3306/HRIS";
	private static String driverClassnamme="com.mysql.jdbc.Driver";
	
	
	public static Connection getDBConnection(){
		
		Connection conn=null;
		
		try {
			Class.forName(driverClassnamme);
		
			conn=DriverManager.getConnection(connectionURL,username,password);
			
			if(conn!=null){
				
				System.out.println("Hey...Connected with DataBase");
				
			}
			
			else{
				
				System.out.println("Someting Went Wrong...DataBase Not Connected");
			}
		} 
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		}
		
		 catch (SQLException e) {
				e.printStackTrace();
			}
		return conn;
		
	}

	public static void main(String[] args) {
		Connection conn = DBConnection.getDBConnection();
		
		if(conn!=null)
			System.out.println("Done");
	}
}
