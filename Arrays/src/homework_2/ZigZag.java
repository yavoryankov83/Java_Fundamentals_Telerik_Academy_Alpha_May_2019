package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZigZag {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    String[] input = reader.readLine().split(" ");

    //parse input
    int rowsCount = Integer.parseInt(input[0]);
    int colsCount = Integer.parseInt(input[1]);

    //initialize matrix
    int[][] matrix = new int[rowsCount][colsCount];

    //set element [0][0] = 1
    matrix[0][0] = 1;
    //initialize index to find next elements
    int index = 3;
    //initialize variable for sum
    long sum = 1;

    //iterate matrix without first column
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 1; col < matrix[row].length; col++) {
        //fill the elements - current = previous + 3
        int currentValue = matrix[row][col - 1] + index;
        matrix[row][col] = currentValue;
        //check if current is odd and add to sum
        if (currentValue % 2 != 0) {
          //if row ot col are 0 ot last, then get value once
          if (row == 0 || row == rowsCount - 1 || col == 0 || col == colsCount - 1) {
            sum += matrix[row][col];
          } else {
            //if not get value multiply by 2
            sum += matrix[row][col] * 2;
          }
        }
      }

      if (row == matrix.length - 1) {
        break;
      } else {
        //set first element of each row
        matrix[row + 1][0] = matrix[row][0] + index;
        //if first element is odd, add to sum
        if (matrix[row + 1][0] % 2 != 0) {
          sum += matrix[row + 1][0];
        }
      }
    }

    System.out.println(sum);
  }
}
