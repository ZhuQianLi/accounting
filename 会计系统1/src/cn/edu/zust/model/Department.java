package cn.edu.zust.model;

import cn.edu.zust.utils.StringUtil;

public class Department {
	private String Acc_DeP;
	private String Acc_DNa;
	private String Acc_Usr;
	private String Acc_Date;
	private String Acc_Last;
	public String getAcc_DeP() {
		return Acc_DeP;
	}
	public void setAcc_DeP(String acc_DeP) {
		Acc_DeP = acc_DeP;
	}
	public String getAcc_DNa() {
		return Acc_DNa;
	}
	public void setAcc_DNa(String acc_DNa) {
		Acc_DNa = acc_DNa;
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
		return "Department [Acc_DeP=" + Acc_DeP + ", Acc_DNa=" + Acc_DNa
				+ ", Acc_Usr=" + Acc_Usr + ", Acc_Date=" + Acc_Date
				+ ", Acc_Last=" + Acc_Last + "]";
	}
	


	
}
