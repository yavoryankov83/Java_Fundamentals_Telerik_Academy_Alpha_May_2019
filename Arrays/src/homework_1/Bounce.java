package homework_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Bounce {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    String[] input = reader.readLine().split("\\s+");

    int rows = Integer.parseInt(input[0]);
    int cols = Integer.parseInt(input[1]);

    //initialize matrix
    BigInteger[][] matrix = new BigInteger[rows][cols];

    BigInteger sum = new BigInteger("1");

    //initialize current direction to move
    int horizontalMove = 1;
    int verticalMove = 1;

    //initialize start position
    int currentRow = 0;
    int currentCol = 0;

    for (int row = 0; row < matrix.length; row++) {
      long index = (long) Math.pow(2, row);
      for (int col = 0; col < matrix[row].length; col++) {
        matrix[row][col] = BigInteger.valueOf(index);
        index *= 2;
      }
    }

    while (true) {
      int nextRow = currentRow + horizontalMove;
      int nextCol = currentCol + verticalMove;

      //check border of array, if reach border, then change current direction to move
      //if we reach up or down, then change row direction
      //if we reach left ot right, then change col direction
      if (nextRow < 0 || nextRow > rows - 1) {
        horizontalMove *= -1;
      }

      if (nextCol < 0 || nextCol > cols - 1) {
        verticalMove *= -1;
      }

      //update current position
      currentRow += horizontalMove;
      currentCol += verticalMove;

      //add value to sum
      BigInteger currentValue = matrix[currentRow][currentCol];
      sum = sum.add(currentValue);

      //check for corners if we hit, then break
      if (currentRow == rows - 1 && currentCol == cols - 1
              || currentRow == 0 && currentCol == 0
              || currentRow == 0 && currentCol == cols - 1
              || currentRow == rows - 1 && currentCol == 0) {
        break;
      }
    }

    System.out.println(sum);
  }
}
