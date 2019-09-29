package ProductLine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class DatabaseOrg {

  @FXML
  TableColumn existingProducts;

  Connection conn;

  // default constructor
  protected DatabaseOrg() {
    initializeDb();
  }

  // INSERT constructor
  protected DatabaseOrg(String prodName, String manufacturer, String itemType) {
    initializeDb();
    insertData(prodName, manufacturer, itemType);
  }


  protected void initializeDb() {

    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/ProductionDB";

    // database credentials
    final String USER = "";
    final String PASS = "";

    try {

      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);


    } catch (Exception ex) {
      ex.printStackTrace();
    }//end try catch
  }//end method initializeDB


  protected void insertData(String prodName, String manufacturer, String itemType) {

    final String sql =
        "INSERT INTO Product (name, type, manufacturer) VALUES (" + prodName + ", " + itemType
            + ", " + manufacturer + ")";

    try {

      PreparedStatement insertStmt = conn.prepareStatement(sql);
      ResultSetMetaData showData = insertStmt.getMetaData();

      int numberOfColumns = showData.getColumnCount();

      for (int i = 1; i <= numberOfColumns; i++) {
        existingProducts.getTableView().getItems().add(showData);
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }//end try catch

  }

}
