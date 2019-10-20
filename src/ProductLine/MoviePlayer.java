package ProductLine;

public class MoviePlayer extends Product implements MultimediaControl {

  private Screen screen;
  private Enum monitorType;

  public MoviePlayer(String name, String manufacturer, Screen screen, Enum
      monitorType){
    super(name, manufacturer, "VISUAL");
    this.screen = screen;
    this.monitorType = monitorType;
  }

  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

  @Override
  public void next() {
    System.out.println("Next movie");
  }

  public String toString(){
    return super.toString() + "\n" + screen + "\nMonitor Type: " +
        monitorType;
  }
}
