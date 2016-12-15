package cn.edu.zust.controller;

import static cn.edu.zust.utils.DataSourceUtil.getDataSource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.zust.view.user_User;



public class user extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private QueryRunner runner = new QueryRunner(getDataSource());
	//访问主页
	public void index() throws ServletException, IOException{
		String sql = "SELECT a.name AS username,b.Acc_DNa,a.Acc_Usr,a.password,c.name AS rolename  FROM USER AS a " +
				"INNER JOIN department AS b ON a.Acc_Dep=b.Acc_Dep " +
				"INNER JOIN role AS c ON a.roleid=c.id ";
		try {
			List<user_User> list = runner.query(sql, new BeanListHandler<user_User>(user_User.class));
			request.setAttribute("userList", list);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		request.getRequestDispatcher("/jsps/user.jsp").forward(request, response);
	}
	//更新用户
	public void update(){
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String roleName = request.getParameter("roleName");
		String Acc_DNa = request.getParameter("Acc_DNa");
		String Acc_Usr = request.getParameter("Acc_Usr");
		String sql = "UPDATE USER SET NAME=?,PASSWORD=?,roleid=(SELECT id FROM role WHERE NAME=?),Acc_Dep=(SELECT Acc_DeP FROM department WHERE Acc_DNa=?) " +
				"WHERE Acc_Usr=? ";
		try {
			runner.update(sql, userName, password, roleName, Acc_DNa, Acc_Usr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//删除用户
	public void delete(){
		String Acc_Usr = request.getParameter("Acc_Usr");
		String sql = "DELETE FROM USER WHERE Acc_Usr="+Acc_Usr;
		try {
			runner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


}
