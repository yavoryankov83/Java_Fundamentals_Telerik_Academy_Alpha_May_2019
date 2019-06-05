package homework_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TribonacciTriangle {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    long firstNum = Long.parseLong(reader.readLine());
    long secondNum = Long.parseLong(reader.readLine());
    long thirdNum = Long.parseLong(reader.readLine());
    long numberOfLines = Long.parseLong(reader.readLine());

    //print first 2 rows
    System.out.println(firstNum);
    System.out.println(secondNum + " " + thirdNum);

    //iterate - outside loop from 0 to the difference between number of lines and already printed 2 rows
    for (int row = 0; row < numberOfLines - 2; row++) {
      //iterate - inside loop from 0 to row + 3, because rows = cols (1-st row - 1 value,
      // 2-cond row - 2 values etc.), but we start from row = 0 and must print 3 values with the first iteration
      // of inside loop, but row count of outside loop is 0, so we must add 3 to row = 0
      for (int col = 0; col < row + 3; col++) {
        //calculate next number of the sequence
        long nextNumber = firstNum + secondNum + thirdNum;

        //update values to calculate net number
        firstNum = secondNum;
        secondNum = thirdNum;
        thirdNum = nextNumber;

        System.out.print(nextNumber + " ");
      }
      System.out.println();
    }
  }
}
