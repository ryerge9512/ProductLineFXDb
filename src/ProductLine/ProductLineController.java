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

  @FXML
  protected void handleAddProductButtonAction(ActionEvent event) {
    DatabaseOrg db = new DatabaseOrg();
    db.insertData(prodName.getText(), manufacturer.getText(),
        itemType.getText());
  }

  @FXML
  protected void handleRecordProdButtonAction(ActionEvent event) {
    System.out.println("Record Production button pressed.");
  }

}


