package users;

import security.Credential;

/**
 * An {@code Associate} class extends the Employee class and represents an
 * associate employee
 * It also contains all of the same fields.
 * Therefore {@see users.Employee}
 * 
 * Assignment: labW04
 * 
 * @author Seth Thurman
 * @version 1.0
 * 
 */
public class Associate extends Employee implements Cloneable {

  /**
   * Instantiates new Associate
   * 
   * @param id
   * @param fName
   * @param lName
   * @param email
   * @param uname
   * @param password
   * @param pin
   * @param title
   * @return instantiated Associate
   */
  public Associate(int id, String fName, String lName, String email, String uname, String password, int pin,
      String title) {
    super(id, fName, lName, email, uname, password, pin, title);
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
   * @return profile Associate profile
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
   * Retrieves the Associate's title
   * 
   * @return title Associate's title
   */
  public String getTitle() {
    return super.getTitle();
  }

  /**
   * sets value of title field
   * 
   * @param t title to use as value
   */
  public void setTitle(String t) {
    super.setTitle(t);
  }

  /**
   * Returns boolean based on equality of two objects
   * 
   * @param obj used to compare equality to current Associate object
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
   * returns hashCode of Associate object
   * 
   * @return result value of hash computation
   */
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Returns a string of the Associate info formatted in record-style
   * 
   * @return String record-style formatted string
   */
  @Override
  public String toString() {
    return String.format("Associate=[profile='%s', credential='%s', title='%s']", this.getProfile().toString(),
        this.getCredential().toString(), this.getTitle());
  }

  /**
   * performs a deep clone of the Associate object
   * 
   * @returns Associate result of the cloning operation
   * @throws CloneNotSupportedException thrown if cloning fails
   *
   */
  @Override
  public Associate clone() throws CloneNotSupportedException {
    return (Associate) super.clone();

  }

  /**
   * Compares two Associate objects based on first and last name
   * 
   * @param f first Associate to compare
   * @param s second Associate to compare
   * @return int 0 if equal; 1 if greater than; and -1 if less than
   */
  public int compare(Associate f, Associate s) {
    return super.compare(f, s);
  }

}
