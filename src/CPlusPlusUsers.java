
/**
 * @author David Rose
 */
import java.util.Scanner;

public class CPlusPlusUsers extends Person {
  // the class Person is the base class to three classes in this program. Each
  // subclass is
  // an extension of the class Person, forming a two level class heicarchy.
  private int successfulZerosReturned;

  /**
   * <p> Creates a new instance for C++ specific users.</p>
   * 
   * @param n
   *          is Person's name
   * @param g
   *          is Person's gender
   * @param r
   *          is Person's rank
   * @param time
   *          is Person's time
   * @param sc
   *          is the Scanner object
   * @param i
   *          is the amount of successful 0s returned from running the main method
   *          the C++ user has
   * @throws VanSelowException
   *          if user inputed incorrect data
   */
  public CPlusPlusUsers(String n, String g, int r, double time, Scanner sc, int i) 
        throws VanSelowException {
    super(n, g, r, time, sc);
    this.successfulZerosReturned = i;
  }

  public int getSuccessfulCompiles() {
    return this.successfulZerosReturned;
  }

  public void setSuccessfulCompiles(int successfulCompiles) {
    this.successfulZerosReturned = successfulCompiles;
  }
}
