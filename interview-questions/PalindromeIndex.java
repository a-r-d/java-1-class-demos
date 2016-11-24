import java.io.*;
import java.util.*;

public class PalindromeIndex {

	 public static void main(String[] args) {

	       String [] arr = new String [] {
	    		   "aaa",
	    		   "baaa",
	    		   "bbbc"
	       };
	       
	        for(int i = 0; i < arr.length; i++) {
	            String paltocheck = arr[i];
	            boolean pal = isPal(paltocheck);
	            if(pal) {
	                System.out.println(-1);
	                continue;
	            } 

	            int res = whichDoesntMatch(paltocheck);
	            if(res == -1) {
	                System.out.println("impossible");
	            }
	        }
	    
	    }
	    
	    public static int doChecks(String paltocheck, int a, int b) {
	        int [] arr = new int [] {a, b};
	        boolean pal = false;

	        for(int j = 0; j < arr.length; j++) {
	            int val = arr[j];
	            if(val == 0) {
	                pal = isPal(paltocheck.substring(1));
	            } else if(val == paltocheck.length() - 1) {
	                pal = isPal(paltocheck.substring(0, val - 1));
	            } else {
	                pal = isPal(paltocheck.substring(0, val) + paltocheck.substring(val + 1, paltocheck.length()));
	            }
	            if(pal) {
	                System.out.println(val);
	                return val;
	            }
	        }
	        return -1;
	    }
	  
	    
	    public static int whichDoesntMatch(String s) {
	        char [] arr = s.toCharArray();
	        for(int i = 0; i < arr.length / 2; i++) {
	            int last = arr.length - 1 - i;
	            if(arr[last] != arr[i]) {
	                int res = doChecks(s, i, last);
	                if(res == -1) {
	                    continue;
	                }
	                return i;
	            }
	        }
	        return -1;
	    }
	    
	    public static boolean isPal(String s) {
	        char [] arr = s.toCharArray();
	        for(int i = 0; i < arr.length / 2; i++) {
	            int last = arr.length - 1 - i;
	            if(arr[last] != arr[i]) {
	                return false;
	            }
	        }
	        return true;
	    } 
}
