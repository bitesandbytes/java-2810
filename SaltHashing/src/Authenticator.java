import java.security.*;

public class Authenticator
{
	private UserTable users;
	MessageDigest md;

	Authenticator() throws NoSuchAlgorithmException
	{
		users = new UserTable();
		md = MessageDigest.getInstance("SHA-1");
	}

	public boolean checkUser(String username)
	{
		return users.userLookup(username);
	}

	public boolean authenticate(String username, String password)
	{
		User obj = users.getUserObject(username);
		String actualPass, checkPass;
		md.update((obj.password + obj.salt).getBytes());
		actualPass = md.digest().toString();
		md.update((obj.salt + password).getBytes());
		checkPass = md.digest().toString();
		if (actualPass.equals(checkPass))
			return true;
		else
			return false;
	}
}
