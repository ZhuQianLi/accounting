package cn.edu.zust.controller;

import static cn.edu.zust.utils.DataSourceUtil.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import net.sf.json.JSONObject;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;


public class accountdocument extends BaseServlet {
	private static final long serialVersionUID = 1L;
	QueryRunner runner = new QueryRunner(getDataSource());
	//添加原始凭证
	public void insert() throws SQLException{
		
		out.print("insert ok");
		
		String jsonStr = request.getParameter("jsonStr");
		Map map = JSONObject.fromObject(jsonStr);
		System.out.println(jsonStr);
		String accountType = (String) map.get("yuanshipingzhengType");//凭证类型

		if("费用报销单".equals(accountType)){
			accountType = "ExpenseClaimForm";
		}else if("全国通用的增值税专用发票".equals(accountType)){
			accountType = "";
		}else{
			return;
		}
		
		
		
		List<Map> list = (List<Map>) map.get("content");
		//遍历list 
		for(Map<String, String> m : list){			
			List<String> colName = new ArrayList<String>();
			List<String> paramsList = new ArrayList<String>();
			for(Entry<String, String> entry : m.entrySet()){
				String key = entry.getKey();
				String value = entry.getValue();
				colName.add(key);
				paramsList.add(value);
			}
			
			//添加到数据库
			String sql = "insert into " + accountType +"(";
			String values = " values(";
			for(String s : colName){
				sql += s+",";
				values += "?,";
			}
			sql = sql.substring(0, sql.length()-1);
			values = values.substring(0, values.length()-1);
			values += ")";
			sql += ") "+values;
			
			System.out.println(sql);
			
			runner.update(sql, paramsList.toArray());
			
			
		}
		
		
		
		
		
		
//		String OD_No = "";// 原始凭证编码
//		String OD_TrW = request.getParameter("OD_TrW");// 转账方式
//		String OD_UsW = request.getParameter("OD_UsW");//用途
//		String OD_ItNa = getStringLink(request.getParameterValues("OD_ItNa")).substring(1);// 物品名称
//		String OD_ItPr = getStringLink(request.getParameterValues("OD_ItPr")).substring(1);// 物品单价
//		String OD_ItNu = getStringLink(request.getParameterValues("OD_ItNu")).substring(1);// 物品数量
//		String OD_Sum = request.getParameter("OD_Sum");// 价格总计
//		String OD_Desc = request.getParameter("OD_Desc");// 摘要
//		String Acc_Usr = "";// 用户编号
//		String Acc_DeP = "";// 部门编号
//		String Acc_Date = getCurrentDate();// 建立日期
//		String Acc_Last = getCurrentDate();// 列新日期
//		String OD_Sta = "未审核";
//		//获得用户编号和部门编号
//		String userName = request.getParameter("username");
//		String dept = request.getParameter("dept");
//		Acc_Usr = getAcc_UsrByuserName(userName);
//		Acc_DeP = getAcc_DePBydept(dept);
//		//生成原始凭证
//		OD_No = Acc_Usr+getCurrentDateTime();
//		String sql = "INSERT INTO OriginalDocument VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
//		try {
//			runner.update(sql, OD_No, OD_TrW, OD_UsW,OD_ItNa, OD_ItPr, OD_ItNu, OD_Sum, OD_Desc, Acc_Usr, Acc_DeP, Acc_Date, Acc_Last, OD_Sta, null);
//			response.sendRedirect(request.getContextPath()+"/accountdocument?method=index");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
	}
	
	public void index() throws IOException, Exception{

		request.getRequestDispatcher("/jsps/accountdocument.jsp").forward(request, response);
	}
	
	
	//根据部门名称得到部门编号
	private String getAcc_DePBydept(String dept) {
		String sql = "SELECT Acc_DeP FROM Department WHERE Acc_DNa = ?";
		String Acc_DeP = "没找到部门编号";
		try {
			List<Object> list = runner.query(sql, new ColumnListHandler(), dept);
			if(list.size()==1)
				Acc_DeP = (String) list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Acc_DeP;
	}
	//根据用户名得到用户编号
	private String getAcc_UsrByuserName(String userName) {
		String sql = "SELECT Acc_Usr NAME FROM USER WHERE NAME = ?";
		String Acc_Usr = "没找到用户编号";
		try {
			List<Object> list = runner.query(sql, new ColumnListHandler(), userName);
			if(list.size()==1)
				Acc_Usr = (String) list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Acc_Usr;
	}
	
	
	
}
