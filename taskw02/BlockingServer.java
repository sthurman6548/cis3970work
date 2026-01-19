import java.net.ServerSocket;

public class BlockingServer {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(7777);
        System.out.println("Waiting for client...");
        server.accept(); // blocks
        System.out.println("Connected");
    }

}
