/**
 * This class produces the ProductionRecord object with fields defined for the item's
 * productionNumber, productId, serialNumber, and the date the item was produced.
 *
 * @author Ryan Yerge
 */

package ProductLine;

import java.util.Date;

public class ProductionRecord {

  private int productionNumber;
  private int productId;
  private String serialNumber;
  private Date dateProduced;
  private static int prodDigits = 0;

  /**
   * ProductionRecord constructor that defaults the productionNumber and serialNumber to zero. It
   * accepts one parameter to assign the item's productId. Current date and time is logged through
   * Date object created.
   *
   * @param productId is passed and assigned while other fields are defaulted to zero.
   */

  public ProductionRecord(int productId) {
    this.productId = productId;
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  /**
   * ProductionRecord constructor that creates the item's serial number from concatenated fields.
   * The first (3) characters are the manufacturer, followed by the item type enum, and then a (5)
   * digit product number.
   *
   * @param item  is the Product object passed to access fields for serial number creation.
   */

  public ProductionRecord(Product item) {
      String manuf = item.getManufacturer().substring(0, 3);
      String type = item.getItemType().getType();
      String number = String.format("%05d", prodDigits);
      serialNumber = manuf + type + number;
      productId = item.getID();
      prodDigits++;
      dateProduced = new Date();

  }

  /**
   * This constructor for the ProductionRecord object accepts several parameters to assign to the
   * ProductionRecord's fields upon instantiation.
   *
   * @param productionNumber is passed and assigned to the ProductionRecord field productionNumber.
   * @param productId        is passed and assigned to the ProductionRecord field productionNumber.
   * @param serialNumber     is passed and assigned to the ProductionRecord field serialNumber.
   * @param dateProduced     is the Date object passed and assigned to the dateProduced field.
   */

  public ProductionRecord(int productionNumber, int productId, String serialNumber,
      Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productId = productId;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  /**
   * Getter method for the productionNumber field.
   *
   * @return ProductionRecord object returns its productionNumber.
   */

  public int getProductionNumber() {
    return productionNumber;
  }

  /**
   * Mutator method for the productionNumber field.
   *
   * @param productionNumber is passed and assigned to the ProductionRecord object's field.
   */

  public void setProductionNumber(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * Getter method for the productId field.
   *
   * @return ProductionRecord object returns its productId.
   */

  public int getProductId() {
    return productId;
  }

  /**
   * Mutator method for the productId field.
   *
   * @param productId is passed and assigned to the ProductionRecord object's field.
   */

  public void setProductId(int productId) {
    this.productId = productId;
  }

  /**
   * Getter method for the serialNumber field.
   *
   * @return ProductionRecord object returns its serialNumber.
   */

  public String getSerialNumber() {
    return serialNumber;
  }

  /**
   * Mutator method for the serialNumber field.
   *
   * @param serialNumber is passed and assigned to the ProductionRecord object's field.
   */

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * Getter method for the dateProduced field.
   *
   * @return ProductionRecord object returns its dateProduced.
   */

  public Date getDateProduced() {
    return dateProduced;
  }

  /**
   * Mutator method for the dateProduced field.
   *
   * @param dateProduced object is passed and assigned to the ProductionRecord object's field.
   */

  public void setDateProduced(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * ProductionRecord's toString() method to display its fields.
   *
   * @return a String displaying the RecordProduction object's fields.
   */

  public String toString() {
    return "Prod. Num: " + productionNumber + " Product ID: " + productId +
        " Serial Num: " + serialNumber + " Date: " + dateProduced;
  }
}
