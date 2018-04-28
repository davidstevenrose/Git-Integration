
/**
 * @author David Rose
 */
import java.lang.reflect.Method;

public class MyStrings {
  /**
   * <p>Inverts the order of characters in a string.</p>
   * @param s
   *        is the String to invert.
   */
  public static void invertString(String s) {
    char[] charInv = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      System.out.print(charInv[s.length() - 1 - i]);
    }
    System.out.println(" ");
    System.out.println("Done!");
  }
  
  /**
   * <p>A method that checks if a String is a palindrome.</p>
   * @param s
   *        is the passed String
   * @return
   *        true if the String is a palindrome, false otherwise
   */
  public static boolean checkPalindrome(String s) {
    if (s.length() == 0 || s.length() == 1) {
      return true;
    } else if (s.charAt(0) == s.charAt(s.length() - 1)) {
      return checkPalindrome(s.substring(1, s.length() - 1));
    }
    return false;
  }

  /**
   * <p>A generic function that prints the values of any array type.</p>
   * 
   * @param a
   *          is the passed array
   */
  public static <E> void printGeneric(E[] a) {
    for (E ar : a) {
      String classType = ar.getClass().getName();
      if (classType.equals("Person")) {
        Method[] methods = ar.getClass().getDeclaredMethods();
        System.out.println(methods[4]);
      } else {
        System.out.println(ar);
      }
    }
  }
}