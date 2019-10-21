/**
 * This interface specifies accessor methods to be used by all movie players.
 *
 * @author: Ryan Yerge
 */

package ProductLine;

public interface ScreenSpec {
  public String getResolution();

  public int getRefreshRate();

  public int getResponseTime();

}
