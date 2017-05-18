package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil 
{
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		String driverClass = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "admin";
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
	}

}
