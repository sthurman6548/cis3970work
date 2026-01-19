import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(4242);
		System.out.println("Server listening on port 8080");

		Socket client = server.accept();
		System.out.println("Client connected from " +
				client.getInetAddress() + ":" + client.getPort());

        	BufferedReader in = new BufferedReader(
                	new InputStreamReader(client.getInputStream()));
	        PrintWriter out = new PrintWriter(
        		client.getOutputStream(), true);
        
	        String message;
	        while (true) {
        		message = in.readLine();
        		System.out.println("Received: " + message);
	        	out.println("Echo from server: " + message);
        	
        	}
	}

}
