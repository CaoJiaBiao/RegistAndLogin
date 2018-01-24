package cao.bean;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String uid;
	private String username;
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String uid, String username, String password) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password="
				+ password + "]";
	}

	// 后台校验用户名和密码
	public boolean checkUsernameAndpassword() {
		if (!(username != null && username.matches("[a-zA-Z]{6,12}"))) {

			return false;
		}
		if (!(password != null && password.matches("[0-9]{6,12}"))) {

			return false;
		}

		return true;
	}

}
