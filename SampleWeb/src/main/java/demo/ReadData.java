package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadData
 */
public class ReadData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String page = "DisplayData.jsp";		
		Connection connection = null;
		Statement stmt = null;
        List<Employee> empdata = new ArrayList<Employee>();  
        try
        {
        	 connection = DBUtil.getConnection();
             stmt = connection.createStatement();
             String sql= "select id, name, age from employee";
             ResultSet rs = stmt.executeQuery(sql);
                     
             while(rs.next())
             {            	 
            	 int eid = rs.getInt("id");
            	 String ename = rs.getString("name");
            	 int eage = rs.getInt("age");
            	 Employee emp = new Employee(eid, ename, eage);
            	 empdata.add(emp); 
             }           
             rs.close();
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
         }catch(Exception e){
            //Handle errors for Class.forName
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
        request.setAttribute("empData",empdata);
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        if (dispatcher != null){
            dispatcher.forward(request, response);
        }        
	}
	

}
