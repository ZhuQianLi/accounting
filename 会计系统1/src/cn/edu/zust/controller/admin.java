package cn.edu.zust.controller;

import static cn.edu.zust.utils.DataSourceUtil.getDataSource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import cn.edu.zust.model.User;


public class admin extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private QueryRunner runner = new QueryRunner(getDataSource());
	public void index() throws ServletException, IOException{
		User globalUser = (User)request.getSession().getAttribute("globalUser");
		String roleid = globalUser.getRoleid();
		//查询权限
		String sql = "SELECT b.name FROM rolemenu AS a " +
				"INNER JOIN menu AS b ON a.`MID`=b.`id` WHERE rid="+roleid;
		try {
			List<Object> list = runner.query(sql, new ColumnListHandler());
			System.out.println(list);
			request.setAttribute("menuList", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("jsps/admin.jsp").forward(request, response);
	}
	
	

}
