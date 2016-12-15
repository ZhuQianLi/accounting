package cn.edu.zust.model;

import cn.edu.zust.utils.StringUtil;

public class MACCSET {
	private String Acc_Set; //会计类别编号
	private String Acc_AnA; //会计类别名称
	private String Acc_Dis; //会计类别性质
	private String Name; //创建人标编号
	private String Acc_Date; //建立日期
	private String Acc_Last; //列新日期


	public String getAcc_Set() {
		return Acc_Set;
	}
	public void setAcc_Set(String acc_Set) {
		Acc_Set = acc_Set;
	}
	public String getAcc_AnA() {
		return Acc_AnA;
	}
	public void setAcc_AnA(String acc_AnA) {
		Acc_AnA = acc_AnA;
	}
	public String getAcc_Dis() {
		return Acc_Dis;
	}
	public void setAcc_Dis(String acc_Dis) {
		Acc_Dis = acc_Dis;
	}
	
	public String getAcc_Date() {
		return Acc_Date;
	}
	public void setAcc_Date(String acc_Date) {
		acc_Date = StringUtil.getStringDateFormat(acc_Date);
		Acc_Date = acc_Date;
	}
	public String getAcc_Last() {
		return Acc_Last;
	}
	public void setAcc_Last(String acc_Last) {
		acc_Last = StringUtil.getStringDateFormat(acc_Last);
		Acc_Last = acc_Last;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "MACCSET [Acc_Set=" + Acc_Set + ", Acc_AnA=" + Acc_AnA
				+ ", Acc_Dis=" + Acc_Dis + ", Name=" + Name + ", Acc_Date="
				+ Acc_Date + ", Acc_Last=" + Acc_Last + "]";
	}
	
	
}
