package cn.edu.zust.model;

public class MACNAME {
	private String Acc_No; //会计科目编号
	private String Acc_Nam; //会计科目名称
	private String Acc_Set; //会计类别编号
	private String Acc_NoF; //父会计科目编号
	private String Acc_Usr; //创建人标编号
	private String Acc_Date; //建立日期
	private String Acc_Last; //列新日期
	public MACNAME() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MACNAME(String acc_No, String acc_Nam, String acc_Set,
			String acc_NoF, String acc_Usr, String acc_Date, String acc_Last) {
		super();
		Acc_No = acc_No;
		Acc_Nam = acc_Nam;
		Acc_Set = acc_Set;
		Acc_NoF = acc_NoF;
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
	public String getAcc_Set() {
		return Acc_Set;
	}
	public void setAcc_Set(String acc_Set) {
		Acc_Set = acc_Set;
	}
	public String getAcc_NoF() {
		return Acc_NoF;
	}
	public void setAcc_NoF(String acc_NoF) {
		Acc_NoF = acc_NoF;
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
		Acc_Date = acc_Date;
	}
	public String getAcc_Last() {
		return Acc_Last;
	}
	public void setAcc_Last(String acc_Last) {
		Acc_Last = acc_Last;
	}
	@Override
	public String toString() {
		return "MACNAME [Acc_No=" + Acc_No + ", Acc_Nam=" + Acc_Nam
				+ ", Acc_Set=" + Acc_Set + ", Acc_NoF=" + Acc_NoF
				+ ", Acc_Usr=" + Acc_Usr + ", Acc_Date=" + Acc_Date
				+ ", Acc_Last=" + Acc_Last + "]";
	}
	
}
