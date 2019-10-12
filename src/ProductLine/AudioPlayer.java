package ProductLine;

public class AudioPlayer extends Product implements MultimediaControl {

  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  AudioPlayer(String name, String manufacturer, String supportedAudioFormats, String supportedPlaylistFormats) {
    super(name, manufacturer, "AU");
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  @Override
  public void play() {
    System.out.println("Playing.");
  }

  @Override
  public void stop() {
    System.out.println("Stopping.");
  }

  @Override
  public void previous() {
    System.out.println("Previous.");
  }

  @Override
  public void next() {
    System.out.println("Next.");
  }

  public String toString() {
    return super.toString() + "\nSupported Audio Formats: " + supportedAudioFormats +
        "\nSupported Playlist Formats: " + supportedPlaylistFormats;
  }

}
