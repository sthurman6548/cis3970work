import java.io.*;
import java.net.*;

public class CounterClient {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 5000);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		out.println("increment");
		String response = in.readLine();
		System.out.println(response);

		socket.close();
	}
}
