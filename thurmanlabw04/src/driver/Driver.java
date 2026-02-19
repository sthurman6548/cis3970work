




package driver;

import bank.Bank;
import users.*;
import accounts.Account;

/**
 * A {@code Driver} object controls the program.
 * It holds the main method.
 * @author Seth Thurman
 * @version 1.0
 * Assignment: labw04
 *
 */

public class Driver {
/*
 * Starts and runs the program.
 * @param args[] array of arguments to supply to the runtime.
   @return type is nothing.

 */
  public static void main(String args[]) {
    Bank b = new Bank();
    
    Account acc = new Account(7777, 78.30, 3.15,true, 3159);
    Associate ass = new Associate(3432, "Seth", "Thurman", "fake@site.com", "username", "1234", 9999, "Friend of Bank");
    
    Manager man = new Manager(3945, "Someone", "else","fake@site2.com", "manager" ,"pass", 111, 2222, "Manager of Nowhere");

    Customer c = new Customer(7777, "New", "Customer", "cus@site2.com", "customer", "23232", 4444);


    b.addAccount(acc);
    b.addUser(ass);
    b.addUser(man);
    b.addUser(c);
    System.out.println(b.toString());
    
  }
}
