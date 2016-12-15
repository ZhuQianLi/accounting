package cn.edu.zust.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import cn.edu.zust.model.User;
import cn.edu.zust.view.AccountMac;

import static cn.edu.zust.utils.DataSourceUtil.*;
import static cn.edu.zust.utils.DateUtil.*;
import static cn.edu.zust.utils.StringUtil.*;
public class accountmac extends BaseServlet {
	private static final long serialVersionUID = 1L;
	QueryRunner runner = new QueryRunner(getDataSource());
	//查询所有会计科目类别ok
	public void select(){
		String sql = "SELECT Acc_AnA FROM MACCSET";
		try {
			List<Object> list = runner.query(sql, new ColumnListHandler());
			String[] strings = (String[]) list.toArray(new String[list.size()]);
			String Acc_AnAs = getStringLink(strings);
			response.getWriter().write(Acc_AnAs);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//根据科目类别名查询一级科目ok
	public void select2(){
		String sql = "SELECT Acc_Nam FROM macname AS a INNER JOIN maccset AS b ON a.Acc_Set=b.Acc_Set WHERE b.Acc_AnA=?";
		String param = "资产类";
		try {
			List<Object> list = runner.query(sql, new ColumnListHandler(), param);
			String[] strings = list.toArray(new String[list.size()]);
			String Acc_Nams = getStringLink(strings);
			System.out.println(Acc_Nams);
			response.getWriter().write(Acc_Nams);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//根据一级科目查询科目类别ok
	public void select3(){
		String sql = "SELECT maccset.Acc_AnA FROM MACNAME " +
				"INNER JOIN MACCSET ON MACNAME.Acc_Set=MACCSET.Acc_Set " +
				"WHERE macname.Acc_Nam=?";
		String param = "现金";
		try {
			List<Object> list = runner.query(sql, new ColumnListHandler(), param);
			String Acc_AnA = (String) list.get(0);
			System.out.println(Acc_AnA);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	//插入会计科目
	public void insert(){
		String Acc_No = request.getParameter("Acc_No");
		String Acc_Nam = request.getParameter("Acc_Nam");
		String Acc_Set = request.getParameter("Acc_Set");
		String Acc_NoF = request.getParameter("Acc_NoF");
		String Acc_Usr = "无用户";
		User globalUser = (User) request.getSession().getAttribute("globalUser");
		Acc_Usr = globalUser.getAcc_Usr();
		//根据科目类别名得到编号
		Acc_Set = selectAcc_SetByAcc_AnA(Acc_Set);
		//判断是二级还是一级科目
		if(!Acc_NoF.equals("无")){
			//根据一级会计科目名得到会计科目编号
			Acc_NoF = selectAcc_NoByAcc_Nam(Acc_NoF);
			String sql = "INSERT INTO macname2 VALUES(?,?,?,?,?,?,?)";
			try {
				runner.update(sql, Acc_No, Acc_Nam, Acc_NoF, Acc_Set, Acc_Usr, getCurrentDate(), getCurrentDate());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			String[] params = new String[]{Acc_No, Acc_Nam, Acc_Set, Acc_Usr,
					getCurrentDate(), getCurrentDate()};
			String sql = "INSERT INTO macname VALUES(?,?,?,?,?,?);";
			try {
				runner.update(sql, (Object[])params);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//主页查询所有会计科目信息ok
	public void index() throws ServletException, IOException{
		//查询科目
		String sql1 = "SELECT Acc_No2 AS Acc_No,Acc_Nam2 AS Acc_Nam,Acc_AnA,Acc_Nam AS Acc_NoFName,NAME AS Acc_Usr,a.Acc_Date,a.Acc_Last FROM macname2 AS a " +
				"INNER JOIN macname AS b ON a.Acc_No=b.Acc_No " +
				"INNER JOIN maccset AS c ON a.Acc_Set=c.Acc_Set " +
				"INNER JOIN USER AS d ON a.`Acc_Usr`=d.`Acc_Usr` " +
				"UNION ALL " +
				"SELECT Acc_No,Acc_Nam,Acc_AnA,NULL AS Acc_NoFName,NAME AS Acc_Usr,a.Acc_Date,a.Acc_Last FROM macname AS a " +
				"INNER JOIN maccset AS b ON a.Acc_Set=b.Acc_Set " +
				"INNER JOIN USER AS c ON a.`Acc_Usr`=c.`Acc_Usr` " +
				"ORDER BY Acc_Last ";
		try {
			List<AccountMac> list1 = runner.query(sql1, new BeanListHandler<AccountMac>(AccountMac.class));
			request.setAttribute("allMacnameList", list1);
			List<List<String>> list3 = getKindList();
			request.setAttribute("kindList", list3);
			request.getRequestDispatcher("/jsps/accountmac.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//获取List[[负债类, 短期借款], [资产类, 银行存款, 现金, 内部往来, 其他货币资金]]
	private List<List<String>> getKindList() {
		String sql3 = "SELECT Acc_Nam,Acc_AnA FROM macname AS a " +
				"RIGHT OUTER JOIN maccset AS b ON a.`Acc_Set`=b.`Acc_Set` ORDER BY b.Acc_AnA;";
		List<AccountMac> list = new ArrayList<AccountMac>();
		try {
			list = runner.query(sql3, new BeanListHandler<AccountMac>(AccountMac.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<List<String>> retlist = new ArrayList<List<String>>();
		String kind = "";
		for(AccountMac am : list){
			if(!am.getAcc_AnA().equals(kind)){
				List<String> l = new ArrayList<String>();
				l.add(am.getAcc_AnA());
				if(am.getAcc_Nam()!=null)
					l.add(am.getAcc_Nam());
				retlist.add(l);
				kind=am.getAcc_AnA();
			}else{
				retlist.get(retlist.size()-1).add(am.getAcc_Nam());
			}
		
		}
		return retlist;
	}
	//删除会计科目
	public void delete(){
		String Acc_Nos = request.getParameter("Acc_Nos");
		String[] params = Acc_Nos.split(",");
		String qms = getStringQuestionMarks(params.length);
		String sql = "DELETE FROM macname WHERE Acc_No IN ("+qms+")";
		String sql2 = "DELETE FROM macname2 WHERE Acc_No2 IN ("+qms+")";
		try {
			int affectNo = runner.update(sql, (Object[])params);
			affectNo += runner.update(sql2, (Object[])params);
			if(affectNo!=params.length)
				System.out.println("删除会计科目出错");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//查询会计科目名所对应的编号
	private String selectAcc_NoByAcc_Nam(String Acc_Nam){
		String Acc_No = null;
		String sql = "SELECT Acc_No FROM macname WHERE Acc_Nam=?";
		try {
			List<Object> list = runner.query(sql, new ColumnListHandler(), Acc_Nam);
			if(list.size()==1)
				Acc_No = (String) list.get(0);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return Acc_No;
	}
	//查询科目类别名所对应的编号
	private String selectAcc_SetByAcc_AnA(String Acc_Set) {
		String sql = "SELECT Acc_Set AS a FROM maccset WHERE Acc_AnA=?";
		try {
			List<Object> list = runner.query(sql, new ColumnListHandler(), Acc_Set);
			Acc_Set = (String) list.get(0);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return Acc_Set;
	}
	
	
	
}
