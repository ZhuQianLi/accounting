package cn.edu.zust.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;



public class StringUtil {



	public static String getStringQuestionMarks(int num){
		String str = "";
		for(int i=0;i<num;i++)
			str+="?,";
		str = str.substring(0,str.length()-1);
		return str;
	}
	
	public static String getStringLink(String[] strings){
		String string = "";
		for(String s : strings)
			string += s+",";
		string = string.substring(0, string.length()-1);
		return string;
	}
	

	public static String getStringDateFormat(String date){
		String yyyy = date.substring(0, 4);
		String MM = date.substring(4,6);
		String dd = date.substring(6, 8);
		return yyyy+" "+MM+"-"+dd;
	}
	
	public static void main(String[] args) {
		String jsonStr = "{weight:[{a:\"a\"},{b:\"b\"}],name:\"露西\",age:26,gender:\"female\",grades:\"三班\"}";
		Map<String, Object> map = new HashMap<String, Object>();

        map = JSONObject.fromObject(jsonStr);
        List mm= (List) map.get("weight");
        Map m1 = (Map) mm.get(0);
        System.out.println(m1.get("a"));
        
//        System.out.println(map.get("weight"));
//        System.out.println(map.get("name"));
//        System.out.println(map.get("age"));
//        System.out.println(map.get("gender"));
//        System.out.println(map.get("grades"));
        
	}
	
	
	
	
	

	public void test1(){
		String s = "{zz:zz,sddsadsa:[a,b,d],add:{a:a,b:b},adfd:[{d:d,c:c},{g:f},{c:f}]}";
		String regex1 = "(^)(\\{)(.*)(\\})($)";//匹配MAP
		Pattern pt1 = Pattern.compile(regex1);
		String regex2 = "(^)(\\[)(.*)(\\])($)";//匹配ARRAY
		Pattern pt2 = Pattern.compile(regex2);
		s = s.trim();
		
		if(pt1.matcher(s).matches()){
			System.out.println("MAP类型");
			//去掉{}
			String ss = s.substring(1, s.length()-1);
//			System.out.println(ss);
			
			
			
		}else{
			System.out.println("不是MAP类型");
			if(pt2.matcher(s).matches()){
				System.out.println("数组类型");
				
				
			}else{
				System.out.println("值类型");
				
				
			}
			
		}
		
		
		
		
//		
//		Pattern pt = Pattern.compile(regex1);
//		Matcher matcher = pt.matcher(s);
//		
//		
//
//		
//		boolean b = matcher.matches();
//		System.out.println(b);
		
		
		
		
		
		
		
		
		
		
	}
	
}
