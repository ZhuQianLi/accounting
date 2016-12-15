package cn.edu.zust.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import static cn.edu.zust.utils.DataSourceUtil.*;


public class detail extends BaseServlet {
	QueryRunner runner = new QueryRunner(getDataSource());
	
	
	public void index() throws ServletException, IOException{
		String sql = "SELECT OD_No, NAME, Acc_DNa, OD_UsW, OD_TrW, a.Acc_Last, OD_Sum, OD_Desc, OD_Sta, OD_ItNa, OD_ItPr, OD_ItNu FROM OriginalDocument AS a " +
				"INNER JOIN USER AS b ON a.`Acc_Usr`=b.`Acc_Usr` " +
				"INNER JOIN Department AS c ON c.`Acc_DeP`=a.`Acc_DeP` " +
				"WHERE OD_No=? ORDER BY a.Acc_Date ";
		String OD_No = request.getParameter("OD_No");
		try {
			List<Object[]> list = runner.query(sql, new ArrayListHandler(), OD_No);
			if(list.size()==1){
				List<Object[]> detailList = getDetailList(list);
				request.setAttribute("array", list.get(0));
				request.setAttribute("detailList", detailList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/jsps/detail.jsp").forward(request, response);
	}
	
	public void update(){
		String sql = "UPDATE OriginalDocument " +
				"SET OD_Exam = ?, OD_Sta = '已审核' " +
				"WHERE OD_No = ?";
		String OD_Exam = request.getParameter("OD_Exam");
		String OD_No = request.getParameter("OD_No");
		try {
			runner.update(sql, OD_Exam, OD_No);
			request.getRequestDispatcher("/accountreview?method=index").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		
	}


	private List<Object[]> getDetailList(List<Object[]> list) {
		Object[] strings = list.get(0);
		String[] OD_ItNa = ((String)strings[9]).split(",");
		String[] OD_ItPr = ((String)strings[10]).split(",");
		String[] OD_ItNu = ((String)strings[11]).split(",");
		List<Object[]> retlist = new ArrayList<Object[]>();
		for(int i=0;i<OD_ItNa.length;i++){
			String[] ss = new String[]{OD_ItNa[i],OD_ItPr[i],OD_ItNu[i]};
			retlist.add(ss);
		}
		return retlist;
	}
	
}
