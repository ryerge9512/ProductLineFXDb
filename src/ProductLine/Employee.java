package ProductLine;

public class Employee {

  private StringBuilder name;
  private String username;
  private String password;
  private String email;

  public Employee(String name, String password) {

    this.name = new StringBuilder(name);

    if(checkName(name)){
     setUsername(name);
     setEmail(name);
    }else{
      username = "default";
      email = "user@oracleacademy.Test";
    }
    if(isValidPassword(password)){
      this.password = password;
    }else{
      this.password = "pw";
    }
  }

  public boolean checkName(String name) {
    if (name.matches("[a-zA-Z]+ [a-zA-Z]+")) {
      return true;
    }else{
      return false;
    }
  }

  public boolean isValidPassword(String password) {
    if(password.matches("(?=.*[a-z])(?=.*[A-Z])(.+)"))
    {
      return true;
    }else{
      return false;
    }
  }

  public void setUsername(String n) {
    StringBuilder user = new StringBuilder(n.toLowerCase());

    for(int i = 0; i < user.length(); i++){
      if(user.charAt(i) == ' '){
       username = user.delete(1, i+1).toString();
      }
    }
  }

  public void setEmail(String email) {
    StringBuilder empEm = new StringBuilder(email.toLowerCase());
    for(int i = 0; i < empEm.length(); i++) {
      if(empEm.charAt(i) == ' ') {
        empEm.replace(i, i+1,".");
        empEm.insert(empEm.length(), "@oracleacademy.Test");
        this.email = empEm.toString();
      }
    }
  }

  public String toString() {
    return "Employee Details\nName: " + name + "\nUsername: " + username
        + "\nEmail: " + email + "\nInitial Password: " + password;
  }
}
