/**<p>Original class that performed calculations.</p>
 * @author David Rose * 
 * 
 * @deprecated replaced with class MyCalculations
 */
public class Calculations {

  static int base = 0;
  static int power = 0;
  static double answer = 0;

  /**
   * <p>method that asks for user input for b and p.</p>
   * 
   * @return answer to b^p
   */
  public static double exp() {
    System.out.println("What is your base?");
    int b = Main.sc.nextInt();
    System.out.println("What is your power?");
    int p = Main.sc.nextInt();
    double answer = Math.pow((double) b, (double) p);
    return answer;
  }

  /**
   * <p>asks user for two variables and performs four basic functions.</p>
   * 
   * @return integers converted to strings
   */
  public static String doFourFunc() {
    System.out.println("What is your first number?");
    int a = Main.sc.nextInt();
    System.out.println("What is your second number?");
    int b = Main.sc.nextInt();
    String a1 = Integer.toString(a + b); // add
    String a2 = Integer.toString(a - b); // subtract
    String a3 = Integer.toString(a * b); // multiply
    String a4 = Integer.toString(a / b); // divide
    String a5 = Integer.toString(a % b); // remainder
    String toReturn = "The sum of your numbers is " + a1 
        + "; the difference of your numbers is " + a2
        + "; the product of your numbers is " + a3 
        + "; the quotient of your numbers is " + a4 + " R " + a5;
    return toReturn;
  }

}
