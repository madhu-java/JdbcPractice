package com.madhu.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AutoLoadingEx {

	public static void main(String[] args) throws SQLException {
      Connection connection = null;
		Statement statement=null;
		ResultSet resultSet = null;
//from JDBC4.X autoloading feature is enabled
	//we don't need to write step1//load and register the driver
		//step2:establish the connection
		
		//String url="jdbc:mysql://localhost:3306/student";
		//if it is local host and port number is deafult port we don't need to write them
		String url="jdbc:mysql:///student";
		String user="root";
		String password="root";
		connection = DriverManager.getConnection(url,user,password);
		
		
		
		//step3: create statement onjevt and send the query
		String sqlQuerString="select id, name,age,city from student";
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sqlQuerString);
		System.out.println("ID\tNAME\tAGE\tCITY");
		//step 4 process the resultset
		
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt("age")+"\t"+resultSet.getString("city"));
			
		}
		//step 6 close the resources
		
		resultSet.close();
		statement.close();
		connection.close();

	}

}
