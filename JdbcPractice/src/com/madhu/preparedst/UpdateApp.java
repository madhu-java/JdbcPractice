package com.madhu.preparedst;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.jar.Attributes.Name;

import com.madhu.jdbcutil.JDBCUtil;

public class UpdateApp {

	public static void main(String[] args) {

Connection connection =null;
PreparedStatement preparedStatement = null;
try {
	connection=JDBCUtil.getJdbcConnection();
	if(connection!=null) {
		String sqlUpdateuery = "update student set Name =? where id=?";
		preparedStatement= connection.prepareStatement(sqlUpdateuery);
	}
	if(preparedStatement!=null) {
		preparedStatement.setString(1,"Navin");
		preparedStatement.setInt(2,101);
		int rowsaffected =preparedStatement.executeUpdate();
		System.out.println("rowsaffected:"+rowsaffected);
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
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
