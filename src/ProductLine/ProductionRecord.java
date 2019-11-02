package ProductLine;

import java.util.Date;

public class ProductionRecord {

  private int productionNumber;
  private int productId;
  private String serialNumber;
  private Date dateProduced;
  private static int prodDigits = 0;

  public ProductionRecord(int productId) {
    this.productId = productId;
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  public ProductionRecord(Product item, int count) {
    String manuf = item.getManufacturer().substring(0, 3);
    String type = item.getItemType().getType();
    String number = String.format("%05d", prodDigits);
    serialNumber = manuf + type + number;
    prodDigits++;
    dateProduced = new Date();
  }

  public ProductionRecord(int productionNumber, int productId, String serialNumber,
      Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productId = productId;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  public int getProductionNumber() {
    return productionNumber;
  }

  public void setProductionNumber(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public Date getDateProduced() {
    return dateProduced;
  }

  public void setDateProduced(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  public String toString() {
    return "Prod. Num: " + productionNumber + " Product ID: " + productId +
        " Serial Num: " + serialNumber + " Date: " + dateProduced;
  }
}
