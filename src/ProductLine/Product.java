/**
 * This class inherits from Product and implements the methods implemented by the Item interface.
 *
 * @author Ryan Yerge
 */

package ProductLine;

public abstract class Product implements Item {

  /**
   * Fields defined for each Product like its ID number, the Enum type of item, its manufacturer,
   * its name and a string to hold the Enum's string field.
   */

  private Integer ID;
  private ItemType type;
  private String manufacturer;
  private String name;
  private String itemType;

  /**
   * Constructor for each Product object and assigns its fields from passed parameters.
   *
   * @param name         is passed and assigned to the Product's name field.
   * @param manufacturer is passed and assigned to the Product's manufacturer field.
   * @param type         is the Enum object passed to allow access to its fields and assign to the
   *                     itemType field.
   */

  Product(String name, String manufacturer, ItemType type, Integer id) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
    itemType = type.getType();
    ID = id;
  }

  Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
    itemType = type.getType();
  }

  /**
   * Getter method for the Product's id field.
   *
   * @return the Product's id field.
   */

  @Override
  public int getId() {
    return ID;
  }

  /**
   * Getter method for the Product's type field.
   *
   * @return the Product's type field.
   */

  public ItemType getItemType() {
    return type;
  }

  /**
   * Mutator method for the Product's name field.
   *
   * @param name is passed and assigned to the Product's name field.
   */

  @Override
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter method for the Product's name field.
   *
   * @return the Product's name field.
   */

  @Override
  public String getName() {
    return name;
  }

  /**
   * Mutator method for the Product's manufacturer field.
   *
   * @param manufacturer is passed and assigned to the Product's manufacturer field.
   */

  @Override
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * Getter method for the Product's manufacturer field.
   *
   * @return the Product's manufacturer field.
   */

  @Override
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Product's toString() method to display its fields.
   *
   * @return a String displaying Product's fields.
   */

  public String toString() {
    return "Name: " + name + "\nManufacturer: " + manufacturer
        + "\nType: " + type;
  }
}

/**
 * Widget class to test Product/ItemType interface and allow abstract Product class to be
 * instantiated and stored in a collection.
 */

class Widget extends Product {

  Widget(String name, String manufacturer, ItemType type, Integer id) {
    super(name, manufacturer, type, id);
  }

  Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
}
