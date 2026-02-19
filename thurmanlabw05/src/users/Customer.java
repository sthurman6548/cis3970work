package users;

import security.Credential;

/**
 * A {@code Customer} object extends the User class and represents a customer
 * user.
 * The fields for this class are the same as User so {@see users.Customer}.
 * 
 * Assignment: labW04
 * 
 * @author Seth Thurman
 * @version 1.0
 * 
 */

public class Customer extends User implements Cloneable {

  /**
   * Instantiates new Customer
   * 
   * @param id
   * @param fName
   * @param lName
   * @param email
   * @param uname
   * @param password
   * @param pin
   * @return instantiated Customer
   */
  public Customer(int id, String fName, String lName, String email, String uname, String password, int pin) {
    super(id, fName, lName, email, uname, password, pin);
  }

  /**
   * Retrieves Credential
   * 
   * @return cred Customer's Credential
   */
  public Credential getCredential() {
    return super.getCred();
  }

  /**
   * Retrieves Profile
   * 
   * @return profile customer's profile
   */
  public Profile getProfile() {
    return super.getProfile();
  }

  /**
   * sets custom profile using parameter value
   * 
   * @param p custom profile
   */
  public void setProfile(Profile p) {
    super.setProfile(p);

  }

  /**
   * sets custom credential using parameter value
   * 
   * @param c custom credential
   */
  public void setCredential(Credential c) {
    super.setCred(c);
  }

  /**
   * Returns boolean based on equality of two objects
   * 
   * @param obj used to compare equality to current Customer object
   * @return boolean that determines if obj parameter is equal to this
   */
  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj)) {
      return false;
    }

    return true;
  }

  /**
   * returns hashCode of Customer object
   * 
   * @return result value of hash computation
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Returns a string of the Customer info formatted in record-style
   * 
   * @return String record-style formatted string
   */
  @Override
  public String toString() {
    return String.format("Customer=[profile='%s', credential'%s']", profile.toString(), cred.toString());
  }

  /**
   * performs a deep clone of the Customer object
   * 
   * @returns Customer result of the cloning operation
   * @throws CloneNotSupportedException thrown if cloning fails
   *
   */
  @Override
  public Customer clone() throws CloneNotSupportedException {
    return (Customer) super.clone();
  }

  /**
   * Compares two Customer objects based on first and last name
   * 
   * @param f first Customer to compare
   * @param s second Customer to compare
   * @return int 0 if equal; 1 if greater than; and -1 if less than
   */
  public int compare(Customer f, Customer s) {
    return super.compare(f, s);
  }
}
