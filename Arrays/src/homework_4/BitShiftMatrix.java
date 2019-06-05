package homework_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BitShiftMatrix {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    int rows = Integer.parseInt(reader.readLine());
    int cols = Integer.parseInt(reader.readLine());

    int countOfMoves = Integer.parseInt(reader.readLine());

    String[] moves = reader.readLine().split("\\s+");

    //initialize matrix
    BigInteger[][] matrix = new BigInteger[rows][cols];

    //iterate and fill matrix
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        //every value = 2^(rows - row - 1 + col);
        //get the pow as BigInteger - BigInteger.valueOf(2)
        BigInteger value = BigInteger.valueOf(2).pow(rows - row - 1 + col);
        //set value to cell
        matrix[row][col] = value;
      }
    }

    //initialize start position
    int startRow = rows - 1;
    int startCol = 0;

    //initialize sum
    BigInteger sum = BigInteger.ZERO;

    //iterate moves
    for (String move : moves) {
      //calculate destinantion position - row and col
      int targetRow = Integer.parseInt(move) / Math.max(rows, cols);
      int targetCol = Integer.parseInt(move) % Math.max(rows, cols);

      //move by the cols first while we reach target
      while (startCol != targetCol) {
        //add current cel value
        sum = sum.add(matrix[startRow][startCol]);
        //mark that we visit the sell - set it to 0,
        // so next time we add the same cell, the sum will not change
        matrix[startRow][startCol] = BigInteger.ZERO;

        //move right if target col > start col
        if (startCol < targetCol) {
          //update start position
          startCol++;
          //move left if target col < start col
        } else {
          //update start position
          startCol--;
        }
      }

      //move by the rows while we reach target
      while (startRow != targetRow) {
        //add current cell value
        sum = sum.add(matrix[startRow][startCol]);
        //mark that we visit the sell - set it to 0,
        // so next time we add the same cell, the sum will not change
        matrix[startRow][startCol] = BigInteger.ZERO;

        //move down if target row > start row
        if (startRow < targetRow) {
          //update start position
          startRow++;
          //move up if target row < start row
        } else {
          //update start position
          startRow--;
        }
      }
    }

    //add to sum the last cell value, because we never reached it
    sum = sum.add(matrix[startRow][startCol]);
    //print
    System.out.println(sum);
  }
}
