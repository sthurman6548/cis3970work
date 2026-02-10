package bank;


import java.util.ArrayList;

import accounts.Account;
import users.User;

/**
 * A {@code Bank} object represents a Bank.
 * The Bank has two ArrayLists one for storing all of the Users and one for storing the Accounts
 * Assignment: labW04
 * @author Seth Thurman
 * @version 1.0
 * 
 */
public class  Bank {
private ArrayList<User> users;
private ArrayList<Account> accounts;
  
/**
 * instantiates a new Bank;
 * @return instantiated Bank object
 */
  public Bank() {
    users = new ArrayList<User>();
    accounts = new ArrayList<Account>();
  }
  
  /**
 * Retrieves an ArrayList of the users of the Bank object
 * @return ArrayList<User> ArrayList of users of the Bank object
 */
  public ArrayList<User> getUsers() {
    return users; 
  }
  
 /**
 * sets a custom ArrayList of the users of the Bank
 * @param nUsers custom ArrayList of users for the Bank object
 */
  
  public void setUsers(ArrayList<User> nUsers) {
    this.users = nUsers; 
  }
  
  /**
 * Retrieves all of the accounts in the Bank
 * @return ArrayList<Account> ArrayList of accounts in the Bank
 */
  public  ArrayList<Account> getAccounts() {
    return accounts; 
  }
  
  /**
 * Sets custom ArrayList of accounts in the Bank
 * 
 * @param nAccount ArrayList of accounts for the Bank
 */
  public void setAccounts(ArrayList<Account> nAccount) {
    this.accounts =  nAccount; 
  }
  
  /**
 * Adds an account to the Bank
 * @param acc account to add to the Bank
 */
  public void addAccount(Account acc) {
    this.accounts.add(acc);
  }

  /**
 * Adds a user to the Bank
 * @param user User to add to the Bank
 */
  public void addUser(User user) {
    this.users.add(user);
  }
  
  /**
 * Removes account from the Bank
 * @param acc Account to remove
 */
  public void removeAccount(Account acc) {
    for(Account account : accounts) {
      if(account.equals(acc)) {
        accounts.remove(account);
      }
    }
  }

  /**
   * Removes User from the Bank
   * @param usr User to remove
   */
  public void removeUser(User usr) {
    for(User u : users){
      if(u.equals(usr)){
        users.remove(u);
      }
    }
  }


 
  /**
 * @param acc
 * @return
 */
  public boolean searchAccounts(Account acc) {
    for(Account account : accounts) {
      if(account.equals(acc)) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * searches for User
   * @param user value to search for
   * @return boolean true if present; false if not
   */
  public boolean searchUsers(User usr) {
    for(User u : users) {
      if(u.equals(usr)){
        return true;
      }
    }
    return false;
  }

  /**
   *  Returns a string of the Bank info formatted in record-style 
   * @return String record-style formatted string 
   */
  @Override
  public String toString(){
    return String.format("Bank{Accounts='%s', Users='%s'}", accounts.toString(), users.toString());
  }
  

 
}
