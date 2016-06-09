



public class ClientUser {

	public boolean checkUser(User u)
	{
		return new ClientConnecttoServer().sendLoginInfoToServer(u);
	}
	
}
