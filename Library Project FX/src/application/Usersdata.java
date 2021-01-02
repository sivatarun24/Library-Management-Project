package application;

public class Usersdata {
	String userid , username , password , name , address , phonenumber;

	public Usersdata(String userid, String username, String password, String name, String address, String phonenumber) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
