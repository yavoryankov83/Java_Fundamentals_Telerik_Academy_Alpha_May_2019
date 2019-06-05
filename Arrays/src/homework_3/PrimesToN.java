package homework_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimesToN {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    int num = Integer.parseInt(reader.readLine());

    //database to store prime values
    StringBuilder builder = new StringBuilder();

    //iterate numbers from 1 to wanted boundry
    for (int numberToCheck = 1; numberToCheck <= num; numberToCheck++) {
      //initialize count to store how times number is devided to devider
      int count = 0;
      //iterate deviders from 2 to Math.sqrt(number) - no need to check all deviders
      for (int devider = 2; devider <= Math.sqrt(numberToCheck); devider++) {
        //if number is devided to devider more than 0, than it is not prime
        if (numberToCheck % devider == 0) {
          count++;
          break;
        }
      }
      //if number is not devideable to devider, than number is prime
      if (count == 0) {
        builder.append(numberToCheck + " ");
      }
    }

    //print
    System.out.println(builder.toString().trim());
  }
}
