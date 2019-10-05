package ProductLine;

/**
 * This class creates enum codes for different item types entered into the database.
 *
 * @author Ryan Yerge
 */

public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  private final String type;

  ItemType(String type) {
    this.type = type;
  }

  protected String getType() {
    return type;
  }
}




