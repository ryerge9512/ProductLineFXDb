package ProductLine;

/**
 * This interface specifies accessor methods to be used by all movie players.
 * <p>
 * author: Ryan Yerge
 */


public interface ScreenSpec {

  String getResolution();

  int getRefreshRate();

  int getResponseTime();

}
