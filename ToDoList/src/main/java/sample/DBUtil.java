package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
	
	public static ResultSet getUserInfo(String sql,String email, String password)
	{
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt =null; 
		ResultSet rs = null;	
		try
		{
			connection = DBUtil.getConnection();	
			stmt = connection.createStatement();  
			if(email !=null && password !=null)
			{
				 pstmt =  connection.prepareStatement(sql);              
		            pstmt.setString(1, email);
		            pstmt.setString(2, password);
		            System.out.println("--------------both email and password------");
		            rs = pstmt.executeQuery();
			}
			else
				if(email !=null && password==null)
				{
					 pstmt =  connection.prepareStatement(sql);              
			            pstmt.setString(1, email);			             
			            rs = pstmt.executeQuery();
				}
				else
					rs= stmt.executeQuery(sql); 
			pstmt.close();
            return rs;            
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return rs;
		}
		finally
		{
			try 
			{
				stmt.close();
				connection.close();
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	
	public static Boolean isUserCredentialValid(String email, String password)
	{
		ResultSet rs = null;
		boolean validUser = false;			
		try 
		{
			String sql = "select * from userdetails where email=? and password=?";		 
			rs = getUserInfo(sql,email,password);
			if(rs.next())
				validUser = true;
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return validUser;
	}
	public static Boolean isUserExist(String email)
	{
		ResultSet rs = null;
		boolean userexist = false;			
		try 
		{
			String sql = "select * from userdetails where email=?";		 
			rs = getUserInfo(sql,email,null);
			if(rs.next())
				userexist = true;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userexist;
	}
}
