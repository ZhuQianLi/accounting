package cn.edu.zust.controller;

import static cn.edu.zust.utils.DataSourceUtil.getDataSource;
import static cn.edu.zust.utils.DateUtil.getCurrentDate;
import static cn.edu.zust.utils.StringUtil.getStringQuestionMarks;

import java.sql.SQLException;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.zust.model.Department;
import cn.edu.zust.model.User;

public class dept extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private QueryRunner runner = new QueryRunner(getDataSource());
	//访问主页
	public void index() throws Exception{		
		String sql = "SELECT a.Acc_DeP,Acc_DNa,NAME AS Acc_Usr,Acc_Date,Acc_Last FROM department AS a " +
				"INNER JOIN USER AS b ON a.Acc_Usr=b.Acc_Usr ";
		List<Department> list =  runner.query(sql, new BeanListHandler<Department>(Department.class));
		request.setAttribute("DepartmentList", list);
		request.getRequestDispatcher("/jsps/dept.jsp").forward(request, response);
	}
	//添加会计类别
	public void insert(){
		String Acc_DeP = request.getParameter("Acc_DeP");
		String Acc_DNa = request.getParameter("Acc_DNa");
		String Acc_Usr = "无用户";
		User globalUser = (User) request.getSession().getAttribute("globalUser");
		Acc_Usr = globalUser.getAcc_Usr();
		String[] params = new String[]{Acc_DeP, Acc_DNa, Acc_Usr,
				getCurrentDate(), getCurrentDate()};
		String sql = "insert into Department " +
				" values(?,?,?,?,?)";
		try {
			runner.update(sql, (Object[])params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//response.sendRedirect(request.getContextPath()+"/accountkind?method=index");
	}
	//删除会计类别
	public void delete(){
		String str = request.getParameter("Acc_DePs");
		String[] params = str.split(",");
		String qms = getStringQuestionMarks(params.length);
		String sql = "delete from Department where Acc_DeP in("+qms+")";
		try {
			int affectNo = runner.update(sql, (Object[])params);
			if(affectNo!=params.length)
				System.out.println("删除会计类别出错了");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//response.sendRedirect(request.getContextPath()+"/accountkind?method=index");
	}

}
