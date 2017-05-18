package sample;

import java.io.IOException;
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
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uemail = request.getParameter("email");	
		String upwd = request.getParameter("pwd");	
		
		boolean validUser = DBUtil.isUserCredentialValid(uemail,upwd);
		if(validUser)
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("USER_LOGIN", uemail);
			response.sendRedirect("MainPage.jsp");			
		}
		else
		{
			boolean existingUser = DBUtil.isUserExist(uemail);
			if(existingUser)
			{
				// print a message in login page stating plese check the credentails
			}
			else
			{
				// print user does not exist. please create an account.
			}
			response.sendRedirect("LoginPage.jsp");
			
		}
	}

}
