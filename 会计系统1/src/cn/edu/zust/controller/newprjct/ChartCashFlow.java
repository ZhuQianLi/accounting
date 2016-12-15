package cn.edu.zust.controller.newprjct;


import java.io.IOException;

import cn.edu.zust.controller.BaseServlet;

public class ChartCashFlow extends BaseServlet{
	
	public void index() throws Exception{
		
		response.sendRedirect(request.getContextPath()+"/html/现金流量表.html");
		
		
	}
	
	
}
