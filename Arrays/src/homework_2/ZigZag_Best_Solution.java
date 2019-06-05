package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZigZag_Best_Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    String[] input = reader.readLine().split(" ");

    //parse input
    int rowsCount = Integer.parseInt(input[0]);
    int colsCount = Integer.parseInt(input[1]);

    //initialize variable for sum
    long sum = 0;

    //iterate matrix
    for (int row = 0; row < rowsCount; row++) {
      for (int col = 0; col < colsCount; col++) {
        //mathematic formula to find value of all elements, which we have to sum
        int cuurrentValue = (1 + 3 * (row + col));
        //get values only if row + col is even
        if ((row + col) % 2 == 0) {
          //check if row or col are first or last, then get values one time only
          if (row == 0 || row == rowsCount - 1 || col == 0 || col == colsCount - 1) {
            sum += cuurrentValue;
            //if get value multiply by 2
          } else {
            sum += cuurrentValue * 2;
          }
        }
      }
    }

    System.out.println(sum);
  }
}

