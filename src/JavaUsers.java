
/**
 * @author David Rose
 */
import java.util.Scanner;

public class JavaUsers extends Person {

  private int successfulCompiles;

  /**
   * <p>Creates a new instance for Java specific users.</p>
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
   *          is the amount of successful compiles the Java user has
   * @throws VanSelowException
   *          if user inputed incorrect data
   */
  public JavaUsers(String n, String g, int r, double time, Scanner sc, int i) 
        throws VanSelowException {
    super(n, g, r, time, sc);
    this.successfulCompiles = i;
  }

  public int getSuccessfulCompiles() {
    return this.successfulCompiles;
  }

  public void setSuccessfulCompiles(int successfulCompiles) {
    this.successfulCompiles = successfulCompiles;
  }

}
