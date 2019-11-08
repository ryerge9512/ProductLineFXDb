/**
 * This is the Main class. The application begins here and loads .fxml sources and JavaFX scene
 * begins.
 *
 * @author Ryan Yerge
 */
package ProductLine;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("ProdTabForm.fxml"));
    primaryStage.setTitle("Production Line");
    Scene scene = new Scene(root, 300, 275);
    primaryStage.setScene(scene);
    scene.getStylesheets().add(Main.class.getResource("ProductLine.css").toExternalForm());
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
    //testMultimedia();
  }


  public static void testMultimedia() {
    AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
        "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    Screen newScreen = new Screen("720x480", 40, 22);
    MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
        MonitorType.LCD);
    ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();
    productList.add(newAudioProduct);
    productList.add(newMovieProduct);
    for (MultimediaControl p : productList) {
      System.out.println(p);
      p.play();
      p.stop();
      p.next();
      p.previous();
    }
  }
}


