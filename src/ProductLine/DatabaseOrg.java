package ProductLine;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class organizes the database instance methods. This is the "model" component of the MVC.
 *
 * @author Ryan Yerge
 */

class DatabaseOrg {

  /**
   * TableColumn object created to manipulate the existing products pane in GUI.
   * <p>
   * JDBC Connection object to establish connection to the H2 database.
   */
  private Connection conn;
  private Statement stmt;
  private PreparedStatement insertStmt;
  private ObservableList<Product> productLine = FXCollections.observableArrayList();
  private ArrayList<ProductionRecord> productionRun = new ArrayList<>();
  private int indexOffset = 1;
  private int lengthOffset = 0;
  private String reverse = "";

  /**
   * Default constructor called when "Add Product" is clicked by user. It will call the initializeDb
   * method.
   */

  protected DatabaseOrg() {
    try {
      initializeDb();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Connection to database is initialized. Driver type and database URL defined as Strings to be
   * passed to DriverManager. User name and password defined as Strings to be passed to
   * DriverManager.
   */

  protected void initializeDb() throws SQLException {

    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/res/ProductionDB";
    final String USER = "";
    final String PASS;

    try {
      Properties prop = new Properties();
      prop.load(new FileInputStream("./res/res/properties"));
      PASS = reverseString(prop.getProperty("password"));

      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Data to be inserted into database is passed. Translates into SQL logic. SQL INSERT statement
   * includes data entered by user at GUI level.
   *
   * @param prodName     This is the name of the product being added.
   * @param manufacturer This is the manufacturer of the product being added.
   * @param itemType     This is the type of item being added.
   * @throws SQLException If product fails to be added, an exception is thrown.
   */

  protected void insertData(String prodName, String itemType, String manufacturer)
      throws SQLException {

    final String sql =
        "INSERT INTO PRODUCT (NAME, TYPE, MANUFACTURER) VALUES (?, ?, ?)";

    try {

       insertStmt = conn.prepareStatement(sql);
      insertStmt.setString(1, prodName);
      insertStmt.setString(2, itemType);
      insertStmt.setString(3, manufacturer);
      insertStmt.executeUpdate();
      insertStmt.closeOnCompletion();
    } catch (Exception ex) {
      throw new RuntimeException((ex));
    } finally {
      conn.close();
    }
  }

  /**
   * This method is called when the initialize() method loads from the ProductLineController. It
   * returns an ObservableList containing Products currently existing in the database, and it
   * returns the product list to be reflected at the GUI level.
   *
   * @return ObservableList containing existing Products in the database.
   * @throws SQLException Throws exception if error occurs while accessing PRODUCT table.
   */

  protected ObservableList<Product> loadProductList() throws SQLException {

    final String sql = "SELECT * FROM PRODUCT";
    stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    ItemType type = null;

    while (rs.next()) {
      Integer ID = rs.getInt(1);
      String productName = rs.getString(2);
      String itemType = rs.getString(3);
      String manufacturer = rs.getString(4);
      if (itemType.equalsIgnoreCase("audio") || itemType.equalsIgnoreCase("AU")) {
        type = ItemType.AUDIO;
      }
      if (itemType.equalsIgnoreCase("VI")) {
        type = ItemType.VISUAL;
      }
      if (itemType.equalsIgnoreCase("AM")) {
        type = ItemType.AUDIO_MOBILE;
      }
      if (itemType.equalsIgnoreCase("VM")) {
        type = ItemType.VISUAL_MOBILE;
      }

      productLine.add(new Widget(productName, manufacturer, type, ID));
    }
    return productLine;
  }

  /**
   * The item recorded for production creates a ProductionRecord object and inserts the data to be
   * inserted into PRODUCTIONRECORD table in the db.
   *
   * @param prodNum   This is the product's number.
   * @param prodID    This is the product's ID number.
   * @param serialNum This is the serial number generated.
   * @param date      this is the Date object time-stamping the date and time of production.
   * @throws SQLException Throws exception if error occurs while inserting into db.
   */

  protected void insertRecord(int prodNum, int prodID, String serialNum, Date date)
      throws SQLException {

    final String sql =
        "INSERT INTO PRODUCTIONRECORD (PRODUCTION_NUM, PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED) VALUES (?, ?, ?, ?)";

    try {

      insertStmt = conn.prepareStatement(sql);
      Timestamp ts = new Timestamp(date.getTime());
      insertStmt.setInt(1, prodNum);
      insertStmt.setInt(2, prodID);
      insertStmt.setString(3, serialNum);
      insertStmt.setTimestamp(4, ts);
      insertStmt.executeUpdate();

      insertStmt.close();
    } catch (RuntimeException ex) {
      ex.printStackTrace();
    } finally {
      conn.close();
    }
  }

  /**
   * This method is called from the initialize() method and each time a quantity of products is
   * selected at the GUI level and record for production.
   *
   * @return returns an ArrayList of all the ProductionRecords in the db.
   * @throws SQLException Throws exception if error occurs while selecting from PRODUCTIONRECORD
   *                      table.
   */

  protected ArrayList<ProductionRecord> loadProductionLog() throws SQLException {

    final String sql = "SELECT * FROM PRODUCTIONRECORD";
    stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
      Integer prodNum = rs.getInt(1);
      Integer ID = rs.getInt(2);
      String serialNum = rs.getString(3);
      Timestamp date = rs.getTimestamp(4);
      Date dateProd = new Date(date.getTime());

      productionRun.add(new ProductionRecord(prodNum, ID, serialNum, dateProd));
    }
    return productionRun;
  }

  /**
   * This method decrypts the stored password and returns it to establish the connection to the
   * database.
   *
   * @param pw This is the stored password that is currently encrypted.
   * @return The decrypted String "pw" is passed back to the db password field.
   */

  private String reverseString(String pw) {
    if (indexOffset > pw.length()) {
      return reverse;
    } else {
      if (indexOffset == 1) {
        reverse += pw.substring(pw.length() - indexOffset);
        indexOffset++;
        return reverseString(pw);
      } else {
        reverse += pw.substring(pw.length() - indexOffset, (pw.length() - 1) - lengthOffset);
        indexOffset++;
        lengthOffset++;
        return reverseString(pw);
      }
    }
  }
}
