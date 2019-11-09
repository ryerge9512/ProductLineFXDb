/**
 * This class defines fields and methods for various audio players to be manufactured. Inherits from
 * the abstract Product class and implements the MultimediaControl interface.
 *
 * @author Ryan Yerge
 */

package ProductLine;

public class AudioPlayer extends Product implements MultimediaControl {

  /**
   * Defines two String fields for different audio and playlist formats
   * supported by the instantiated AudioPlayer object.
   */

  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  /**
   * Constructor for AudioPlayer object that calls the parent class constructor and assigns its
   * fields.
   *
   * @param name is passed and sent to the parent class constructor.
   * @param manufacturer is passed and sent to the parent class constructor.
   * @param supportedAudioFormats is passed and assigned to the supportedAudioFormats field.
   * @param supportedPlaylistFormats is passed and assigned to the supportedPlaylistFormats.
   */

  AudioPlayer(String name, String manufacturer, String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.AUDIO);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  /**
   * Hypothetical method to exhibit the AudioPlayer's play() functionality.
   */

  @Override
  public void play() {
    System.out.println("Playing.");
  }

  /**
   * Hypothetical method to exhibit the AudioPlayer's stop() functionality.
   */

  @Override
  public void stop() {
    System.out.println("Stopping.");
  }

  /**
   * Hypothetical method to exhibit the AudioPlayer's previous() functionality.
   */

  @Override
  public void previous() {
    System.out.println("Previous.");
  }

  /**
   * Hypothetical method to exhibit the AudioPlayer's next() functionality.
   */

  @Override
  public void next() {
    System.out.println("Next.");
  }

  /**
   * AudioPlayer's toString() method to display its fields.
   *
   * @return a String displaying AudioPlayer's fields.
   */

  public String toString() {
    return super.toString() + "\nSupported Audio Formats: " + supportedAudioFormats +
        "\nSupported Playlist Formats: " + supportedPlaylistFormats;
  }
}
