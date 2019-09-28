package ProductLine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.fxml.FXML;

public class DatabaseOrg {

  protected DatabaseOrg(){
    initializeDb();
  }

  // constructor for query submitted
  protected DatabaseOrg(String prodName, String manufacturer, String itemType) {
    initializeDb();

  }


  protected void initializeDb() {

    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/db";

    // database credentials
    final String USER = "";
    final String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    try {

      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();


    } catch (Exception ex) {
      ex.printStackTrace();
    }//end try catch
  }//end method initializeDB

}
