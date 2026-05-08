package server;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

/*
 * A {@code Server} object creates a Server object
 * The server holds an Arraylist that stores the inventory for a store.
 * Users can add, delete, and replace items in the inventory
 *
 * @Contributor: Seth Thurman
 * @Version: 1.5
 */
public class Server {
	public static boolean cont;
	private ArrayList<Integer> values;
	protected static int connections, currentconn;	
	private ServerSocket userserver;
	private ServerSocket mgrserver;
	private SSLSocket user;
	private SSLSocket manager;
	private int portuser;
	private int portmgr;
	public static  ArrayList<String> inventory;
	public Server(int portuser, int portmgr) {
		this.portuser = portuser;
		this.portmgr = portmgr;
		this.values = new ArrayList<>();
		this.inventory = new ArrayList<>();
	}
	
	public void run() {
		try {
			String passwd = "password";
			char[] password = passwd.toCharArray();

			KeyStore keyStore = KeyStore.getInstance("JKS"); 
			FileInputStream keystorefile = new FileInputStream("files/keystore.jks");
			keyStore.load(keystorefile, password);

			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			kmf.init(keyStore, password);

            SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
            sslContext.init(kmf.getKeyManagers(), null, null);

            SSLServerSocketFactory ssf = sslContext.getServerSocketFactory();

            userserver = (SSLServerSocket) ssf.createServerSocket(portuser);
            //ssf.crea
            
            mgrserver = (SSLServerSocket) ssf.createServerSocket(portmgr);
			
            
			System.out.println("Server started.");
			System.out.println("Server Info: " + userserver.getLocalSocketAddress());
			System.out.println("Waiting for user");
			
			System.out.println("Server started.");
			System.out.println("Server Info: " + mgrserver.getLocalSocketAddress());
			System.out.println("Waiting for manager");
			Server.cont = true;
			
			var h1 = Thread.ofVirtual().start( () -> {
				while(Server.cont)
					try {
						user = (SSLSocket) userserver.accept();
						Thread.ofVirtual().start(new UserHandler(user, values));
						connections++;
						currentconn++;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			});
			
			var h2 = Thread.ofVirtual().start( () -> {
				while(Server.cont)
					try {
						manager = (SSLSocket) mgrserver.accept();
						Thread.ofVirtual().start(new MgrHandler(manager, values));
						connections++;
						currentconn++;
					} catch (IOException e) {
						e.printStackTrace();
					}
				
			});
			
			h1.join();
			h2.join();
			System.out.println("DONE");
		} catch (IOException e) {
			System.err.println(e);
		} catch (KeyStoreException e) {
			System.err.println(e);
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
		} catch (CertificateException e) {
			System.err.println(e);
		} catch (UnrecoverableKeyException e) {
			System.err.println(e);
		} catch (KeyManagementException e) {
			System.err.println(e);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("DONE");
	}
	
	/*
	 * Adds items from clients to inventory
	 * @return none
	 */
	public synchronized static void add(String item){
		inventory.add(item);

		System.out.println(inventory.toString());
	}
	/*
	 * Deletes items from inventory
	 * @return none
	 */
	public synchronized static void delete(String item) {
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).equals(item)) {
				inventory.remove(i);
			}
			System.out.println(inventory.toString());
		
		}
	}
	/*
	 * Replaces items in inventory.
	 * @return none
	 */	
	public synchronized static void replace(String item, String item2) {
			for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).equals(item)) {
				inventory.set(i, item2);
			}
			System.out.println(inventory.toString());
		}


	} 
	/*
	 * Allows manager to view shared data
	 * @return none
	 */

	public synchronized static String view() {
		return inventory.toString();
	}

	public synchronized static void quit() {
		Server.cont = false;
	}

	
}
