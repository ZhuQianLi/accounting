package cn.edu.zust.model;

public class OriginalDocument {
	private String OD_No;//原始凭证编码
	private String OD_TrW;//转账方式
	private String OD_UsW;//用途
	private String OD_ItNa;//物品名称
	private String OD_ItPr;//物品单价
	private String OD_ItNu;//物品数量
	private String OD_Sum;//价格总计
	private String OD_Desc;//摘要
	private String Acc_Usr;//用户编号
	private String Acc_DeP;//部门编号
	private String Acc_Date;//建立日期
	private String Acc_Last;//列新日期
	private String OD_Sta;//审核状态
	private String OD_Exam;//审核金额
	public String getOD_No() {
		return OD_No;
	}
	public void setOD_No(String oD_No) {
		OD_No = oD_No;
	}
	public String getOD_TrW() {
		return OD_TrW;
	}
	public void setOD_TrW(String oD_TrW) {
		OD_TrW = oD_TrW;
	}
	public String getOD_ItNa() {
		return OD_ItNa;
	}
	public void setOD_ItNa(String oD_ItNa) {
		OD_ItNa = oD_ItNa;
	}
	public String getOD_ItPr() {
		return OD_ItPr;
	}
	public void setOD_ItPr(String oD_ItPr) {
		OD_ItPr = oD_ItPr;
	}
	public String getOD_ItNu() {
		return OD_ItNu;
	}
	public void setOD_ItNu(String oD_ItNu) {
		OD_ItNu = oD_ItNu;
	}
	public String getOD_Sum() {
		return OD_Sum;
	}
	public void setOD_Sum(String oD_Sum) {
		OD_Sum = oD_Sum;
	}
	public String getOD_Desc() {
		return OD_Desc;
	}
	public void setOD_Desc(String oD_Desc) {
		OD_Desc = oD_Desc;
	}
	public String getAcc_Usr() {
		return Acc_Usr;
	}
	public void setAcc_Usr(String acc_Usr) {
		Acc_Usr = acc_Usr;
	}
	public String getAcc_DeP() {
		return Acc_DeP;
	}
	public void setAcc_DeP(String acc_DeP) {
		Acc_DeP = acc_DeP;
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
	
	public String getOD_UsW() {
		return OD_UsW;
	}
	public void setOD_UsW(String oD_UsW) {
		OD_UsW = oD_UsW;
	}
	
	public String getOD_Sta() {
		return OD_Sta;
	}
	public void setOD_Sta(String oD_Sta) {
		OD_Sta = oD_Sta;
	}
	
	
	public String getOD_Exam() {
		return OD_Exam;
	}
	public void setOD_Exam(String oD_Exam) {
		OD_Exam = oD_Exam;
	}
	@Override
	public String toString() {
		return "OriginalDocument [OD_No=" + OD_No + ", OD_TrW=" + OD_TrW
				+ ", OD_UsW=" + OD_UsW + ", OD_ItNa=" + OD_ItNa + ", OD_ItPr="
				+ OD_ItPr + ", OD_ItNu=" + OD_ItNu + ", OD_Sum=" + OD_Sum
				+ ", OD_Desc=" + OD_Desc + ", Acc_Usr=" + Acc_Usr
				+ ", Acc_DeP=" + Acc_DeP + ", Acc_Date=" + Acc_Date
				+ ", Acc_Last=" + Acc_Last + ", OD_Sta=" + OD_Sta
				+ ", OD_Exam=" + OD_Exam + "]";
	}
	
	
}
