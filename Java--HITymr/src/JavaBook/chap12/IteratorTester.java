package JavaBook.chap12;

import java.util.*;
public class IteratorTester { 
  public static void main(String args[]) { 
    String[]  num = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"}; 
    Vector<String>   aVector = new Vector<String>(java.util.Arrays.asList(num)); 
    System.out.println("Before Vector: " + aVector); 
    Iterator<String> nums = aVector.iterator(); 
    while(nums.hasNext()) { 
      String aString = nums.next(); 
      System.out.print(aString+"  "); 
      if (aString.length() > 4)    nums.remove();
    } 
   System.out.println(); 
    System.out.println("After Vector: " + aVector);
  }
}