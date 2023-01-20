package com.madhu.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveAllRecords {

	public static void main(String[] args) {

Connection connection= null;
Statement statement = null;
ResultSet resultSet = null;



try {
	//Step 1: load and regiter the driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver loaded successfully...");
	
	//step 2: Establish the connection
	
	String url = "jdbc:mysql://localhost:3306/student";
	 String username="root";
	 String password="root";
	connection =DriverManager.getConnection(url,username,password);
	System.out.println("the implemet class is:"+ connection.getClass().getName());
	System.out.println("connection established successfully...");
	
	//step 3: create statement objec and send the query
	String sqlQuery="select id, name, age, city from student";
	statement = connection.createStatement();
	System.out.println("the implemet class is:"+ statement.getClass().getName());
	resultSet=statement.executeQuery(sqlQuery);	
	System.out.println("the implemet class is:"+ resultSet.getClass().getName());
	System.out.println();
	System.out.println("ID\tNAME\tAGE\tCITY");
	
	//step 4: process the resultet
	
	while(resultSet.next()) {
		int sid = resultSet.getInt(1);
		String sname=resultSet.getString(2);
		int sage =resultSet.getInt(3);
		String scity=resultSet.getString(4);
		System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+scity);
		
	}	
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	finally {
		//closing the resources
		
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
}
