
public class HelloArguments {

  public static void main(String [] args) {
    System.out.print("Hello arguments: ");
    for(String s : args) {
      System.out.print(s + ",");
    }
    System.out.println("\nthat's all folks!");
  }

}
