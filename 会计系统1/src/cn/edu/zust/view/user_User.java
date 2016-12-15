package cn.edu.zust.view;

public class user_User {
	private String username;
	private String Acc_DNa;
	private String Acc_Usr;
	private String password;
	private String rolename;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	@Override
	public String toString() {
		return "user_User [username=" + username + ", Acc_DNa=" + Acc_DNa
				+ ", Acc_Usr=" + Acc_Usr + ", password=" + password
				+ ", rolename=" + rolename + "]";
	}
	
	
	
}
