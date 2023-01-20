package com.madhu.jdbcutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

public class JDBCUtil {
private JDBCUtil(){}
static {
	//step 1 : loading and registering the driver
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}

public static Connection getJdbcConnection() throws SQLException, IOException {
//	String url ="jdbc:mysql:///student";
//	String username="root";
//	String password ="root";
	//take the data from apllication.properties file
	FileInputStream fis= new FileInputStream("C:\\Users\\madha\\git\\repository\\JdbcPractice\\src\\com\\madhu\\properties\\application.properties");
	Properties properties = new Properties();
	properties.load(fis);
	System.out.println("url:"+properties.getProperty("url"));
	System.out.println("username:"+properties.getProperty("username"));
	System.out.println("password:"+properties.getProperty("password"));
	Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
	System.out.println("connection object created...");
	return connection;
}

public static  void closeResources(Connection connection, Statement statement,ResultSet resultSet) throws SQLException {
	if(connection!=null) {
		connection.close();
	}
	if(statement!=null) {
		statement.close();
	}
	if(resultSet!=null) {
		resultSet.close();
	}
}

}
