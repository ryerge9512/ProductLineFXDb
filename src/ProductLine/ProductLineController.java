//analyze --> inspect
//must not find suspicious code

package ProductLine;


import javafx.scene.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class ProductLineController extends DatabaseOrg {

  @FXML
  private TextField prodName;
  @FXML
  private TextField manufacturer;
  @FXML
  private TextField itemType;

  private DatabaseOrg db;


  @FXML
  protected void handleAddProductButtonAction(ActionEvent event) {

    System.out.println(prodName.getText() + " " + manufacturer.getText() + " " + itemType.getText());
    // DatabaseOrg db = new DatabaseOrg(prodName, manufacturer, itemType);

  }

  @FXML
  protected void handleRecordProdButtonAction(ActionEvent event) {
    System.out.println("Record Production button pressed.");
  }


}


