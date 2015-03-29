import java.security.*;
import java.util.*;

public class UserTable
{
	private Hashtable<String, User> userTable;
	private SecureRandom saltGenerator;
	public int userCount;

	UserTable()
	{
		userTable = new Hashtable<String, User>(8192, 0.5f);
		userCount = 0;
	}

	public boolean userLookup(String username)
	{
		if (username != null)
			return userTable.containsKey(username);
		return false;
	}
	
	public boolean addUser(String newUsername, String password)
	{
		if(!userLookup(newUsername))
			return false;
		byte[] bytes = new byte[16];
		saltGenerator.nextBytes(bytes);
		String salt = bytes.toString();
		User newUser = new User(newUsername,password,salt);
		userTable.put(newUsername, newUser);
		return true;
	}
	
	public User getUserObject(String username)
	{
		if(!userLookup(username))
			return null;
		User returnObject = userTable.get(username);
		return returnObject;
	}
}
