package ProductLine;

/**
 * This class interfaces the methods to be used by all classes.
 *
 * @author Ryan Yerge
 */

public interface Item {

  int getID();

  void setName(String name);

  String getName();

  void setManufacturer(String manufacturer);

  String getManufacturer();
}
