import java.io.*;
import java.net.*;

public class CounterServerCP {
	static int counter = 0;

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(5000);
		System.out.println("Server running on port 5000");

		while (true) {
			Socket client = server.accept();
			Thread t = new Thread(() -> handleClient(client));
			t.start();
		}
	}

	private static synchronized  void handleClient(Socket client) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);

			String line = in.readLine();
			if (line.equals("increment")) {
				counter++;
				out.println(counter);
			}
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
