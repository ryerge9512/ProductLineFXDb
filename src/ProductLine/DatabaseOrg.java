/**
 * This class organizes the database instance methods. This is the "model" component of the MVC.
 *
 * @author Ryan Yerge
 */

package ProductLine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class DatabaseOrg {

  /**
   * TableColumn object created to manipulate the
   * existing products pane in GUI.
   *
   * JDBC Connection object to establish
   * connection to the H2 database.
   */
  @FXML
  TableColumn existingProducts;
  Connection conn;

  /**
   *Default constructor called when "Add Product" is clicked
   * by user. It will call the initializeDb method.
   */
  protected DatabaseOrg() {
    initializeDb();
  }

  /**
   * Connection to database is initialized
   */
  protected void initializeDb() {
    /**
     * Driver type and database URL defined as Strings to
     * be passed to DriverManager.
     */
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/res/ProductionDB";
    /**
     * User name and password defined as Strings to be passed
     * to DriverManager.
     */
    final String USER = "";
    final String PASS = "";

    try {

      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Data to be inserted into database is passed.
   * Translates into SQL logic.
   *
   * @param prodName This is the name of the product being added.
   * @param manufacturer This is the manufacturer of the product being added.
   * @param itemType This is the type of item being added.
   * @throws SQLException If product fails to be added, an exception is thrown.
   */
  protected void insertData(String prodName, String manufacturer, String itemType)
      throws SQLException {
    /**
     * SQL INSERT statement includes data entered by user at GUI layer.
     */
    final String sql =
        "INSERT INTO PRODUCT (NAME, TYPE, MANUFACTURER) values (" + prodName + ", " + manufacturer + ", "
        + itemType + ")";

    try {

      PreparedStatement insertStmt = conn.prepareStatement(sql);
      ResultSetMetaData showData = insertStmt.getMetaData();

      int numberOfColumns = showData.getColumnCount();

      for (int i = 1; i <= numberOfColumns; i++) {
        existingProducts.getTableView().getItems().add(showData);
      }
      insertStmt.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      conn.close();
    }
  }
}
