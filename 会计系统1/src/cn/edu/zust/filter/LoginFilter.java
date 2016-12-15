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

import cn.edu.zust.model.User;

public class LoginFilter implements Filter{

	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		System.out.println("----->"+req.getRequestURI());
		User globalUser = (User) req.getSession().getAttribute("globalUser");
		//判断Session中是否存在globalUser来判断是否已登录
		if(globalUser!=null)
			chain.doFilter(request, response);
		else{
			resp.sendRedirect(req.getContextPath());
		}
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
