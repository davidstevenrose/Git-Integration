
/**
 * @author David Rose
 */
import java.util.Scanner;

public class FortranZeroUsers extends Person {
  private int successfulHolesPunched;

  /**
   * <p> Creates a new instance for Fortran specific users.</p>
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
   *          is the amount of successful holes were punched the FORTRAN 0 user
   *          has
   * @throws VanSelowException
   *          if user inputed incorrect data
   */
  public FortranZeroUsers(String n, String g, int r, double time, Scanner sc, int i) 
        throws VanSelowException {
    super(n, g, r, time, sc);
    this.successfulHolesPunched = i;
    System.out.println(this.getName() + " has punched this many holes in a card: "
        + this.successfulHolesPunched);
  }

  public int getSuccessfulHolesPunched() {
    return this.successfulHolesPunched;
  }

  public void setSuccessfulHolesPunched(int successfulCompiles) {
    this.successfulHolesPunched = successfulCompiles;
  }
  
  /**
   * <p>Prints the amount of classes in class FortranZeroUsers.</p>
   */
  @Override
  public void printClassMethodCount() {
    int i = Person.class.getDeclaredMethods().length;
    System.out.println("There are " + i + " methods in the Person class.");
  }
}
// an Override annotation will override a method in a subclass where that
// method's
// signature was declared in the subclass's super class.