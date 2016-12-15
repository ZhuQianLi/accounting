package cn.edu.zust.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;



public class jizhangpingzheng extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void save() throws IOException, SQLException{
		String jsonString = request.getParameter("jsonString");
		Map map = JSONObject.fromObject(jsonString);
		List<List> parameterList = getParameterList(map);
		
		//多条数据 插入多次
		for(List list : parameterList){
			String sql = "INSERT INTO accounting_voucher " +
					"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			runner.update(sql, list.toArray());
		}
		
	}
	//json
	private List getParameterList(Map map) {
		String pz_date = (String) map.get("pz_date");
		String pz_id = (String) map.get("pz_id");
		String kuaijizhuguan = (String) map.get("kuaijizhuguan");
		String jizhang = (String) map.get("jizhang");
		String jihe = (String) map.get("jihe");
		String zhidan = (String) map.get("zhidan");
		String chuna = (String) map.get("chuna");
		String danju = (String) map.get("danju");
		String jiaolingguanren = (String) map.get("jiaolingguanren");
		List data = (List) map.get("data");
		List parameterList = new ArrayList();
		for(int index=0;index<data.size();index++){
			List<String> list = new ArrayList<String>();
			list.add(pz_id);
			list.add(pz_date);
			list.add(kuaijizhuguan);
			list.add(jizhang);
			list.add(jihe);
			list.add(zhidan);
			list.add(chuna);
			list.add(jiaolingguanren);
			list.add(danju);
			Map m= (Map) data.get(index);
			list.add((String) m.get("zhaiyao"));
			list.add((String) m.get("jiesuanfangshi"));
			list.add((String) m.get("piaohao"));
			list.add((String) m.get("zongzhangkemu"));
			list.add((String) m.get("mingxikemu"));
			list.add((String) m.get("jiefangjine"));
			list.add((String) m.get("daifangjine"));
			parameterList.add(list);
			for(String s : list){
				System.out.print(s+" ");
			}
			System.out.println();
			/* list data
			 *  日期 凭证编号 会计主管人员 记账 稽核 制单 出纳 交领款人 单据张数 摘要1 结算 票号 总账科目 明细科目 11111110000 22222220000 
				日期 凭证编号 会计主管人员 记账 稽核 制单 出纳 交领款人 单据张数 摘要2 结算 票号 总账科目 明细科目 11111110000 22222220000 
				日期 凭证编号 会计主管人员 记账 稽核 制单 出纳 交领款人 单据张数 摘要3 结算 票号 总账科目 明细科目 11111110000 22222220000 
				日期 凭证编号 会计主管人员 记账 稽核 制单 出纳 交领款人 单据张数 摘要4 结算 票号 总账科目 明细科目 11111110000 22222220000 
			 * 
			 */
		}
		return parameterList;
	}

}
