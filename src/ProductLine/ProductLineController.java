//analyze --> inspect
//must not find suspicious code
/**
 * This class represents the controller component. It responds to action events and user stimuli at
 * the GUI layer and handles requests appropriately.
 *
 * @author Ryan Yerge
 */
package ProductLine;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


/**
 * Class inherits from DatabaseOrg class to allow access to instance methods and fields.
 */
public class ProductLineController extends DatabaseOrg implements Initializable  {

  /**
   * TextField objects created to represent user input when a product is added to the database.
   */
  @FXML
  private TextField prodName;
  @FXML
  private TextField manufacturer;
  @FXML
  private TextField itemType;
  @FXML
  ComboBox<String> quantity;

 private ObservableList<String> options = FXCollections.observableArrayList("1",
      "2", "3", "4", "5", "6", "7", "8", "9", "10"
  );


  /**
   * Event handler for when the "Add Products" button is pressed by the user.
   *
   * @param event This is the event object created when "Add Product" is pressed.
   * @throws SQLException Exception thrown when database fails to connect.
   */
  @FXML
  protected void handleAddProductButtonAction(ActionEvent event) throws SQLException {
    DatabaseOrg db = new DatabaseOrg();
    db.insertData("" + prodName.getText(), "" + itemType.getText(),
        "" + manufacturer.getText());

    prodName.clear();
    itemType.clear();
    manufacturer.clear();
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


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    quantity.setItems(options);
  }
}


