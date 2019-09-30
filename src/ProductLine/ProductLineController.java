//analyze --> inspect
//must not find suspicious code
/**
 * This class represents the controller component. It responds to action events and user stimuli at
 * the GUI layer and handles requests appropriately.
 *
 * @author Ryan Yerge
 */
package ProductLine;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Class inherits from DatabaseOrg class to allow access to instance methods and fields.
 */
public class ProductLineController extends DatabaseOrg {

  /**
   * TextField objects created to represent user input when a product is added to the database.
   */
  @FXML
  private TextField prodName;
  @FXML
  private TextField manufacturer;
  @FXML
  private TextField itemType;

  /**
   * Event handler for when the "Add Products" button is pressed by the user.
   *
   * @param event This is the event object created when "Add Product" is pressed.
   * @throws SQLException Exception thrown when database fails to connect.
   */
  @FXML
  protected void handleAddProductButtonAction(ActionEvent event) throws SQLException {
    DatabaseOrg db = new DatabaseOrg();
    db.insertData(prodName.getText(), manufacturer.getText(),
        itemType.getText());
  }

  /**
   * Method is to be defined at a later point. When the "Record Production" button is pressed, it
   * prints to the console.
   *
   * @param event This is the event object created when "Record Production" is pressed by the user.
   */
  @FXML
  protected void handleRecordProdButtonAction(ActionEvent event) {
    System.out.println("Record Production button pressed.");
  }

}


