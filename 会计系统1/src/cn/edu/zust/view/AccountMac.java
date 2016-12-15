package cn.edu.zust.view;


import cn.edu.zust.utils.StringUtil;

public class AccountMac {
	private String Acc_No; //会计科目编号
	private String Acc_Nam; //会计科目名称
	private String Acc_AnA; //会计类别名
	private String Acc_NoFName; //父会计科目编号
	private String Acc_Usr; //创建人标编号
	private String Acc_Date; //建立日期
	private String Acc_Last; //列新日期
	public AccountMac() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountMac(String acc_No, String acc_Nam, String acc_AnA,
			String acc_NoFName, String acc_Usr, String acc_Date, String acc_Last) {
		super();
		Acc_No = acc_No;
		Acc_Nam = acc_Nam;
		Acc_AnA = acc_AnA;
		Acc_NoFName = acc_NoFName;
		Acc_Usr = acc_Usr;
		Acc_Date = acc_Date;
		Acc_Last = acc_Last;
	}
	public String getAcc_No() {
		return Acc_No;
	}
	public void setAcc_No(String acc_No) {
		Acc_No = acc_No;
	}
	public String getAcc_Nam() {
		return Acc_Nam;
	}
	public void setAcc_Nam(String acc_Nam) {
		Acc_Nam = acc_Nam;
	}
	public String getAcc_AnA() {
		return Acc_AnA;
	}
	public void setAcc_AnA(String acc_AnA) {
		Acc_AnA = acc_AnA;
	}
	public String getAcc_NoFName() {
		return Acc_NoFName;
	}
	public void setAcc_NoFName(String acc_NoFName) {
		Acc_NoFName = acc_NoFName;
	}
	public String getAcc_Usr() {
		return Acc_Usr;
	}
	public void setAcc_Usr(String acc_Usr) {
		Acc_Usr = acc_Usr;
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
	@Override
	public String toString() {
		return "AccountMac [Acc_No=" + Acc_No + ", Acc_Nam=" + Acc_Nam
				+ ", Acc_AnA=" + Acc_AnA + ", Acc_NoFName=" + Acc_NoFName
				+ ", Acc_Usr=" + Acc_Usr + ", Acc_Date=" + Acc_Date
				+ ", Acc_Last=" + Acc_Last + "]";
	}
	
	
	
}
