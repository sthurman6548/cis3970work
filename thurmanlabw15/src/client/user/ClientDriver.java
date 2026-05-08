package user;

public class ClientDriver {

	public static void main(String[] args) {
		User client = new User(999, "localhost", 4242, -1);
		client.run();
	}

}
