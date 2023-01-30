package com.madhu.preparedst;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.madhu.jdbcutil.JDBCUtil;

public class PreparedStEx {

	public static void main(String[] args)  {
		
Connection connection = null;
PreparedStatement preparedStatement = null;
try {
	connection = JDBCUtil.getJdbcConnection();
	System.out.println("connection established:");
	
	String sqlInsertQuery = "insert into student(`id`,`name`,`age`,`city`)values(?,?,?,?)";
	
	if(connection!=null)
		preparedStatement=connection.prepareStatement(sqlInsertQuery);
    if(preparedStatement!=null) {
    	//use precompiled query to set the values
    	/*preparedStatement.setInt(1, 101);
    	preparedStatement.setString(2, "AAA");
    	preparedStatement.setInt(3, 45);
    	preparedStatement.setString(4, "MI");
    	System.out.println(sqlInsertQuery);
    	*/
    	
    	//take the dynamic input
    	Scanner scanner= new Scanner(System.in);
    	System.out.println("Enter the id");
    	int sid = scanner.nextInt();
    	
    	System.out.println("Enter the name");
    	String sname = scanner.next();
    	
    	System.out.println("Enter the age");
    	int sage = scanner.nextInt();
    	
    	System.out.println("Enter the city");
    	String scity = scanner.next();
    	
    	
    	preparedStatement.setInt(1, sid);
    	preparedStatement.setString(2, sname);
    	preparedStatement.setInt(3, sage);
    	preparedStatement.setString(4, scity);
    	//execute the query
    	int rowsAffeted=preparedStatement.executeUpdate();
    }

} catch (SQLException | IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally {
	try {
		JDBCUtil.closeResources(connection, preparedStatement, null);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	}

}
