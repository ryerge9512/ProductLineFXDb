/**
 * This class interfaces the hypothetical methods to be used by all media players,
 * whether audio or visual.
 *
 * @author Ryan Yerge
 */

package ProductLine;

public interface MultimediaControl {
  public void play();
  public void stop();
  public void previous();
  public void next();

}
