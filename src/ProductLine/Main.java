/**
 * This is the Main class. The application begins here and loads .fxml sources and JavaFX scene
 * begins.
 *
 * @author Ryan Yerge
 */
package ProductLine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Production Line");
    Scene scene = new Scene(root, 300, 275);
    primaryStage.setScene(scene);
    scene.getStylesheets().add(Main.class.getResource("ProductLine.css").toExternalForm());
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
