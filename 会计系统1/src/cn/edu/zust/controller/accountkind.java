package cn.edu.zust.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.zust.model.MACCSET;
import cn.edu.zust.model.User;

import static cn.edu.zust.utils.DataSourceUtil.getDataSource;
import static cn.edu.zust.utils.DateUtil.getCurrentDate;
import static cn.edu.zust.utils.StringUtil.*;

public class accountkind extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private QueryRunner runner = new QueryRunner(getDataSource());
	//访问主页
	public void index() throws Exception{		
		String sql = "SELECT Acc_Set,Acc_AnA,NAME,Acc_Date,Acc_Last FROM maccset AS a " +
				"INNER JOIN USER AS b ON a.Acc_Usr=b.Acc_Usr ";
		List<MACCSET> list =  runner.query(sql, new BeanListHandler<MACCSET>(MACCSET.class));
		request.setAttribute("current_accountkind", list);
		request.getRequestDispatcher("/jsps/accountkind.jsp").forward(request, response);
	}
	//添加会计类别
	public void insert(){
		String Acc_Set = request.getParameter("Acc_Set");
		String Acc_AnA = request.getParameter("Acc_AnA");
		String Acc_Dis = "1";
		String Acc_Usr = "无用户";
		User globalUser = (User) request.getSession().getAttribute("globalUser");
		Acc_Usr = globalUser.getAcc_Usr();
		String[] params = new String[]{Acc_Set, Acc_AnA, Acc_Dis, Acc_Usr,
				getCurrentDate(), getCurrentDate()};
		String sql = "insert into MACCSET(Acc_Set,Acc_AnA,Acc_Dis,Acc_Usr,Acc_Date,Acc_Last)" +
				" values(?,?,?,?,?,?)";
		try {
			runner.update(sql, (Object[])params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//response.sendRedirect(request.getContextPath()+"/accountkind?method=index");
	}
	//删除会计类别
	public void delete(){
		String str = request.getParameter("Acc_Sets");
		String[] params = str.split(",");
		String qms = getStringQuestionMarks(params.length);
		String sql = "delete from MACCSET where Acc_Set in("+qms+")";
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
