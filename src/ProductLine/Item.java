/**
 * This class interfaces the methods to be used by all classes.
 *
 * @author Ryan Yerge
 */

package ProductLine;

public interface Item {

  public int getID();

  public void setName(String name);

  public String getName();

  public void setManufacturer(String manufacturer);

  public String getManufacturer();
}
