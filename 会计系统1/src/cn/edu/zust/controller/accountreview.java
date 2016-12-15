package cn.edu.zust.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;


import static cn.edu.zust.utils.DataSourceUtil.*;

public class accountreview extends BaseServlet {
	private static final long serialVersionUID = 1L;
	QueryRunner runner = new QueryRunner(getDataSource());
	public void index() throws IOException, ServletException{
		String sql = "SELECT OD_No, NAME, Acc_DNa, a.Acc_Last, OD_Sum, OD_Sta FROM OriginalDocument AS a " +
				"INNER JOIN USER AS b ON a.`Acc_Usr`=b.`Acc_Usr` " +
				"INNER JOIN Department AS c ON c.`Acc_DeP`=a.`Acc_DeP` ORDER BY a.Acc_Date;";
		try {
			List<Object[]> list = runner.query(sql, new ArrayListHandler());
			request.setAttribute("adlist", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/jsps/accountreview.jsp").forward(request, response);
	}
	
	public void select(){
		String sql = "";
		
		
	}

}
