//analyze --> inspect
//must not find suspicious code

package ProductLine;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ProductLineController {

  /*
  @FXML
  private String prodName;
  @FXML
  private String manufacturer;
  @FXML
  private String itemType;

   */


  @FXML
  protected void handleAddProductButtonAction(ActionEvent event) {
    System.out.println("Add Product button pressed.");
  }

  @FXML
  protected void handleRecordProdButtonAction(ActionEvent event) {
    System.out.println("Record Production button pressed.");
  }
}


