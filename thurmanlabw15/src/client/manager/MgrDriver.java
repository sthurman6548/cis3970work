package manager;

public class MgrDriver {

	public static void main(String[] args) {
		Manager manager = new Manager("localhost", 4243);
		manager.run();
	}

}
