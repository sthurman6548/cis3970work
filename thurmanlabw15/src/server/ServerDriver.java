package server;

public class ServerDriver {

	public static void main(String[] args) {
		Server server1 = new Server(4242, 4243);
		//Server server2 = new Server(4243);
		server1.run();
		
		
		/*
		var h1 = Thread.ofVirtual().start(() -> server1.run());
		//var h2 = Thread.ofVirtual().start(() -> server2.run());
		
		try {
			h1.join();
		//	h2.join();		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//server2.run();
	}

}
