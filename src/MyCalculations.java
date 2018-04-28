
/**
 * @author David Rose
 * <p>Apparently, <em>Lambda Expressions</em> are helpful treating
 *  functionality as a method argument, such as an event listener 
 *  method where the first argument is "click" and the second argument is the
 *  entire function itself, the event.</p>
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyCalculations implements MyInterface {

  static int base = 0;
  static int power = 0;
  static double answer = 0;

  /**
   * <p> A method that compares two numbers and returns an Integer.</p>
   * 
   * @param a
   *          is the first number to compare
   * 
   * @param b
   *          is the number parameter a is being compared to
   * 
   * @return returns 1 if parameter a is greater than parameter b returns -1 if
   *         parameter a is less than than parameter b returns 0 if parameter a is
   *         equal to parameter b
   * 
   */
  public static int compareTo(int a, int b) {
    if (a > b) {
      return 1;
    } else if (a == b) {
      return 0;
    }
    return -1;
  }
  // This method is implemented from MyInterface because the Object class has
  // an
  // equivalent method signature.
  // the interface allows polymorphism because this method is taken from the
  // interface rather than from the
  // superclass.

  /**
   * <p> A method that asks for user input for b and p for a power.</p>
   * 
   * @return answer to b^p
   */
  public static double exp() {
    try {
      System.out.println("What is your base?");
      double b = Main.sc.nextDouble();
      System.out.println("What is your power?");
      double p = Main.sc.nextDouble();
      double answer = Math.pow(b, p);
      return answer;
    } catch (InputMismatchException e) {
      System.out.println("You entered bad input. Please try again.");
      return exp();
    }
  }

  /**
   * <p> Asks user for two variables and returns four basic functions.</p>
   * 
   * @return integers converted to strings
   */
  public static String doFourFunc() {
    try {
      System.out.println("What is your first number?");
      int a = Main.sc.nextInt();
      System.out.println("What is your second number?");
      int b = Main.sc.nextInt();
      String a1 = Integer.toString(a + b); // add
      String a2 = Integer.toString(a - b); // subtract
      String a3 = Integer.toString(a * b); // multiply
      String a4 = Integer.toString(a / b); // divide
      String a5 = Integer.toString(a % b); // remainder
      String result = "The sum of your numbers is " + a1 + "; the difference of your numbers is "
          + a2 + "; the product of your numbers is " + a3 + "; the quotient of your numbers is "
          + a4 + " R " + a5;
      return result;
    } catch (InputMismatchException e) {
      System.out.println("You entered bad input. Please try again.");
      return doFourFunc();
    }
  }

  /**
   * <p> A method that stores integers in an ArrayList and prints the elements in the
   * array.</p>
   */
  public static void doArrayList() {
    System.out.println(
        "type the number of elements you desire, then type the numbers on each seperate line");
    int n = Main.sc.nextInt();
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      arr.add(i, Main.sc.nextInt());
    }
    System.out.println("The elements in your list are: ");
    for (Integer a : arr) {
      System.out.print(a);
      System.out.println(" ");
    }
  }

  /**
   * <p>A generic method that prints the elements in the passed array of any type.</p>
   * 
   * @param arr
   *          is the generic type array.
   */
  public static <E> void doArrayList(E[] arr) {
    System.out.println("The elements in your list are: ");
    for (E a : arr) {
      System.out.print(a);
      System.out.println(" ");
    }
  }

  /**
   * <p> Puts a desired number of elements of people and the number of pencils they
   * have and prints out data of pencil ownership.</p>
   * 
   * @param sc
   *          is the passed scanner object
   */
  public static void makeHashTable(Scanner sc) {
    Hashtable<Integer, String> tableNames = new Hashtable<Integer, String>();
    Hashtable<Integer, Integer> tableData = new Hashtable<Integer, Integer>();
    System.out
        .println("How many people and respective pencil amount ownership do you wish to record?");
    int index = sc.nextInt();
    System.out
        .println("Type the first name of the person and the amount of pencils each person owns.");
    try {
      for (int i = 0; i < index; i++) {
        tableNames.put(i, sc.next());
        tableData.put(i, sc.nextInt());
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      System.out.println("You might have entered bad input. Please try again.");
      try {
        Main.mainMenuFunction("hashmap");
      } catch (VanSelowException e1) {
        System.out.println("Error, returning to main menu. " + e.getMessage());
        Main.getMainMenu(false);
      }
    }
    System.out.println(tableNames + " " + tableData);
    while (index-- > 0) {
      System.out.println(tableNames.get(index) + "=" + tableData.get(index));
    }
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Uh Oh! " + tableNames.get(index + 1) + " Broke all of his/her "
        + tableData.get(index + 1) + " pencils. Entry removed");
    tableNames.remove(index + 1);
    tableData.remove(index + 1);
    System.out.println(tableNames + " " + tableData);
  }

  /**
   * <p>Sorting algorithm coined the "Van Sort" that creates a new array of sorted
   * values and inserted values are added to the sorted array and pushed up until
   * the added value becomes greater than the next value.</p>
   * 
   * @param arr
   *          is the passed array of integers
   * @return the sorted array of integers
   */
  public static int[] vanSort(int[] arr) {
    int[] sortted = new int[arr.length];
    sortted[0] = arr[0];
    int sortiPlus1;
    int j;
    for (int i = 1; i < arr.length; i++) {
      if (compareTo(arr[i], sortted[i - 1]) == -1) {
        sortiPlus1 = sortted[i - 1];
        sortted[i - 1] = arr[i];
        sortted[i] = sortiPlus1;
        j = 1;
        while ((i - j - 1) >= 0 && compareTo(sortted[i - j], sortted[i - j - 1]) == -1) {
          sortiPlus1 = sortted[i - j - 1];
          sortted[i - j - 1] = sortted[i - j];
          sortted[i - j] = sortiPlus1;
          j++;
        }
      } else {
        sortted[i] = arr[i];
      }
    }
    return sortted;
  }

  /**
   * <p>Prints the local time on the console.</p>
   */
  public static void showLocalTime() {
    System.out.printf("Today is: %s%n local time.%n", LocalDateTime.now());
  }
}
