import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {

	public static void main(String[] args) throws IOException, InterruptedException {
		
        System.out.println("Client attempting to connect...");
        Socket socket = new Socket("localhost", 4242);
        System.out.println("Connected to server");

        BufferedReader serverIn = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter serverOut = new PrintWriter(
                socket.getOutputStream(), true);

        String response;
        while (true) {
        	 serverOut.println("Client here");
        	 response = serverIn.readLine();
        	 System.out.println("Server> " + response);
        	 Thread.sleep(5000);
        }
        
	}

}
