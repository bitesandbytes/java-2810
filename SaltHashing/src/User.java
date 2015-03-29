public class User
{
	String username;
	String password;
	String salt;
	
	User(String username, String password,String salt)
	{
		this.username = username;
		this.password = password;
		this.salt = salt;
	}

	public void changePassword(String newPassword)
	{
		this.password = newPassword;
		return;
	}
}
