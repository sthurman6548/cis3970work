package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.net.ssl.SSLSocket;

public class MgrHandler implements Runnable {

	private ArrayList<Integer> values;
	private DataInputStream dis;
	private DataOutputStream dos;
	private SSLSocket conn;
	
	public MgrHandler(SSLSocket conn, ArrayList<Integer> values) {
		this.conn = conn;
		this.values = values;
         		try {
			dos = new DataOutputStream(this.conn.getOutputStream());
			dis = new DataInputStream(this.conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}  
	} 

	@Override
	public void run() {
		
			Server.cont = true;
			
//			dos.writeUTF("shutdown");
			System.out.println("New Connection");
			while(Server.cont) {
				try {

				String message = dis.readUTF();
					handle(message);
				}catch(IOException e){
					e.printStackTrace();
				}
			}
	}
	public void handle(String message) {
		try {

				switch(message) {
					case "U":					
						dos.writeUTF(String.format("%d/%d", Server.currentconn,Server.connections));
						break;
					case "S":
						message = Server.view();
						dos.writeUTF(message);
						break;
					case "Q":
					Server.quit();
					System.out.println(values);			
					dos.close();
					dis.close();
					conn.close();
					default:
						dos.writeUTF("Not an accepted option");
				}
				} catch(IOException e) {
					e.printStackTrace();
				}
		} 
}





