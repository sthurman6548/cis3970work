package security;

/**
 * A {@code employeeCredential} object extends the Credential class and
 * represents a employee's credentials.
 * The fields for this class are the mostly same as Credential, except for the
 * addition of an int authorization code, so {@see security.Credential}.
 * 
 * Assignment: labW04
 * 
 * @author Seth Thurman
 * @version 1.0
 * 
 */
public class EmployeeCredential extends Credential {

  private int authCode;

  /**
   * @param username
   * @param password
   * @param pin
   * @param authCode
   */
  public EmployeeCredential(String username, String password, int pin, int authCode) {
    super(username, password, pin);
    this.authCode = authCode;
  }

  /**
   * Retrieves the EmployeeCredential's username
   * 
   * @return username EmployeeCredential.username
   */
  public String getUsername() {
    return super.getUsername();
  }

  /**
   * sets the EmployeeCredential username to the parameter
   * 
   * @param name value to assign to username
   */
  public void setUsername(String name) {
    super.setUsername(name);
  }

  /**
   * Retrieves the CEmployeeredential's password
   * 
   * @return password EmployeeCredential's password
   */
  public String getPassword() {
    return super.getPassword();
  }

  /**
   * sets the EmployeeCredential password to value of parameter
   * 
   * @param pass value to assign to password
   */
  public void setPassword(String pass) {
    super.setPassword(pass);
  }

  /**
   * sets the EmployeeCredential pin to value of parameter
   * 
   * @param pin value to assign to pin
   */
  public void setPin(int pin) {
    super.setPin(pin);
  }

  /**
   * Retrieves the EmployeeCredential's pin
   * 
   * @return password EmployeeCredential's pin
   */
  public int getPin() {
    return super.getPin();
  }

  /**
   * Retrieves the EmployeeCredential's AuthCode
   * 
   * @return password EmployeeCredential's AuthCode
   */
  public int getAuthCode() {
    return this.authCode;
  }

  /**
   * sets the EmployeeCredential authCode to value of parameter
   * 
   * @param code value to assign to authCode
   */
  public void setAuthCode(int code) {
    this.authCode = code;
  }

  /**
   * Returns a string of the EmployeeCredential info formatted in record-style
   * 
   * @return String record-style formatted string
   */
  @Override
  public String toString() {
    return String.format("EmployeeCredential[username= '%s', password='%s', pin= '%d' , authCode= '%d' ]",
        super.getUsername(), super.getPassword(), super.getPin(), this.authCode);
  }

  /**
   * Returns boolean based on equality of two objects
   * 
   * @param obj used to compare equality to current EmployeeCredential object
   * @return boolean that determines if obj parameter is equal to this
   */
  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj))
      ;
    EmployeeCredential emCred = (EmployeeCredential) obj;
    return (emCred.authCode == this.authCode);
  }

  /**
   * performs a deep clone of the EmployeeCredential object
   * 
   * @returns EmployeeCredential result of the cloning operation
   * @throws CloneNotSupportedException thrown if cloning fails
   *
   */
  @Override
  public EmployeeCredential clone() throws CloneNotSupportedException {
    EmployeeCredential cloned = (EmployeeCredential) super.clone();
    return cloned;
  }

  /**
   * returns hashCode of EmployeeCredential object
   * 
   * @return result value of hash computation
   */
  @Override
  public int hashCode() {
    int hash = super.hashCode();
    return 17 * hash + authCode;
  }

}
