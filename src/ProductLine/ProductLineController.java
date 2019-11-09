//analyze --> inspect
//must not find suspicious code

package ProductLine;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This class represents the controller component of the MVC. It responds to action events and user stimuli at
 * the GUI layer and handles requests appropriately.
 * <p>
 * Class inherits from DatabaseOrg class to allow access to instance methods and fields.
 *
 * @author Ryan Yerge
 */

public class ProductLineController extends DatabaseOrg implements Initializable {

  /**
   * TextField objects created to represent user input when a product is added to the database.
   */

  @FXML
  private TextField prodName;
  @FXML
  private TextField manufacturer;
  @FXML
  private ChoiceBox<ItemType> itemType;
  @FXML
  private ComboBox<String> quantity;
  @FXML
  private TextArea prodLog;
  @FXML
  private TableView<Product> existingProducts;
  @FXML
  private TableColumn<Product, String> productName, manuf, typeOf;
  @FXML
  private ListView<Product> catalog;

  private ObservableList<Product> productLine = FXCollections.observableArrayList();

  private ObservableList<String> options = FXCollections.observableArrayList("1",
      "2", "3", "4", "5", "6", "7", "8", "9", "10"
  );

  /**
   * Event handler for when the "Add Products" button is pressed by the user. Desired product is
   * submitted to the database and setupProductLineTable() is called.
   *
   * @param event This is the event object created when "Add Product" is pressed.
   * @throws SQLException Exception thrown when database fails to connect.
   */

  @FXML
  protected void handleAddProductButtonAction(ActionEvent event) throws SQLException {
    DatabaseOrg db = new DatabaseOrg();
    db.insertData("" + prodName.getText(), "" + itemType.getValue().getType(),
        "" + manufacturer.getText());

    setupProductLineTable(
        new Widget(prodName.getText(), manufacturer.getText(), itemType.getValue()));

    prodName.clear();
    manufacturer.clear();
    itemType.getSelectionModel().clearSelection();
  }

  /**
   * Products added to database are shown in the "Produce" tab and allows the user to select
   * quantities of desired products to add to the "Production Log" tab.
   *
   * @param event This is the event object created when "Record Production" is pressed by the user.
   */

  @FXML
  protected void handleRecordProdButtonAction(ActionEvent event) {
    int amount = quantity.getSelectionModel().getSelectedIndex() + 1;

    prodLog.appendText(catalog.getSelectionModel().getSelectedItem().toString()
        + "\nQuantity: " + amount + "\n\n");

    quantity.getSelectionModel().selectFirst();
    catalog.getSelectionModel().clearSelection();
  }

  /**
   * Products added to the database when "Add Product" is clicked calls this method to set up the
   * TableView to reflect submission of items to the database. The item's toString() is called to
   * transpose item information to "Produce" tab for quantity selection.
   *
   * @param productInfo
   */

  public void setupProductLineTable(Product productInfo) {
    productLine.add(productInfo);
    productName.setCellValueFactory(new PropertyValueFactory("name"));
    typeOf.setCellValueFactory(new PropertyValueFactory("itemType"));
    manuf.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    existingProducts.setItems(productLine);
    catalog.setItems(productLine);
  }

  /**
   * The initialize() method is implemented from the Initialize interface. It initializes the
   * Quantity ComboBox in the Produce GUI tab to select values 1 - 10. It also initializes the
   * ChoiceBox in the Product Line tab  from the ItemType Enum class for the desired item type to be
   * inserted into the database. Production Log window is updated with items currently in DB.
   *
   * @param location
   * @param resources
   */

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    quantity.setItems(options);
    quantity.setEditable(true);
    quantity.getSelectionModel().selectFirst();

    itemType.getItems().setAll(ItemType.values());
    // ProductionRecord display = new ProductionRecord(0);
    //  prodLog.appendText(display.toString());
  }
}


