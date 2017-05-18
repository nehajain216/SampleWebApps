package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class RequestLoggingFilter
 */
public class RequestLoggingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RequestLoggingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
		String requestURI = req.getRequestURI();
		List<String> defaultURI = new ArrayList<String>();
		defaultURI.add("LoginPage.jsp");
		defaultURI.add("LoginServlet.jsp");
		for(String uri: defaultURI)
		{
			if(uri.equals(requestURI))
				chain.doFilter(req, res);
			else
			{				
				Object loginUser = session.getAttribute("LOGIN_USER");
				if(loginUser != null)
					chain.doFilter(req, res);
				else
					((HttpServletResponse) response).sendRedirect("LoginPage.jsp");
				
			}			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
