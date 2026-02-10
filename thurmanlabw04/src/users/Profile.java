package users;


import java.util.Comparator;

/**
 * A {@code Profile} object and represents a user's profile.
 * The fields for this class are all Strings for the first name, last name, and email address. 
 * 
 * Assignment: labW04
 * @author Seth Thurman
 * @version 1.0
 * 
 */
public class Profile implements Cloneable, Comparator<Profile> {
  private int id;
  private String firstName;
  private String lastName;
  private String emailAddr;

  /**
 * Instantiates new Profile 
 * @param id
 * @param first
 * @param last
 * @param email
 * @return instantiate Profile
 */
  public Profile (int id, String first, String last, String email){
    this.id = id;
    this.firstName = first;
    this.lastName = last;
    this.emailAddr = email;
  }

  /**
   * sets custom id using parameter value  
   * @param id custom id
   */
  public void setID(int id) {
    this.id = id;
  }

  /**
   * Retrieves the profile's Id
   * @return id profile's id
   */
  public int getID() {
    return this.id;
  }

  /**
   * sets custom first name using parameter value  
   * @param name custom first name
   */public void setFirstName(String name) {
    this.firstName = name;
  }

  /**
   * Retrieves the profile's first name
   * @return firstName profile's first name
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * sets custom last name using parameter value  
   * @param name custom last name
   */
  public void setLastName(String name) {
    this.lastName = name;
  }


  /**
 * Retrieves the profile's last name
 * @return lastName profile's last name
 */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * sets custom email address using parameter value  
   * @param e custom emailAddr
   */
  public void setEmailAddress(String e) {
    this.emailAddr = e; 
  }

  /**
 * Retrieves the profile's email address
 * @return emailAddr profile's email address
 */
  public String getEmailAddress() {
      return this.emailAddr; 
  }
  
  /**
   *  Returns a string of the Profile info formatted in record-style 
   * @return String record-style formatted string 
   */
  @Override
  public String toString() {
    return String.format("Profile{id='%d', firstName='%s', lastName='%s', emailAddr='%s'}", this.id, this.firstName, this.lastName, this.emailAddr);
  }

  /**
   * Returns boolean based on equality of two objects
   * @param obj used to compare equality to current Profile object
   * @return boolean that determines if obj parameter is equal to this
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj){
      return true;
    }

    
    if (obj == null || this.getClass() != obj.getClass()) { return false; }   
    Profile p = (Profile) obj;
    
    return (this.id == p.id);
  }
  
  /**
   * returns hashCode of Profile object
   * @return result value of hash computation
   */
  @Override
  public int hashCode() {
   int result = 31;
    result = 17 * result + id;
    result = 17 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 17 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 17 * result+ (emailAddr != null ? emailAddr.hashCode() : 0);

    return result;
  }

  /**
   * performs a deep clone of the Profile object
   * @returns Profile result of the cloning operation
   * @throws CloneNotSupportedException thrown if cloning fails 
   *
   */
  @Override 
  public Profile clone() throws CloneNotSupportedException {
    Profile clonedProfile = (Profile) super.clone();
    return clonedProfile;
  }

 /**
 * Compares two Profile objects based on first and last name
 * @param f first Profile to compare
 * @param s second Profile to compare
 * @return int 0 if equal; 1 if greater than; and -1 if less than
 */
  @Override 
  public int compare(Profile f, Profile s) {
    if((f != null) && (s != null)){
      int compareLName = f.lastName.compareTo(s.lastName); 
      if(compareLName != 0) {
        return compareLName;
      }
      int compareFName = f.firstName.compareTo(s.lastName);
			if (compareFName != 0) {
				return compareFName;
			}
    }
    return 0;

  }

 
}
