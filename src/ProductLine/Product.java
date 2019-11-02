package ProductLine;

/**
 * This class implements the methods contracted by the Item interface.
 *
 * @author Ryan Yerge
 */

public abstract class Product implements Item {

  private int id;
  private ItemType type;
  private String manufacturer;
  private String name;

  Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  @Override
  public int getId() {
    return id;
  }

  public ItemType getItemType() {
    return type;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  @Override
  public String getManufacturer() {
    return manufacturer;
  }

  public String toString() {
    return "Name: " + name + "\nManufacturer: " + manufacturer
        + "\nType: " + type;
  }
}

/**
 * Widget class to test Product/ItemType interface
 */


class Widget extends Product {

  Widget(String name, String manufacturer, ItemType type)
  {
    super(name, manufacturer, type);
  }
}
