package com.madhu.preparedst;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.madhu.jdbcutil.JDBCUtil;

public class SelectApp {

	public static void main(String[] args) {

Connection connection = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;
int sid=0;
 try {
	connection= JDBCUtil.getJdbcConnection();
	if(connection!=null) {
		String sqlSelectQuery = "select id,name,age,city from student where id = ?";
		preparedStatement = connection.prepareStatement(sqlSelectQuery);
	}
	if(preparedStatement!=null) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter the id:");
	sid= scanner.nextInt();
		preparedStatement.setInt(1, sid);
		resultSet =preparedStatement.executeQuery();
	}
	if(resultSet!=null) {
		if(resultSet.next()) {
			System.out.println("Sid\tSname\tSage\tsScity");
			System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
			
		}else {
			System.out.println("record not avai;ab;e for id:"+sid);
		}
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally {
	try {
		JDBCUtil.closeResources(connection, preparedStatement, resultSet);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	}

}
