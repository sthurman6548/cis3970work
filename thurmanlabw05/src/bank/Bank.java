package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;
import accounts.Account;
import users.User;

/**
 * A {@code Bank} object represents a Bank.
 * The Bank has two ArrayLists one for storing all of the Users and one for
 * storing the Accounts
 * Assignment: labW04
 * 
 * @author Seth Thurman
 * @version 1.0
 * 
 */
public class Bank {
  private HashMap<Integer, Account> acc;
  private HashMap<Integer, User> usr;

  /**
   * instantiates a new Bank;
   * 
   * @return instantiated Bank object
   */
  public Bank() {
    acc = new HashMap<Integer, Account>();
    usr = new HashMap<Integer, User>();
  }

  /**
   * Retrieves a Collection of the users of the Bank object
   * 
   * @return Collection<User> ArrayList of users of the Bank object
   */
  public Collection<User> getUsers() {
    return usr.values();
  }

  /**
   * sets a custom hashmap of the users of the bank
   * 
   * @param nusers custom hashmap of users for the bank object
   */

  public void setUser(HashMap<Integer, User> u) {
    this.usr = u;
  }

  /**
   * sets a custom hashmap of the accounts of the bank
   * 
   * @param nusers custom hashmap of accounts for the bank object
   */

  public void setAccount(HashMap<Integer, Account> a) {
    this.acc = a;
  }

  /**
   * Retrieves all of the accounts in the Bank
   * 
   * @return Collection<Account> Collection of accounts in the Bank
   */
  public Collection<Account> getAccounts() {
    return acc.values();
  }

  /**
   * Adds an account to the Bank
   * 
   * @param acc account to add to the Bank
   */
  public void addAccount(Account acc) {
    this.acc.put(acc.getNumber(), acc);

  }

  /**
   * Adds a user to the Bank
   * 
   * @param user User to add to the Bank
   */
  public void addUser(User user) {
    this.usr.put(user.getProfile().getID(), user);
  }

  /**
   * Removes account from the Bank
   * 
   * @param acc Account to remove
   */
  public void removeAccount(Account acc) {
    this.acc.remove(acc.getNumber());
  }

  /**
   * Removes User from the Bank
   * 
   * @param usr User to remove
   */
  public void removeUser(User u) {
    usr.remove(u.getProfile().getID());
  }

  /**
   * @param acc
   * @return
   */
  public boolean searchAccounts(Account acc) {
    this.acc.containsValue(acc.getNumber());

    return false;
  }

  /**
   * searches for User
   * 
   * @param user value to search for
   * @return boolean true if present; false if not
   */
  public boolean searchUsers(User usr) {
    this.usr.containsValue(usr.getProfile().getID());

    return false;
  }

  /**
   * Returns a string of the Bank info formatted in record-style
   * 
   * @return String record-style formatted string
   */
  @Override
  public String toString() {
    return String.format("Bank[Accounts=%s, Users=%s]", acc.values().toString(), usr.toString());
  }
}
