/**
 *This class will define and display all of the characteristics for all
 * movie players.
 *
 * author: Ryan Yerge
 */

package ProductLine;

public class Screen implements ScreenSpec {

  private String resolution;
  private int refreshRate;
  private int responseTime;

  /**
   * This constructor accepts three arugments for each of the fields
   * declared in this class.
   *
   * @param resolution will set the resolution of the screen.
   * @param refreshRate will set the refresh rate of the screen.
   * @param responseTime will set the response time of the screen.
   */

  public Screen(String resolution, int refreshRate, int responseTime){
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  /**
   * Getter method for the resolution field.
   * @return returns resolution field.
   */

  @Override
  public String getResolution() {
    return resolution;
  }

  /**
   * Getter method for refreshRate field.
   * @return returns refreshRate field.
   */

  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  /**
   * Getter method for responseTime field.
   * @return returns responseTime field.
   */

  @Override
  public int getResponseTime() {
    return responseTime;
  }

  /**
   * Overrides toString() method to display information about Screen object.
   * @return returns String containing fields relevant to object of interest.
   */

  public String toString() {
    return "Screen:\nResolution: " + resolution + "\nRefresh rate: " + refreshRate +
        "\nResponse time: " + responseTime;
  }
}
