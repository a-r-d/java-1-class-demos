
public class CompareArrays {

  public static void main(String args []) {

    String [] arr1 = {"one", "two", "three", "four"};
    String [] arr2 = {"one", "two", "three", "four"};

    if(java.util.Arrays.equals(arr1, arr2)) {
      System.out.println("The arrays are equal");
    } else {
      System.out.println("The arrays are not equal");
    }

  }

}
