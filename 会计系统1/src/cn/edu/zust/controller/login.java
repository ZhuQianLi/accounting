package cn.edu.zust.controller;

import static cn.edu.zust.utils.DataSourceUtil.getDataSource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.zust.model.User;



public class login extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private QueryRunner runner = new QueryRunner(getDataSource());
	
	public void userlogin(){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sql = "SELECT a.Acc_Usr,NAME,PASSWORD,roleid,Acc_DNa FROM USER AS a " +
				"INNER JOIN department AS b ON a.Acc_DeP=b.Acc_DeP " +
				"WHERE a.Acc_Usr = ? AND PASSWORD = ?";
		try {
			List<User> list = runner.query(sql, new BeanListHandler<User>(User.class), username, password);
			if(list.size()==1){
				request.getSession().setAttribute("globalUser", list.get(0));
				request.getRequestDispatcher("admin?method=index").forward(request, response);
				System.out.println(list.get(0));
			}
			else{
				request.getSession().setAttribute("message", "账号或密码错误");
				response.sendRedirect(request.getContextPath());
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	

	

}
