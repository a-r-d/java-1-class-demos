import java.util.Arrays;

public class CopyArray {

  public static void main(String args []) {

    String [] decisions = {"yes", "no", "maybe", "definitely not"};
    String [] copyDecisions = Arrays.copyOf(decisions, decisions.length);

  }

}
