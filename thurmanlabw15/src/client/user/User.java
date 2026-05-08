package user;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Random;
import java.util.Scanner;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
/*
 * A {@code User} object represents a client.
 * The client can connect and send commands to a server to modify a stores inventory
 * @Contributor: Seth Thurman
 * @Version:1.5
 */
public class User {
	
	private SSLSocket conn;
	private DataOutputStream dos;
	private DataInputStream dis;
	private int ID;
	private String addr;
	private int port;
	private int value;

	public User(int ID, String addr, int port, int value) {
		this.ID = ID;
		this.addr = addr;
		this.port = port;
		this.value = value;		
	}
	
	public void run() {
		try {
			String passwd = "password";
			char[] password = passwd.toCharArray();
			
			KeyStore keyStore = KeyStore.getInstance("JKS");
			FileInputStream keystorefile = new FileInputStream("keystore.jks");
			keyStore.load(keystorefile, password);
			
			// trust managers - manage specific types of trust
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
			tmf.init(keyStore);
			
			SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
			sslContext.init(null, tmf.getTrustManagers(), null);
			
			SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
			conn = (SSLSocket) sslSocketFactory.createSocket(addr, port);
			System.out.println(conn);

			conn.startHandshake();

			dis = new DataInputStream(this.conn.getInputStream());
			dos = new DataOutputStream(this.conn.getOutputStream());
			
			boolean cont = true;
			dos.writeInt(ID);
			
			while (cont) {
				
				cont = handle();
				/*String message = dis.readUTF();
			if (message.equals("shutdown")) {
					cont = false;
				}
				System.out.println("From server: " + message);
				Thread.sleep(2000);*/
			}
		
			dis.close();
			dos.close();
			conn.close();
			
		} catch (IOException e) {
			System.err.println(e);
		} catch (KeyStoreException e) {
			System.err.println(e);
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
		} catch (CertificateException e) {
			System.err.println(e);
		} catch (KeyManagementException e) {
			System.err.println(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}
	}

	public boolean handle() {
	
		System.out.println("Press A to add item\nPress D to delete item \nPress R to replace item\nPress Q to quit");
		Scanner sn = new Scanner(System.in);
		String opt = sn.nextLine();
		String message;
		String item;
		try {
			switch(opt){
				case "A":
					dos.writeUTF("A");
					System.out.println("Insert item to inventory");
					item = sn.nextLine();
					dos.writeUTF(item);
					break;
				case "D":
					dos.writeUTF("D");
					System.out.println("Item to delete from inventory");
					item = sn.nextLine();
					dos.writeUTF(item);
					break;
				case "R":
					dos.writeUTF("R");
					System.out.println("Item to replace from inventory");
					item = sn.nextLine();
					dos.writeUTF(item);
					System.out.println("Replacement");
					item = sn.nextLine();
					dos.writeUTF(item);
					break;
				case "Q":
					return false;

				default: 
					System.out.println("Not an accepted input");
				}
		}catch(IOException e) {
			System.err.println(e);
		}

		return true;
	}
	
}
