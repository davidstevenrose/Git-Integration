
/**
 * @author David Rose
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Person {
  
  private String name;
  private String gender;
  private String rank;
  private static String[] rankType = { "Beginner", "Intermmediate", 
      "Advanced", "Valselow", "( ͡° ͜ʖ ͡°)" };
  private double time;
  
  /**
   * <p>Creates an instance of the class Person.</p>
   * 
   * @param n
   *          is a name
   * @param g
   *          is a gender
   * @param r
   *          is a rank
   * @param time
   *          is a time
   * @throws VanSelowException
   *           if 'H' is typed for the Gender
   */
  public Person(String n, String g, int r, double time, Scanner sc) 
      throws VanSelowException {
    this.name = n;
    this.setGender(g, sc);
    this.setRank(r);
    this.setTime(time);
  }

  /**
   * <p>Creates an instance of the class Person using the time as the only parameter.</p>
   * 
   * @param i
   *          is the time
   */
  public Person(double i) {
    this.time = i;
  }

  /**
   * <p>Creates an instance of the class Person without using parameters.</p>
   */
  public Person() {

  }

  /**
   * <p>Sets the name field of an instance of Person.</p>
   * 
   * @param s
   *          is a string name
   */
  public void setName(String s) {
    this.name = s;
  }
  
  /**
   * <p>Sets the gender field of an instance of Person.</p>
   * 
   * @param s
   *          is a string M or F
   * @param in
   *          is the passed scanner construct
   * @throws VanSelowException
   *          if user inputed incorrect data
   */
  public void setGender(String s, Scanner in) throws VanSelowException {
    if (s.equals("M") || s.equals("F")) {
      this.gender = s;
    } else if (s.equals("H")) {
      throw new VanSelowException(
          "( ͡° ͜ʖ ͡°) You found an easter egg. H for"
          + " homosexual is not supported in this version.");
    } else {
      System.out.println("Invalid data. Type only M or F.");
      this.setGender(in.nextLine(), in);
    }
  }

  /**
   * <p> Sets the rank field of an instance of Person.</p>
   * 
   * @param i
   *          is an integer inclusively between 1 and 5
   */
  public void setRank(int i) {
    if (i <= 5 && i > 0) {
      this.rank = rankType[i - 1];
    } else {
      System.out.println("Invalid data. Ranks only go from 1 to 5.");      
    }
  }

  /**
   * <p> Sets the time field of an instance of Person.</p>
   * 
   * @param d
   *          is a double time
   */
  public void setTime(double d) {
    if (d > 0) {
      this.time = d;
    } else {
      System.out.println("Time cannot be negative.");
    }
  }

  /**
   * <p> Returns the name field of an instance of Person.</p>
   * 
   * @return a string name
   */
  public String getName() {
    return this.name;
  }

  /**
   * <p> Returns the gender field of an instance of Person.</p>
   * 
   * @return string 'Male' or 'Female'
   */
  public String getGender() {
    return this.gender;
  }

  /**
   * <p> Returns the rank field of an instance of Person.</p>
   * 
   * @return rank number with title
   */
  public String getRank() {
    int i = Arrays.asList(rankType).indexOf(this.rank);
    return "Rank " + (i + 1) + ": " + rankType[i];
  }

  /**
   * <p> Returns the time field of an instance of Person.</p>
   * 
   * @return a type double time.
   */
  public double getTime() {
    return this.time;
  }

  /**
   * <p> Prints the number of methods in the class Person.</p>
   */
  public void printClassMethodCount() {
    int i = Person.class.getDeclaredMethods().length;
    System.out.println("There are " + i + " methods in the Person class.");    
  }

  /**
   * <p>This method asks user the name, gender, rank, and time to complete a related
   * task. The data is stored in the java.lang.Object.Person class.</p>
   * 
   * @return Returns a formatted string defining input data of the person with the
   *         shortest time.
   * @throws VanSelowException
   *          if user inputed incorrect data
   */
  public static String getWinner(Scanner per) throws VanSelowException {
    // Setting names of each person
    Person[] people = new Person[3];
    System.out.println("What is the name of your next person?");
    Person person1 = new Person(per.nextLine(), "M", 1, 3.16, per);
    people[0] = person1;
    System.out.println("What is the name of your next person?");
    Person person2 = new Person(per.nextLine(), "M", 1, 2.04, per);
    people[1] = person2;
    System.out.println("What is the name of your next person?");
    Person person3 = new Person(per.nextLine(), "M", 5, 1.15, per);
    people[2] = person3;
    // Setting gender of each person
    System.out.println("What is the gender of your next person? Type M or F");
    person1.setGender(per.nextLine(), per);
    System.out.println("What is the gender of your next person? Type M or F");
    person2.setGender(per.nextLine(), per);
    System.out.println("What is the gender of your next person? Type M or F");
    person3.setGender(per.nextLine(), per);
    // Setting rank of each person
    System.out.println("What is the rank of your next person? Type a number between 1 and 5");
    person1.setRank(per.nextInt());
    System.out.println("What is the rank of your next person? Type a number between 1 and 5");
    person2.setRank(per.nextInt());
    System.out.println("What is the rank of your next person? Type a number between 1 and 5");
    person3.setRank(per.nextInt());
    // Setting time of each person
    System.out.println("What was the time to complete the challenge for your next person?");
    person1.setTime(per.nextDouble());
    System.out.println("What was the time to complete the challenge for your next person?");
    person2.setTime(per.nextDouble());
    System.out.println("What was the time to complete the challenge for your next person?");
    person3.setTime(per.nextDouble());
    // get person with shortest time
    Person first = Person.getFirst(people);
    System.out.println("The person with the shortest time "
        + "to complete the challenge: " + first.getName());
    StringBuilder stats = new StringBuilder("sats");
    StringBuilder eq = new StringBuilder("=");
    for (int i = 0; i < 41; i++) {
      eq.append("=");
    }
    eq.deleteCharAt(41);
    StringBuilder win = new StringBuilder(first.getName());
    double d = first.getTime();
    int w = 1;
    String str = String.format(eq + "\n\t\tWinner %s:\nName: %s\nRank:"
        + " %s\nTime: %f\nWins: %03d\n" + eq,
        stats.insert(1, "t"), win, first.getRank(), d, w);
    return str;
  }

  /**
   * <p> Returns the instance of Person that has the shortest time.</p>
   * <p> Method should be used as an instance of an array of Person objects
   *     and call for it's name field of the returning instance.</p>
   * 
   * @param people
   *          is the array of Person
   * @return the person with the least time in the sorted array
   */
  public static Person getFirst(Person[] people) {
    people = Person.sortInsert(people);
    return people[0];
  }

  /**
   * <p> A method that sorts an array of type Person by time.</p>
   * 
   * @param arr
   *          is the user inputed unsorted array
   * @return the sorted array by time
   */
  public static Person[] sortInsert(Person[] arr) {
    int n = arr.length;// 3
    for (int i = 0; i < n - 1; i++) {
      double r = arr[i + 1].getTime();
      if (r < arr[i].getTime()) {
        Person p = arr[i + 1];
        arr[i + 1] = arr[i];
        arr[i].setTime(r);
        arr[i] = p;
        int j = 1;
        while ((i - j) >= 0 && r < arr[i - j].getTime()) {
          p = arr[i - j + 1];
          arr[i - j + 1] = arr[i - j];
          arr[i - j] = p;
          arr[i - j].setTime(r);
          j++;
        }
      }
    }
    return arr;
  }

  /**
   * <p> A helper method designed to work with this class's <em>lambdaAction()</em> method.</p>
   */
  private void printTime() {
    System.out.println(this.getTime());
  }

  /**
   * <p> A helper method designed to work with this class's <em>lambdaAction()</em>
   * method.</p>
   */
  private static void processLambda(ArrayList<Person> al,
      Predicate<Person> tester, Consumer<Person> block) {
    for (Person p : al) {
      if (tester.test(p)) {
        block.accept(p);
      }
    }
  }

  /**
   * <p> Print's the Person object's times that are under a certain time limit.</p>
   */
  public static void lambdaAction() {
    ArrayList<Person> al = new ArrayList<Person>();
    Person one = new Person(5.1);
    Person two = new Person(71.5);
    Person three = new Person(8.9);
    Person four = new Person(2.4);
    Person five = new Person(43.7);
    al.add(one);
    al.add(two);
    al.add(three);
    al.add(four);
    al.add(five);
    processLambda(al, p -> p.getTime() <= 8.0, p -> p.printTime());
  }

}