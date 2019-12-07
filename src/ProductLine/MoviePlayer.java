package ProductLine;

/**
 * This class defines fields and methods for various movie players to be manufactured. Inherits from
 * the abstract Product class and implements the MultimediaControl interface.
 *
 * @author Ryan Yerge
 */


public class MoviePlayer extends Product implements MultimediaControl {

  /**
   * Defines two String fields for different screen and monitor types supported by the instantiated
   * MoviePlayer object.
   */

  private Screen screen;
  private Enum monitorType;

  /**
   * Constructor for MoviePlayer object that calls the parent class constructor and assigns its
   * fields.
   *
   * @param name         is passed and sent to parent constructor.
   * @param manufacturer is passed and sent to parent constructor.
   * @param screen       is passed and assigned to the screen field.
   * @param monitorType  is passed and assigned to the monitorType field.
   */

  public MoviePlayer(String name, String manufacturer, Screen screen, Enum
      monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  /**
   * Hypothetical method to exhibit the MoviePlayers's play() functionality.
   */

  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  /**
   * Hypothetical method to exhibit the MoviePlayers's stop() functionality.
   */

  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  /**
   * Hypothetical method to exhibit the MoviePlayers's previous() functionality.
   */

  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

  /**
   * Hypothetical method to exhibit the MoviePlayers's next() functionality.
   */

  @Override
  public void next() {
    System.out.println("Next movie");
  }

  /**
   * MoviePlayer's toString() method to display its fields.
   *
   * @return a String displaying MoviePlayer's fields.
   */

  public String toString() {
    return super.toString() + "\n" + screen + "\nMonitor Type: " +
        monitorType;
  }
}
