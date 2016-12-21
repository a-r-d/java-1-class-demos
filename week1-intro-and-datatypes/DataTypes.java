
public class DataTypes {

  public static void main(String [] args) {
    System.out.println("Hello datatypes: ");

    // Base types
    boolean iAmTrue = true;  // either true or false
    byte b = 127; // max value  --- 2^8 - 1
    short s = 128; // 2^16 - 1
    int i = 9000; // 2^31 - 1
    long l = 1234567890L;  // 2^63 - 1
    float f = 40.5f;
    double decimal = 89.8938439930;
    char a = 'a';

    String str = "I am a string!";  // String is actually an Object.
    Object o = new Object(); // a generic object, String is built on top of this.

    // arrays:
    boolean [] booles = new boolean [] {true, false, true, false, true};

    System.out.println("Printing an int: " + i);
    System.out.println("Printing a string: " + str);
    System.out.println("Printing an array: " + booles);

    // Best to actually just consult the oracle:
    // http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

    // things that don't work:
    //int myNewInt = 100 + str;
    // things that do:
    //String myNewString = 100 + str;
    //String myNewString2 = Integer.toString(100) + str;

  }

}
