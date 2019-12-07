package ProductLine;

/**
 * This class defines the Employee instance fields and methods to verify that the user credentials
 * entered at the GUI level are valid.
 * <p>
 * author: Ryan Yerge
 */

public class Employee {

  /**
   * Defines fields for employee's full name, password, and the username and email generated from
   * the input.
   */

  private StringBuilder name;
  private String username;
  private String password;
  private String email;

  /**
   * This is the Employee constructor that is called when the user clicks the "Submit" button. An
   * Employee object is created and accepts parameters from the GUI to set the Employee object's
   * fields and check to see if the user's input was valid.
   *
   * @param name     is the user's full name and sent to checkName(String name);
   * @param password is the user's selected password and sent to isValidPassword(String password);
   */

  public Employee(String name, String password) {

    this.name = new StringBuilder(name);

    if (checkName(name)) {
      setUsername(name);
      setEmail(name);
    } else {
      username = "default";
      email = "user@oracleacademy.Test";
    }
    if (isValidPassword(password)) {
      this.password = password;
    } else {
      this.password = "pw";
    }
  }

  /**
   * This method is called from the constructor and tests the incoming String against the predefined
   * regex pattern. If returns true, the name field is set. If returns false, the username is
   * automatically set to "default."
   *
   * @param name User's full name submitted from the GUI level.
   * @return Returns Boolean to determine if submitted String is acceptable.
   */

  public boolean checkName(String name) {
    if (name.matches("[a-zA-Z]+ [a-zA-Z]+")) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * The method tests the user submitted password against the predefined regex pattern to ensure it
   * is valid. If true, the password field is set. If false, the password field defaults to "pw."
   *
   * @param password User's chosen password is submitted from the GUI level.
   * @return Returns Boolean to determine if submitted String is acceptable.
   */

  public boolean isValidPassword(String password) {
    if (password.matches("(?=.*[a-z])(?=.*[A-Z])(.+)")) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * If user's submitted name is accepted, this method is called to setup their username field. The
   * StringBuilder object accepts the parameter to alter the original String to lowercase and set
   * the username to the first initial and last name.
   *
   * @param n The user's name to be set to the username field.
   */

  public void setUsername(String n) {
    StringBuilder user = new StringBuilder(n.toLowerCase());

    for (int i = 0; i < user.length(); i++) {
      if (user.charAt(i) == ' ') {
        username = user.delete(1, i + 1).toString();
      }
    }
  }

  /**
   * If user's submitted name is accepted, this method is called to setup their email fied. The
   * Stringbuilder object accepts the parameter to alter the original String to lowercase and set
   * the email to the first name dot (.) the user's last name, followed by "@oracleacademy.Test."
   *
   * @param email The user's full name to be formatted as an email address.
   */

  public void setEmail(String email) {
    StringBuilder empEm = new StringBuilder(email.toLowerCase());
    for (int i = 0; i < empEm.length(); i++) {
      if (empEm.charAt(i) == ' ') {
        empEm.replace(i, i + 1, ".");
        empEm.insert(empEm.length(), "@oracleacademy.Test");
        this.email = empEm.toString();
      }
    }
  }

  /**
   * Employee object's toString() method that displays the results of the user's input submitted at
   * the GUI level.
   *
   * @return A String is returned containing the Employee's fields.
   */

  public String toString() {
    return "Employee Details\nName: " + name + "\nUsername: " + username
        + "\nEmail: " + email + "\nInitial Password: " + password;
  }
}
