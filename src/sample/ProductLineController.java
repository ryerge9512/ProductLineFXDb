//analyze --> inspect
//must not find suspicious code

package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

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
}


