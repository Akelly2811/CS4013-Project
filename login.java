/*
* login users
*/

public class login {
	String name;
	String password;
	public login(String name, String password) {
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
}