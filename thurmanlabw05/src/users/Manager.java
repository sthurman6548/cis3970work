package users;


import security.Credential;

/**
 * A {@code Manager object extends the Employee class and represents a manager of the bank.
 * A int is added to the parameters as a passkey for the vault, for the other parameters {@see users.Employee}. 
 * 
 * Assignment: labW04
 * @author Seth Thurman
 * @version 1.0
 * 
 */
public class Manager extends Employee implements Cloneable {
  private int vaultPin;

  /**
 * instantiates new Manager
 * @param id
 * @param fName
 * @param lName
 * @param email
 * @param uname
 * @param password
 * @param pin
 * @param vaultPass
 * @param title
 * @return instantiated Manager
 */
 public Manager(int id, String fName, String lName, String email, String uname, String password, int pin, int vaultPass, String title) {
  super(id, fName, lName, email, uname, password, pin, title);  
  this.vaultPin = vaultPass;
 }
  
 /**
  * Retrieves Credential
  * @return cred Manager's Credential
  */
  public Credential getCredential() {
    return super.getCred();
  }

  /**
   * Retrieves Profile
   * @return profile manager's profile
   */ 
  public Profile getProfile () {
    return super.getProfile();
  }

 
  /**
   * sets custom profile using parameter value  
   * @param p custom profile
   */
  public void setProfile(Profile p) {
     super.setProfile(p);
  }
 
  /**
   * sets custom credential using parameter value
   * @param c custom credential
   */
  public void setCredential(Credential c) {
     super.setCredential(c);
  }
  
  /**
   * Retrieves the Manager's title
   * @return title Manager's title
   */
  public String getTitle() {
    return super.getTitle();
  }

  /**
   * sets value of title field
   * @param t title to use as value
   */
  public void setTitle(String t) {
    super.setTitle(t);
  }
  
  /**
   * Retrieves value of vaultPin
   * @return vaultPin
   */
  public int  getVaultPin() {
    return this.vaultPin;
  }

  /**
   * sets value of vaultPin field
   * @param pin vaultPin to use as value
   */
  public void setVaultPin(int pin) {
    this.vaultPin = pin;
  }
  
  /**
   * Returns boolean based on equality of two objects
   * @param obj used to compare equality to current Manager object
   * @return boolean that determines if obj parameter is equal to this
   */
  @Override
  public boolean equals(Object obj) {
    if(!super.equals(obj)) {
      return false;
    }
    Manager m = (Manager) obj;

    return (m.vaultPin == this.vaultPin) ;
  }

  /**
   * returns hashCode of Manager object
   * @return result value of hash computation
   */
  public int hashCode() {
    var hash =  super.hashCode();
        hash = 17 * hash + vaultPin;
    return hash;
  }

  /**
   *  Returns a string of the Manager info formatted in record-style 
   * @return String record-style formatted string 
   */
  @Override
  public String toString() { 
    return String.format("Manager=[profile='%s', credential='%s', title='%s', vaultPin='%d']", this.getProfile().toString(), this.getCredential().toString(), this.getTitle(), this.vaultPin);
  }



  /**
   * performs a deep clone of the Manager object
   * @returns Manager result of the cloning operation
   * @throws CloneNotSupportedException thrown if cloning fails 
   *
   */
  @Override
  public Manager clone() throws CloneNotSupportedException {
    return (Manager) super.clone();
    
  }
  
  /**
   * Compares two Manager objects based on first and last name
   * @param f first Manager to compare
   * @param s second Manager to compare
   * @return int 0 if equal; 1 if greater than; and -1 if less than
   */
  public int compare(Manager f, Manager s) {
    return super.compare(f,s);
  }
}
