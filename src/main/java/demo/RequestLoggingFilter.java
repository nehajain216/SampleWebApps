/**
 * 
 */
package demo;

import java.io.IOException;

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
 * @author Siva
 *
 */
public class RequestLoggingFilter implements Filter
{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		/*HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String requestURI = request.getRequestURI();
		System.out.println("--------------before filter------");
		System.err.println("URI :"+requestURI);
		
		Object loginUser = session.getAttribute("LOGIN_USER");
		chain.doFilter(req, res);
		System.out.println("--------------after filter------"); */
		chain.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
