package demo;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt =null; 
		ResultSet rs = null;		
		try 
		{
			connection = DBUtil.getConnection();			
			String uemail = request.getParameter("email");	
			String upwd = request.getParameter("pwd");	
            stmt = connection.createStatement();
            String sql = "select * from userdetails where email=? and password=?";
            pstmt =  connection.prepareStatement(sql);
            pstmt.setString(1, uemail);
            pstmt.setString(2, upwd);  
            rs = pstmt.executeQuery();
            
            
            
            if(rs.next())
            {
            	// Login into application -- navigate to main page  
            	System.out.println("Hello");
            	HttpSession session= request.getSession(true);
            	session.setAttribute("LOGIN_USER", uemail);    
            	
            	response.sendRedirect("MainPage.jsp");
            }            
            else
            {
            	// Redirect to login page      
            	response.sendRedirect("LoginPage.jsp");
            }
            pstmt.close();
            
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

}
