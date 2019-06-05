package homework_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixMaxSum {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    int sizeOfRows = Integer.parseInt(reader.readLine());

    //read only first row to get the second dimension of matrix - number of cols (firstRowValues.length)
    String[] firstRowValues = reader.readLine().split("\\s+");

    //initialize matrix
    int[][] matrix = new int[sizeOfRows][firstRowValues.length];

    //fill the first row
    for (int firstRow = 0; firstRow < firstRowValues.length; firstRow++) {
      matrix[0][firstRow] = Integer.parseInt(firstRowValues[firstRow]);
    }

    //fill other rows
    for (int row = 1; row < sizeOfRows; row++) {
      String[] inputRow = reader.readLine().split("\\s+");
      for (int col = 0; col < matrix[row].length; col++) {
        matrix[row][col] = Integer.parseInt(inputRow[col]);
      }
    }

    //read pairs
    String[] pairs = reader.readLine().split("\\s+");

    //initialize pairs - row and col
    int row = 0;
    int col = 0;

    //initialize sum
    int currentSum = 0;
    int maxSum = 0;

    //initialize count variable to get only first and second argument of pairs input
    int count = 0;

    //iterate to the half of the input length
    for (int i = 0; i < pairs.length / 2; i++) {
      ////get row nad col values
      row = Integer.parseInt(pairs[count++]);
      col = Integer.parseInt(pairs[count++]);

      //find current sum and check row and col posible directions
      currentSum = checkRowColDirectionAndReturnCurrentSum(matrix, currentSum, row, col);

      //update max sum
      if (currentSum > maxSum) {
        maxSum = currentSum;
      }
      //restart current sum
      currentSum = 0;
    }

    //print
    System.out.println(maxSum);
  }

  //check all cases - row > 0 ot row < 0 and col > 0 or col < 0 and move
  private static int checkRowColDirectionAndReturnCurrentSum(int[][] matrix, int sum, int row, int col) {
    if (row > 0) {
      for (int i = 0; i < Math.abs(col) - 1; i++) {
        sum += matrix[row - 1][i];
      }
    } else {
      for (int i = matrix[0].length - 1; i > Math.abs(col) - 1; i--) {
        sum += matrix[Math.abs(row) - 1][i];
      }
    }

    if (col > 0) {
      for (int i = Math.abs(row) - 1; i >= 0; i--) {
        sum += matrix[i][col - 1];
      }
    } else {
      for (int i = Math.abs(row) - 1; i <= matrix.length - 1; i++) {
        sum += matrix[i][Math.abs(col) - 1];
      }
    }
    return sum;
  }
}
