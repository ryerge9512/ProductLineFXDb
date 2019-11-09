/**
 * This class creates constant enum codes for different item types entered into the database.
 *
 * @author Ryan Yerge
 */

package ProductLine;

public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  /**
   * Stores item type code in a String to be used for database insertion.
   */

  private final String type;

  /**
   * Constructor for ItemType that assigns its String value to the type field.
   *
   * @param type is passed and assigned to the ItemType's type field.
   */

  ItemType(String type) {
    this.type = type;
  }

  /**
   * Getter method for the ItemType's type field.
   *
   * @return ItemType's type field.
   */

  protected String getType() {
    return type;
  }
}




