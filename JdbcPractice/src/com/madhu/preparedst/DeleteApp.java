package com.madhu.preparedst;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.madhu.jdbcutil.JDBCUtil;

public class DeleteApp {

	public static void main(String[] args) {
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		try {
			connection=JDBCUtil.getJdbcConnection();
			if(connection!=null) {
				String sqlDeleteuery = "Delete from student where id=?";
				preparedStatement= connection.prepareStatement(sqlDeleteuery);
			}
			if(preparedStatement!=null) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("ener the student id to delete:");
				int sid =scanner.nextInt();
				
				preparedStatement.setInt(1,sid);
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
