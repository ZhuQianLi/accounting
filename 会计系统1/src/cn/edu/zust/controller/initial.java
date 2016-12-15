package cn.edu.zust.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class initial extends BaseServlet {

	public void index() throws ServletException, IOException{
		
		
		request.getRequestDispatcher("/jsps/initial.jsp").forward(request, response);
	}

}
