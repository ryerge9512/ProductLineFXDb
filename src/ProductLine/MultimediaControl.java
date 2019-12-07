package ProductLine;

/**
 * This class interfaces the hypothetical methods to be used by all media players, whether audio or
 * visual.
 *
 * @author Ryan Yerge
 */

public interface MultimediaControl {

  void play();

  void stop();

  void previous();

  void next();

}
