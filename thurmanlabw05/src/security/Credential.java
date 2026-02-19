package security;

/**
 * A {@code Credential} object represents the credentials a user has to allow
 * access to the Bank.
 * Uses String username and password as well as an int pin for the credentials
 * Assignment: labW04
 * 
 * @author Seth Thurman
 * @version 1.0
 * 
 */
public class Credential implements Cloneable {
 private String username;
 private String password;
 private int pin;

 /**
  * instantiates new Credential
  * 
  * @param name     username
  * @param password users password
  * @param pin      users pin
  * @return instantiated Credential
  */
 public Credential(String name, String password, int pin) {
  this.username = name;
  this.password = password;
  this.pin = pin;
 }

 /**
  * sets the Credential username to the parameter
  * 
  * @param name value to assign to username
  */
 public void setUsername(String name) {
  this.username = name;
 }

 /**
  * Retrieves the Credential's username
  * 
  * @return username Credential.username
  */
 public String getUsername() {
  return this.username;
 }

 /**
  * sets the Credential password to value of parameter
  * 
  * @param pass value to assign to password
  */
 public void setPassword(String pass) {
  this.password = pass;

 }

 /**
  * Retrieves the Credential's password
  * 
  * @return password Credentials password
  */
 public String getPassword() {
  return this.password;
 }

 /**
  * sets the Credential pin to value of parameter
  * 
  * @param pin value to assign to pin
  */
 public void setPin(int pin) {
  this.pin = pin;

 }

 /**
  * Retrieves the Credential's pin
  * 
  * @return pin Credential's pin
  */
 public int getPin() {
  return this.pin;
 }

 /**
  * Returns a string of the Credential info formatted in record-style
  * 
  * @return String record-style formatted string
  */
 @Override
 public String toString() {
  return String.format("Credential[username= '%s', password='%s', pin= '%d' ]", this.username, this.password, this.pin);
 }

 /**
  * Returns boolean based on equality of two objects
  * 
  * @param obj used to compare equality to current Credential object
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
  Credential cred = (Credential) obj;

  return (cred.username.equals(this.username) && cred.password.equals(this.password)
    && cred.pin == this.pin);
 }

 /**
  * returns hashCode of Credential object
  * 
  * @return result value of hash computation
  */
 @Override
 public int hashCode() {
  int result = 31;

  result = 17 * result + (username != null ? username.hashCode() : 0);
  result = 17 * result + (password != null ? password.hashCode() : 0);
  result = 17 * result + pin;

  return result;
 }

 /**
  * performs a deep clone of the Credential object
  * 
  * @returns Credential result of the cloning operation
  * @throws CloneNotSupportedException thrown if cloning fails
  *
  */
 @Override
 public Credential clone() throws CloneNotSupportedException {
  Credential clonedCred = (Credential) super.clone();

  return clonedCred;
 }
}
