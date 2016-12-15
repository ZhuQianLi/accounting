package cn.edu.zust.controller.newprjct;



import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.dbutils.handlers.ArrayListHandler;

import cn.edu.zust.controller.BaseServlet;

public class zcqd extends BaseServlet {

	public void index() throws Exception{
		
		System.out.println("index zcqd");
		
		List<Object[]> query = runner.query("select * from zcqd", new ArrayListHandler());
		
		JSONArray jsonArray = JSONArray.fromObject(query);
		
		PrintWriter out = response.getWriter();
		System.out.println(jsonArray.toString());
		out.print(jsonArray);
		
	}

}
