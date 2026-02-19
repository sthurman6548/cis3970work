
package driver;

import bank.Bank;
import users.*;
import accounts.Account;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A {@code Driver} object controls the program.
 * It holds the main method.
 * 
 * @author Seth Thurman
 * @version 1.0
 *          Assignment: labw04
 *
 */

public class Driver {
  /*
   * Starts and runs the program.
   * 
   * @param args[] array of arguments to supply to the runtime.
   * 
   * @return type is nothing.
   */

  public static void main(String args[]) throws IOException, EOFException {
    Bank b = new Bank();
    HashMap<Integer, Account> accounts;
    HashMap<Integer, User> customers;

    Account acc = new Account(7777, 78.30, 3.15, true, 3159);
    Associate ass = new Associate(3432, "Seth", "Thurman", "fake@site.com", "username", "1234", 9999, "Friend of Bank");

    Manager man = new Manager(3945, "Someone", "else", "fake@site2.com", "manager", "pass", 111, 2222,
        "Manager of Nowhere");

    Customer c = new Customer(7777, "New", "Customer", "cus@site2.com", "customer", "23232", 4444);

    AccountsIn(b);
    employeesIn(b);
    customersIn(b);
    System.out.println(b.toString());

    b.addAccount(acc);
    b.addUser(ass);
    b.addUser(man);
    b.addUser(c);
    System.out.println(b.toString());
    b.removeUser(c);
    System.out.println(b.toString());

  }

  /*
   * parses a .bin file of accounts into the bank
   * 
   * @param b bank to insert the accounts into
   * 
   * @return type is nothing.
   */
  public static void AccountsIn(Bank b) throws IOException, EOFException {
    FileInputStream fs = new FileInputStream("files/accounts.bin");
    DataInputStream dstream = new DataInputStream(fs);

    int number = 0;
    double bal = 0;
    float apy = 0;
    short auth = 0;
    ArrayList<Integer> authorizedUsers = new ArrayList<>();

    try {
      while (dstream.available() > 0) {
        number = dstream.readInt();
        bal = dstream.readDouble();
        apy = dstream.readFloat();
        auth = dstream.readShort();

        for (int i = 0; i < auth; i++) {
          int au = dstream.readInt();
          authorizedUsers.add(au);

        }

        b.addAccount(new Account(number, bal, apy, authorizedUsers.get(0), authorizedUsers));

      }
    } catch (EOFException e) {
      e.printStackTrace();
    }
    dstream.close();

  }

  /*
   * parses a .bin file of employees into the bank
   * 
   * @param b bank to insert the accounts into
   * 
   * @return type is nothing.
   */
  public static void employeesIn(Bank b) throws IOException, EOFException {
    FileInputStream fs = new FileInputStream("files/employees.bin");
    DataInputStream dstream = new DataInputStream(fs);

    long id = 0;
    short pin = 0;
    int vaultPass = 0;
    String fname = null;
    String lname = null;
    String email = null;
    String user = null;
    String pass = null;
    String title = null;
    String n = null;
    try {

      while (dstream.available() > 0) {
        fname = dstream.readUTF();
        lname = dstream.readUTF();
        email = dstream.readUTF();
        user = dstream.readUTF();
        pass = dstream.readUTF();
        title = dstream.readUTF();
        n = dstream.readUTF();
        if (n.equals("Manager")) {
          id = dstream.readLong();
          pin = dstream.readShort();
          vaultPass = dstream.readInt();
          b.addUser((User) new Manager((int) id, fname, lname, email, user, pass, pin, vaultPass, title));
        } else {
          id = dstream.readLong();
          pin = dstream.readShort();
        }

        if (n.equals("Associate")) {
          b.addUser((User) new Associate((int) id, fname, lname, email, user, pass, pin, title));
        }

        if (n.equals("Employee")) {
          b.addUser((User) new Employee((int) id, fname, lname, email, user, pass, pin, title));
        }

      }
    } catch (EOFException e) {
      e.printStackTrace();
    }
    dstream.close();
  }

  public static void customersIn(Bank b) throws IOException, EOFException {
    FileInputStream fs = new FileInputStream("files/customers.bin");
    DataInputStream dstream = new DataInputStream(fs);
    Customer c;
    String fname = null;
    String lname = null;
    String email = null;
    String uname = null;
    String pass = null;
    int id = 0;
    int pin = 0;

    try {
      while (dstream.available() > 0) {
        id = dstream.readInt();
        pin = dstream.readInt();
        fname = dstream.readUTF();
        lname = dstream.readUTF();
        email = dstream.readUTF();
        uname = dstream.readUTF();
        pass = dstream.readUTF();

        b.addUser(new Customer(id, fname, lname, email, uname, pass, pin));
      }
    } catch (EOFException e) {
      e.printStackTrace();
    }
    dstream.close();
  }

}
