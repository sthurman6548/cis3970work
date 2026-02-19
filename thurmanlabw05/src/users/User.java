package users;

import security.Credential;

import java.util.Comparator;

/**
 * A {@code user} object represents a bank user.
 * The fields for this class are a Credential and a Profile
 * 
 * Assignment: labW04
 * 
 * @author Seth Thurman
 * @version 1.0
 * 
 */
public class User implements Cloneable, Comparator<User> {
  Credential cred;
  Profile profile;

  /**
   * instantiates User
   * 
   * @param id
   * @param fName
   * @param lName
   * @param email
   * @param uname
   * @param password
   * @param pin
   * @return instantiated User
   */
  public User(int id, String fName, String lName, String email, String uname, String password, int pin) {
    profile = new Profile(id, fName, lName, email);
    cred = new Credential(uname, password, pin);
  }

  /**
   * Retrieves Profile
   * 
   * @return profile user's profile
   */
  public Profile getProfile() {
    return profile;
  }

  /**
   * Retrieves Credential
   * 
   * @return cred user's Credential
   */
  public Credential getCred() {
    return cred;
  }

  /**
   * sets custom profile using parameter value
   * 
   * @param p custom profile
   */
  public void setProfile(Profile p) {
    this.profile = p;
  }

  /**
   * sets custom credential using parameter value
   * 
   * @param c custom credential
   */
  public void setCred(Credential c) {
    this.cred = c;
  }

  /**
   * Returns a string of the User info formatted in record-style
   * 
   * @return String record-style formatted string
   */
  @Override
  public String toString() {
    return String.format("User=[profile='%s', credential'%s']", profile.toString(), cred.toString());

  }

  /**
   * Returns boolean based on equality of two objects
   * 
   * @param obj used to compare equality to current User object
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
    User u = (User) obj;

    return (u.cred.equals(this.cred) && u.profile.equals(u.profile));

  }

  /**
   * returns hashCode of User object
   * 
   * @return result value of hash computation
   */
  @Override
  public int hashCode() {
    int result = 31;

    result = 17 * result + (this.profile != null ? this.profile.hashCode() : 0);
    result = 17 * result + (this.cred != null ? this.cred.hashCode() : 0);

    return result;

  }

  /**
   * performs a deep clone of the User object
   * 
   * @returns User result of the cloning operation
   * @throws CloneNotSupportedException thrown if cloning fails
   *
   */
  @Override
  public User clone() throws CloneNotSupportedException {
    User clonedUser = (User) super.clone();

    if (clonedUser != null) {
      clonedUser.profile = new Profile(this.profile.getID(), this.profile.getFirstName(), this.profile.getLastName(),
          this.profile.getEmailAddress());
      clonedUser.cred = new Credential(this.cred.getUsername(), this.cred.getPassword(), this.cred.getPin());
    }
    return clonedUser;
  }

  /**
   * Compares two User objects based on first and last name
   * 
   * @param f first User to compare
   * @param s second User to compare
   * @return int 0 if equal; 1 if greater than; and -1 if less than
   */
  @Override
  public int compare(User f, User s) {
    return this.profile.compare(f.getProfile(), s.getProfile());

  }

}
