package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.net.ssl.SSLSocket;
/*
 * The {@code UserHandler} object handles connections for normal users
 * Code has been added to allow the user to add/delete/rplace items in an inventory.
 * @Contributor: Seth Thurman
 * @Version:1.5
 */

public class UserHandler implements Runnable {

	private ArrayList<Integer> values;
	private DataInputStream dis;
	private DataOutputStream dos;
	private SSLSocket conn;
	
	public UserHandler(SSLSocket conn, ArrayList<Integer> values) {
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
		try {
			int clientID = dis.readInt();
			int value = 0;
			Server.cont = true;
			int total = 0;
			
			while (Server.cont) {
		//		total = 0;
		//	value = dis.readInt();
		//		values.add(value);
			
		//		for (int i = 0; i < values.size(); i++) {		
		//			total += values.get(i);
		//		}
				
		//		dos.writeUTF("You are client #" + clientID +", current total=" + total);
			System.out.println("Reading input");
			String action = dis.readUTF();				
				handle(action);
			}
			dos.writeUTF("shutdown");
			dos.close();
			dis.close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Handles interactions with the inventory.
	 * @return nothing
	 */
	public void handle(String action) {
		String item;

		
		try{
			
		
			System.out.println("Recieved");
			switch(action) {
			
				case "A":
					 item = dis.readUTF();
	 			 	 Server.add(item);
					 System.out.println(Server.inventory.toString());
					 break;
				case "D":
					 item = dis.readUTF();
					 Server.delete(item);
					 break;
				case "R":
					 item = dis.readUTF();
					String item2 = dis.readUTF();
					Server.replace(item, item2);
					break;
				case "Q":
					conn.close();
					break;
				default:
					dos.writeUTF("Not a valid input");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
