package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZigZag_1 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    String[] input = reader.readLine().split(" ");

    //parse input
    int rowsCount = Integer.parseInt(input[0]);
    int colsCount = Integer.parseInt(input[1]);

    //initialize matrix
    int[][] matrix = new int[rowsCount][colsCount];

    //initialize variable for sum
    long sum = 1;

    //set element[0][0] = 1
    matrix[0][0] = 1;

    //initialize variable to calculate elements
    int index = 3;

    //iterate matrix without first column
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 1; col < matrix[row].length; col++) {
        matrix[row][col] = matrix[row][col - 1] + index;

        //check if row and col are even at the same time or are odd
        if ((row % 2 == 0 && col % 2 == 0) || (row % 2 != 0 && col % 2 != 0)) {
          //if row ot coll are 0 or last get value only one time
          if (row == 0 || row == rowsCount - 1 || col == colsCount - 1) {
            sum += matrix[row][col];
          } else {
            //multiply value by 2
            sum += matrix[row][col] * 2;
          }
        }
      }

      if (row == matrix.length - 1) {
        break;
      } else {
        //set first element of each row
        matrix[row + 1][0] = matrix[row][0] + index;
        //check first element ot each row if row is odd add value
        if (row % 2 != 0) {
          sum += matrix[row + 1][0];
        }
      }
    }

    System.out.println(sum);
  }
}
