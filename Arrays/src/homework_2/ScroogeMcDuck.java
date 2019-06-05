package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScroogeMcDuck {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    String[] input = reader.readLine().split(" ");

    //initialize rows and cols
    int rowsCount = Integer.parseInt(input[0]);
    int colsCount = Integer.parseInt(input[1]);

    //initialize current row and col
    int currentRow = 0;
    int currentCol = 0;

    //initialize coins count
    int coins = 0;

    //initialize matrix
    int[][] matrix = new int[rowsCount][colsCount];

    //fill the matrix
    for (int row = 0; row < matrix.length; row++) {
      String[] inputValues = reader.readLine().split(" ");
      for (int col = 0; col < matrix[row].length; col++) {
        matrix[row][col] = Integer.parseInt(inputValues[col]);
        int currentValue = matrix[row][col];

        //find and store starting point - value = 0
        if (currentValue == 0) {
          currentRow = row;
          currentCol = col;
        }
      }
    }

    //move while all values become 0, then break
    while (true) {
      //check if we can move to the 4 directions
      boolean hasLeftDir = currentCol - 1 >= 0;
      boolean hasRightDir = currentCol + 1 < colsCount;
      boolean hasUpDir = currentRow - 1 >= 0;
      boolean hasDownDir = currentRow + 1 < rowsCount;

      //initialize max value
      int maxValue = Integer.MIN_VALUE;

      //initialize array to store: maxvalue row and maxvalue col
      int[] store = new int[2];

      //go left
      if (hasLeftDir) {
        int leftValue = matrix[currentRow][currentCol - 1];
        if (leftValue > maxValue) {
          maxValue = leftValue;
          store[0] = currentRow;
          store[1] = currentCol - 1;
        }
      }

      //go right
      if (hasRightDir) {
        int rightValue = matrix[currentRow][currentCol + 1];
        if (rightValue > maxValue) {
          maxValue = rightValue;
          store[0] = currentRow;
          store[1] = currentCol + 1;
        }
      }

      //go up
      if (hasUpDir) {
        int upValue = matrix[currentRow - 1][currentCol];
        if (upValue > maxValue) {
          maxValue = upValue;
          store[0] = currentRow - 1;
          store[1] = currentCol;
        }
      }

      //go down
      if (hasDownDir) {
        int downValue = matrix[currentRow + 1][currentCol];
        if (downValue > maxValue) {
          maxValue = downValue;
          store[0] = currentRow + 1;
          store[1] = currentCol;
        }
      }

      //check if all values of all directions are 0 and break
      if (maxValue <= 0) {
        break;
      }

      //update coins
      coins += 1;

      //update next position
      currentRow = store[0];
      currentCol = store[1];

      //decrease max value with 1
      matrix[currentRow][currentCol] -= 1;
    }

    System.out.println(coins);
  }
}
