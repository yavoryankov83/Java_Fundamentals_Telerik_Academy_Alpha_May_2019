package homework_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpiralMatrix {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    int size = Integer.parseInt(reader.readLine());

    //initialize matrix
    int[][] matrix = new int[size][size];

    //initialize row and col index to update index ofvisited row and col
    int rowIndex = 0;
    int colIndex = 0;

    //initialize variables for last row and last col
    int lastRow = size - 1;
    int lastCol = size - 1;

    //initialize variable for values and increase it every step
    int count = 1;

    //while index of row and col <= last row and last col
    while (rowIndex <= lastRow && colIndex <= lastCol) {
      //print first row
      for (int i = colIndex; i <= lastCol; i++) {
        matrix[rowIndex][i] = count++;
      }
      rowIndex++;

      //print last col
      for (int i = rowIndex; i <= lastRow; i++) {
        matrix[i][lastCol] = count++;
      }
      lastCol--;

      //check if index of row is reached last row
      if (rowIndex <= lastRow) {
        //print last row
        for (int i = lastCol; i >= colIndex; i--) {
          matrix[lastRow][i] = count++;
        }
        lastRow--;

        //print first col
        for (int i = lastRow; i >= rowIndex; i--) {
          matrix[i][colIndex] = count++;
        }
        colIndex++;
      }
    }

    //print
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        System.out.print(matrix[row][col] + " ");
      }
      System.out.println();
    }
  }
}
