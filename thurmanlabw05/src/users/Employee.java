package users;

import security.Credential;

/**
 * A {@code Employee} object extends the User class and represents the bank
 * employees.
 * It has the same fields as a User so {@see users.User}, however it also adds a
 * String for the title;
 * 
 * Assignment: labW04
 * 
 * @author Seth Thurman
 * @version 1.0
 * 
 */

public class Employee extends User implements Cloneable {
  private String title;

  /**
   * Instantiates new Employee
   * 
   * @param id
   * @param fName
   * @param lName
   * @param uname
   * @param email
   * @param password
   * @param pin
   * @param title
   * @return instantiated Employee
   */
  public Employee(int id, String fName, String lName, String uname, String email, String password, int pin,
      String title) {
    super(id, fName, lName, uname, email, password, pin);
    this.title = title;
  }

  /**
   * Retrieves Credential
   * 
   * @return cred Employee's Credential
   */
  public Credential getCredential() {
    return super.getCred();
  }

  /**
   * Retrieves Profile
   * 
   * @return profile employee's profile
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
   * Retrieves the Employee's title
   * 
   * @return title Employee's title
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * sets value of title field
   * 
   * @param t title to use as value
   */
  public void setTitle(String t) {
    this.title = t;
  }

  /**
   * Returns boolean based on equality of two objects
   * 
   * @param obj used to compare equality to current Employee object
   * @return boolean that determines if obj parameter is equal to this
   */
  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj)) {
      return false;
    }
    Employee e = (Employee) obj;

    return (e.title.equals(this.title));
  }

  /**
   * returns hashCode of Employee object
   * 
   * @return result value of hash computation
   */
  public int hashCode() {
    int hash = super.hashCode();
    hash = 17 * hash + (title != null ? title.hashCode() : 0);
    return hash;
  }

  /**
   * Returns a string of the Employee info formatted in record-style
   * 
   * @return String record-style formatted string
   */
  @Override
  public String toString() {
    return String.format("Employee=[profile='%s', credential'%s', title='%s']", this.getProfile().toString(),
        this.getCredential().toString());
  }

  /**
   * performs a deep clone of the Employee object
   * 
   * @returns Employee result of the cloning operation
   * @throws CloneNotSupportedException thrown if cloning fails
   *
   */
  @Override
  public Employee clone() throws CloneNotSupportedException {
    return (Employee) super.clone();

  }

  /**
   * Compares two Employee objects based on first and last name
   * 
   * @param f first Employee to compare
   * @param s second Employee to compare
   * @return int 0 if equal; 1 if greater than; and -1 if less than
   */
  public int compare(Employee f, Employee s) {
    return super.compare(f, s);
  }

}
