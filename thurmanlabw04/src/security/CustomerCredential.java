package security;

/**
 * A {@code CustomerCredential} object extends the Credential class and represents a customer's credentials.
 * The fields for this class are the same as Credential so {@see security.Credential}. 
 * 
 * Assignment: labW04
 * @author Seth Thurman
 * @version 1.0
 * 
 */
public class CustomerCredential extends Credential implements Cloneable {


  /**
 * @param name
 * @param password
 * @param pin
 */
public CustomerCredential(String name, String password, int pin ) {
    super(name, password, pin);

  }

/**
 * Retrieves the CustomerCredential's username
 * @return username CustomerCredential.username
 */
  public String getUsername() {
    return super.getUsername();
  }
  
  /**
   * sets the CustomerCredential username to the  parameter
   * @param name value to assign to username
   */
  public void setUsername(String name) {
    super.setUsername(name);
  }

  /**
   * Retrieves the CustomerCredential's password
   * @return password CustomerCredential's password
   */
  public String getPassword() {
    return super.getPassword();
  }

  /**
   * sets the CustomerCredential password to value of parameter
   * @param pass value to assign to password
   */
  public void setPassword(String pass) {
    super.setPassword(pass);
  }
  
  /**
   * Retrieves the CustomerCredential's pin
   * @return password CustomerCredential's pin
   */
  public int getPin() {
    return super.getPin();
  }

  /**
   * sets the CustomerCredential pin to value of parameter
   * @param pin value to assign to pin
   */
  public void setPin(int pin) {
    super.setPin(pin);
  }

  /**
   *  Returns a string of the CustomerCredential info formatted in record-style 
   * @return String record-style formatted string 
   */
  @Override 
  public String toString() {
 
  return String.format("CustomerCredential{username= '%s', password='%s', pin= '%d' }", super.getUsername(), super.getPassword(), super.getPassword());
  }

  /**
   * Returns boolean based on equality of two objects
   * @param obj used to compare equality to current CustomerCredential object
   * @return boolean that determines if obj parameter is equal to this
   */
  @Override 
  public boolean equals(Object obj) {
     if(!super.equals(obj)) {return false;}

     return true;


  }

  /**
   * returns hashCode of CustomerCredential object
   * @return result value of hash computation
   */
@Override
  public int hashCode() {
    int hash = super.hashCode();
    return hash;
  }

/**
 * performs a deep clone of the CustomerCredential object
 * @returns CustomerCredential result of the cloning operation
 * @throws CloneNotSupportedException thrown if cloning fails 
 *
 */
@Override 
  public CustomerCredential clone() throws CloneNotSupportedException {
    CustomerCredential cloned = (CustomerCredential) super.clone(); 
    return cloned;   
  }


}


