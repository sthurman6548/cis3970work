import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(9000);
		Socket client = server.accept();

		BufferedReader in = new BufferedReader(
			new InputStreamReader(client.getInputStream()));
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);

		String line;
		while ((line = in.readLine()) != null) {
			System.out.println("Server receive: " + line);
			out.println("Echo: " + line);
		}

		client.close();
		server.close();
	}

}
