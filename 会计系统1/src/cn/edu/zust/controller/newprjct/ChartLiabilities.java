package cn.edu.zust.controller.newprjct;

import java.io.IOException;

import cn.edu.zust.controller.BaseServlet;

public class ChartLiabilities extends BaseServlet{
	
	
	public void index() throws Exception{
		
		response.sendRedirect(request.getContextPath()+"/html/资产负债表.html");
		
	}
	
	
	
}
