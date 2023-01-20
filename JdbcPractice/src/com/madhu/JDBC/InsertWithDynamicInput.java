package com.madhu.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class InsertWithDynamicInput {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		Statement statement = null;
		Scanner scanner = null;
		ResultSet resultSet = null;
		
//step 2 establish the connection
		String url ="jdbc:mysql:///student";
		String name="root";
		String password ="root";
		connection = DriverManager.getConnection(url,name,password);
		
		//step3: create statement object and send the query
		//get the user inputs
		scanner = new Scanner(System.in);
		System.out.println("enter student id");
		int sid = scanner.nextInt();
		System.out.println("enter student name");
		String sname = scanner.next();
		System.out.println("enter student age");
		int sage = scanner.nextInt();
		System.out.println("enter student city");
		String scity= scanner.next();
		//step4: execute the query and process the result
		String sqlQueryString = String.format("insert into student(`id`,`name`,`age`,`city`) values(%d,'%s',%d,'%s')", sid,sname,sage,scity);
         statement = connection.createStatement();
         int rowsaffected = statement.executeUpdate(sqlQueryString);
         System.out.println(sqlQueryString);
         System.out.println("rows affected:"+rowsaffected);
         //step6:
         statement.close();
         connection.close();
         scanner.close();
         
	}

}
