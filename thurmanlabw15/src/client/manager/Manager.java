package manager;

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

public class Manager {
	
	private SSLSocket conn;
	private DataOutputStream dos;
	private DataInputStream dis;
	private int ID;
	private String addr;
	private int port;
	private int value;

	public Manager(String addr, int port) {
		this.addr = addr;
		this.port = port;
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
							
			System.out.println("Connected");		
			while (cont) {
			
				cont = handleConn(dis, dos);				
			}
			System.out.println("CLosing");
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
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
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


	public boolean handleConn(DataInputStream dis, DataOutputStream dos) {
		System.out.println("Press U for user data\nPress S for shared data\nPress Q to shutdown");
		Scanner sn = new Scanner(System.in);
		String opt = sn.nextLine();
		String message;
		try {
			switch(opt){
				case "U":
					dos.writeUTF("U");
					message = dis.readUTF();
					System.out.println(message);
					break;
				case "S":
					dos.writeUTF("S");
					message = dis.readUTF();
					System.out.println(message);
					break;
				case "Q":
					dos.writeUTF("Q");
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
