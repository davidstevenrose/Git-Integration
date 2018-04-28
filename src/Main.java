
/**
 * @author David Rose
 */
//Started January 2018
/* abstract classes are used as bases and are never used in constructors*/

import java.util.Scanner;

public class Main {

  static String version = "in development";
  static Scanner sc = new Scanner(System.in);

  /**
   * <p>
   * The program will be redirected here after every method completion.
   * </p>
   * 
   * @param firstTime
   *          is the welcome screen indicator the welcome screen is only displayed
   *          once
   */
  public static void getMainMenu(boolean firstTime) {
    String mainMenuFunctionString;
    if (firstTime) {
      System.out.println("Version: " + version);
      String hed = String.format("%n%n=================%n%n");
      System.out.println(hed);
      System.out.println("Hello. What would you like to do? Type 'help' for a list of commands");
      System.out.println("For best results, use UTF-8 encoding!");
      System.out.println(hed);
      mainMenuFunctionString = sc.nextLine();
      try {
        mainMenuFunction(mainMenuFunctionString);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("What else would you like to do?");
      mainMenuFunctionString = sc.nextLine();
      try {
        mainMenuFunction(mainMenuFunctionString);
      } catch (Exception e) {
        System.out.println("Warning! An exception caught. Backlog code: VS.id");
      }
    }

  }

  /**
   * 
   * <p>
   * The list of commands accessed after getMainMenu(a).
   * </p>
   * 
   * @param s
   *          is the string command
   * @throws VanSelowException
   *           if user inputs an 'H' in char
   */
  public static void mainMenuFunction(String s) throws VanSelowException {
    final int NUMBER_OF_COMMANDS = 13;// Google Style allows constant case    
    if (s.equals("getPower")) {
      System.out.println("your result is " + MyCalculations.exp());
      getMainMenu(false);
    } else if (s.equals("getFour")) {
      System.out.println(MyCalculations.doFourFunc());
      getMainMenu(false);      
    } else if (s.equals("makeProgrammers")) {
      try {
        Person programmer1;
        Person programmer2;
        Person programmer3;
        programmer1 = new CPlusPlusUsers("Dave", "M", 4, 2.3, sc, 45);
        programmer2 = new JavaUsers("Kent", "M", 5, 12.98, sc, 264);
        programmer3 = new FortranZeroUsers("Anne", "F", 1, 11.3, sc, 7568);
        Person[] pr = new Person[3];
        pr[0] = programmer1;
        pr[1] = programmer2;
        pr[2] = programmer3;
        MyStrings.printGeneric(pr);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
      getMainMenu(false);      
    } else if (s.equals("toUpper")) {
      System.out.println("What sould be in capital letters?");
      System.out.println(sc.nextLine().toUpperCase());
      getMainMenu(false);
    } else if (s.equals("checkPal")) {
      System.out.println("What do you want to test for a palindrome?");
      String st = sc.nextLine();
      if (MyStrings.checkPalindrome(st)) {
        System.out.println("It is a palindrome.");
      } else {
        System.out.println("It is not a palindrome.");
      }
      getMainMenu(false);
    } else if (s.equals("getInvert")) {
      System.out.println("What would you like to invert?");
      String st = sc.nextLine();
      MyStrings.invertString(st);
      getMainMenu(false);
    } else if (s.equals("getWinner")) {
      System.out.println(Person.getWinner(sc));
      getMainMenu(false);
    } else if (s.equals("arrayList")) {
      MyCalculations.doArrayList();
      getMainMenu(false);
    } else if (s.equals("sort")) {
      System.out.println("How many numbers do you wish to sort?");
      int[] arr;
      try {
        int n = sc.nextInt();
        System.out.println("What are your numbers by line?");
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
          arr[i] = sc.nextInt();
        }
        for (int e : MyCalculations.vanSort(arr)) {
          System.out.print(e + ", ");
        }
      } catch (Exception e1) {
        System.out.println("Bad input entered. please try again.");
        getMainMenu(false);
      }
      System.out.println();
      getMainMenu(false);
    } else if (s.equals("hashmap")) {
      MyCalculations.makeHashTable(sc);
      getMainMenu(false);
    } else if (s.equals("lambda")) {
      Person.lambdaAction();
      getMainMenu(false);
    } else if (s.equals("help")) {

      String format = String.format("Version '" + version + "' has %03d commands",
          NUMBER_OF_COMMANDS);
      System.out.println(format);
      System.out.printf("%n=================%n");
      System.out.printf(""// Insert new commands in this unorganized list
          + "%n -getPower: Returns the base raised to a power." + "%n -Exit: exits the program."
          + "%n -getMaterial: returns the material of the Brick class.");
      getMainMenu(false);
      /**
       * Exit statement
       */
    } else if (s.equals("Exit") || s.equals("exit")) {
      System.out.println("Goodbye!");
      sc.close();
      /**
       * Else statement if user command is not recognized
       */
    } else {
      System.out.println("what did you say?");
      String myTypo = sc.next();
      mainMenuFunction(myTypo);

    }
  }

  /**
   * <p>
   * The main method in class Main.
   * </p>
   * 
   * @param args
   *          is empty.
   */
  public static void main(String[] args) {
    System.out.println("Loading program...");
    MyCalculations.showLocalTime();
    try {
      System.out.println(Person.getWinner(sc));
    } catch (VanSelowException e) {
      System.out.println("Testing Exception Catching");
      System.out.println(e.toString());
    }
    try {
      CPlusPlusUsers john = new CPlusPlusUsers("John", "M", 3, 4.1, sc, 99);
      JavaUsers kyle = new JavaUsers("Kyle", "M", 5, 3.5, sc, 648);
      FortranZeroUsers mary = new FortranZeroUsers("Bob", "F", 1, 5.6, sc, 100000);
      Person[] group1 = { john, kyle, mary };
      System.out.println(Person.getFirst(group1).getName() + " Has the shortest time.");
    } catch (VanSelowException e) {
      System.out.println(e.toString());
    }
    getMainMenu(true);
  }

}
/*
 * Primitive Types in Java: Byte-a number stored in an 8-bit space Short- a
 * number stored in a 16-bit space int- a number stored in a 32-bit space Long-
 * a number stored in a 64-bit space float- a floating point number stored in a
 * 32-bit space double- a floating point number stored in a 64-bit space Char- a
 * single letter Boolean- a variable that stores 1 or 0, represented by true or
 * false Other type: String- class provided in platform that represents an array
 * of chars
 */
/*
 * lambda expressions are sometimes better to use over regular expressions
 * because: you can omit data types in parameter declaration you can omit the
 * parentheses if only one parameter java can figure the return type as well
 */
