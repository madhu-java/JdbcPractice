package com.madhu.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.madhu.jdbcutil.JDBCUtil;

public class DeleteApp {

	public static void main(String[] args) {
		Connection connection= null;
		Statement statement=null;
		Scanner scanner = new Scanner(System.in);
		
		//step 2 establish the connection
		try {
			connection = JDBCUtil.getJdbcConnection();
			
			//step3 create statement onj and send the query
			System.out.println("enter student id to delte the record:");
			int sid=scanner.nextInt();
			String sqlQueryString = String.format("delete from student where id=%d", sid);
			statement= connection.createStatement();
			//step 4 execute query and process the result
			int noofrowsaffected = statement.executeUpdate(sqlQueryString);
			System.out.println("no of rows affected:"+noofrowsaffected);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.closeResources(connection, statement, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}

}
