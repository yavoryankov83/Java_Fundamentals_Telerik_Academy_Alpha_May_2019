package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestBlockInString {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String input = reader.readLine();

    int currentCount = 1;
    int maxCount = 1;

    //variable to store first char that repeats max count
    char result = ' ';

    //take first element in string as previous
    char previous = input.charAt(0);

    //iterate over string starting from 1
    for (int i = 1; i < input.length(); i++) {
      //take current element - char
      char current = input.charAt(i);

      //check if they are equal
      if (current == previous) {
        currentCount++;
        //store current char
        char currentCharValue = current;

        if (currentCount > maxCount) {
          maxCount = currentCount;
          //store char to print
          result = currentCharValue;
        }
      } else {
        currentCount = 1;
      }

      //set previous to current
      previous = current;
    }

    //check if string length > 0
    if (maxCount > 1) {
      for (int i = 0; i < maxCount; i++) {
        System.out.print(result);
      }
      //if string length == 0
    } else {
      System.out.println(input.charAt(0));
    }
  }
}
