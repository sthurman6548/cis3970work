package accounts;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * An {@code Account} object represents an actual Bank account.
 * Uses an int for the account number and the owner's Id, doubles for the
 * balance and apy,
 * a boolean for overdraft protection, and an ArrayList of Integers to hold user
 * Ids of users with access to the account.
 * Assignment: labW04
 * 
 * @author Seth Thurman
 * @version 1.0
 * 
 */
public class Account implements Cloneable, Comparator<Account> {
  private int number;
  private double balance;
  private double apy;
  private boolean overdraftProtect;
  private int ownerID;
  /** userIDs represents IDs of users who have access to the account */
  public ArrayList<Integer> userIDs;

  /**
   * Returns an instantiated Account
   * 
   * @param number            account number
   * @param balance           the account balance
   * @param apy               the apy of the account
   * @param oDraft_Protection Whether overdraft protection is enabled or not
   * @param ownerID           ID of the owner of the Account
   * @return Account the instantiated Account
   */
  public Account(int number, double balance, double apy,
      boolean oDraft_Protection, int ownerID) {
    this.number = number;
    this.balance = balance;
    this.apy = apy;
    this.overdraftProtect = oDraft_Protection;
    this.ownerID = ownerID;
    this.userIDs = new ArrayList<Integer>();

  }

  /**
   * Returns an instantiated Account
   * 
   * @param number  account number
   * @param balance the account balance
   * @param apy     the apy of the account
   * @param ownerID ID of the owner of the Account
   * @param uID     ArrayList of IDs of users who have access to the account
   * @return Account the instantiated Account
   */
  public Account(int number, double balance, double apy, int ownerID, ArrayList<Integer> uID) {
    this.number = number;
    this.balance = balance;
    this.apy = apy;
    this.overdraftProtect = false;
    this.ownerID = ownerID;
    this.userIDs = uID;

  }

  /**
   * Retrieves the Account's number
   * 
   * @return number Account number
   */
  public int getNumber() {
    return this.number;
  }

  /**
   * sets the account number to value of parameter
   * 
   * @param num value to assign to num
   */
  public void setNumber(int num) {
    this.number = num;
  }

  /**
   * Retrieves the Account's balance
   * 
   * @return balance the Account balance
   */
  public double getBalance() {
    return this.balance;
  }

  /**
   * Sets the account balance to the value of the parameter
   * 
   * @param balance value to assign to account.balance
   */
  public void setBalance(double balance) {
    if (balance < 0) {
      throw new IllegalArgumentException();
    }
    this.balance = balance;
  }

  /**
   * Retrieves the value of the Account's apy
   * 
   * @return apy the current value of the Account's apy
   */
  public double getAPY() {
    return this.apy;
  }

  /**
   * Sets the account's apy to the value of the parameter
   * 
   * @param apy value to assign to account.apy
   *
   */
  public void setAPY(double apy) {
    if (apy < 0) {
      throw new IllegalArgumentException();
    }
    this.apy = apy;
  }

  /**
   * Retrieves the state of the parameter that monitors overdraft protection
   * 
   * @return overdraftProtect whether the Account has overdraft
   */
  public boolean getOverdraftProtection() {
    return this.overdraftProtect;
  }

  /**
   * sets the state of the overdraft protection parameter
   * 
   * @param protection value to set the state of the overdraftProtect field
   */
  public void setOverdraftProtect(boolean protection) {
    this.overdraftProtect = protection;
  }

  /**
   * sets the id of the Owner of the Account
   * 
   * @param id the value of the Owners id
   */
  public void setOwnerID(int id) {
    this.ownerID = id;
  }

  /**
   * retrieves the id of the owner of the Account
   * 
   * @return ownerID the Id of the owner of the Account
   */
  public int getOwnerID() {

    return this.ownerID;
  }

  /**
   * retrieves the ArrayList containing the IDs of Account users
   * 
   * @return userIDs ArrayList containing the IDs of Account users
   */
  public ArrayList<Integer> getUserID() {
    return userIDs;
  }

  /**
   * sets an ArrayList of uids for users who have access to the Account
   * 
   * @param uids custom ArrayList of IDs of Account users
   */
  public void setUserID(ArrayList<Integer> uids) {
    this.userIDs = uids;
  }

  /**
   * 
   * @param amount
   */
  public void deposit(double amount) {
    if (amount < 0) {
      throw new IllegalArgumentException();
    }

    this.balance += amount;
  }

  /**
   * Withdraws money from account
   * 
   * @param amount that is going to be withdrawn
   * @throws Exception thrown if account is overdrawn or amount is < 0
   */
  public void withdraw(double amount) throws Exception {
    if (amount < 0) {
      throw new IllegalArgumentException();
    }

    if (!this.overdraftProtect) {
      if ((this.balance - amount) < 0) {
        throw new Exception("Withdraw amount exceeds funds. Disable overdraft protection to withdraw.");
      }
    }
    this.balance -= amount;
  }

  /**
   * Calculates the interest using the apy
   * 
   */
  public void interest() {
    this.balance = (this.apy / 12) * this.balance;
  }

  /**
   * Adds a new user to the account
   * 
   * @param id added to list of Account Users
   */
  public void addID(int id) {
    this.userIDs.add(id);
  }

  /**
   * searches based on user ID
   * 
   * @param id value to search for
   * @return id of user or -1 if user id not found
   */
  public int searchID(int id) {
    for (int uid : this.userIDs) {
      if (uid == id) {
        return uid;
      }
    }
    return -1;
  }

  /**
   * Removes User from ArrayList of allowed users
   * 
   * @param id used to delete User from ArrayList
   */
  public void deleteID(int id) {
    this.userIDs.remove(id);
  }

  /**
   * Returns a string of the Account info formatted in record-style
   * 
   * @return String record-style formatted string
   */
  @Override
  public String toString() {
    return String.format(
        "Account[number= '%d', balance='%.2f', APY='%.2f', Overdraft Protection='%b', Owner ID='%d', User IDs= '%s' ]",
        this.number, this.balance, this.apy, this.overdraftProtect, this.ownerID, this.userIDs.toString());

  }

  /**
   * Returns boolean based on equality of two objects
   * 
   * @param obj used to compare equality to current Account object
   * @return boolean that determines if obj parameter is equal to this
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }

    Account acc = (Account) obj;

    return acc.number == this.number;
  }

  /**
   * returns hashCode of Account object
   * 
   * @return result value of hash computation
   */
  @Override
  public int hashCode() {
    int result = 31;

    result = 17 * result + this.number;

    return result;
  }

  /**
   * performs a deep clone of the Account object
   * 
   * @returns Account result of the cloning operation
   * @throws CloneNotSupportedException thrown if cloning fails
   *
   */
  @Override
  public Account clone() throws CloneNotSupportedException {
    Account clonedAcc = (Account) super.clone();
    clonedAcc.userIDs = new ArrayList<>();

    for (int uid : this.userIDs) {
      clonedAcc.userIDs.add(uid);
    }

    return clonedAcc;
  }

  /**
   * Compares two Account objects based on Account number
   * 
   * @param f first Account to compare
   * @param s second Account to compare
   * @return int 0 if equal; 1 if greater than; and -1 if less than
   */
  @Override
  public int compare(Account f, Account s) {
    if ((f != null) && (s != null)) {
      int compareAccNum = Integer.compare(f.number, s.number);
      if (compareAccNum != 0) {
        return compareAccNum;
      }
    }
    return 0;
  }

}
