package ProductLine;

public enum ItemType {
  AUDIO ("AU"),
  VISUAL ("VI"),
  AUDIOMOBILE ("AM"),
  VISUALMOBILE ("VM");

  private final String type;

  ItemType(String type) {
    this.type = type;
  }

  protected String getType() {
    return type;
  }
}




