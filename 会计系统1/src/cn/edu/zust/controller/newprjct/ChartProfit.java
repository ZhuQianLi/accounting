package cn.edu.zust.controller.newprjct;



import cn.edu.zust.controller.BaseServlet;

public class ChartProfit extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void index() throws Exception{
		response.sendRedirect(request.getContextPath()+"/html/利润表.html");
	}
	
	
}
