package com.madhu.preparedst;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    	preparedStatement.setInt(1, 101);
    	preparedStatement.setString(2, "AAA");
    	preparedStatement.setInt(3, 45);
    	preparedStatement.setString(4, "MI");
    	System.out.println(sqlInsertQuery);
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
