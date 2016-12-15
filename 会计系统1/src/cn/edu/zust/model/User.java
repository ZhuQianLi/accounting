package cn.edu.zust.model;

public class User {
	private String Acc_Usr;
	private String NAME;
	private String PASSWORD;
	private String roleid;
	private String Acc_DNa;
	public String getAcc_Usr() {
		return Acc_Usr;
	}
	public void setAcc_Usr(String acc_Usr) {
		Acc_Usr = acc_Usr;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getAcc_DNa() {
		return Acc_DNa;
	}
	public void setAcc_DNa(String acc_DNa) {
		Acc_DNa = acc_DNa;
	}
	@Override
	public String toString() {
		return "User [Acc_Usr=" + Acc_Usr + ", NAME=" + NAME + ", PASSWORD="
				+ PASSWORD + ", roleid=" + roleid + ", Acc_DNa=" + Acc_DNa
				+ "]";
	}
	

	
}
