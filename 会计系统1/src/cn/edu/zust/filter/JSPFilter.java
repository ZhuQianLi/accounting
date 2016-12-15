package cn.edu.zust.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSPFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//除了登录的jsp
		System.out.println(req.getRequestURI());
		if(req.getRequestURI().equals("/jsps/login.jsp")||
				req.getRequestURI().equals(req.getContextPath()+"/")){
			chain.doFilter(request, response);
			return;
		}
		req.getSession().setAttribute("message", "您没有此权限");
		resp.sendRedirect(req.getContextPath());
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
