package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HorsePath {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    int size = Integer.parseInt(reader.readLine());

    //initialize matrix
    int[][] matrix = new int[size][size];

    //store all possible 8 next movements by row and col coordinates starting from topmost leftmost
    int[] moveByRows = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] moveByCols = {-1, 1, -2, 2, -2, 2, -1, 1};

    //initialize counter
    int counter = 1;

    //iterate matrix
    for (int r = 0; r < matrix.length; r++) {
      for (int c = 0; c < matrix[r].length; c++) {
        int row = r;
        int col = c;
        //while cell == 0 move
        while (matrix[row][col] == 0) {
          //set value to sell = counter
          matrix[row][col] = counter;
          //increase value
          counter++;

          //move by rows and set next row and next col, geting the values from arrays
          for (int index = 0; index < moveByRows.length; index++) {
            int nextRow = row + moveByRows[index];
            int nextCol = col + moveByCols[index];

            //chech if our move is outside the matrix boundries and continie
            if (nextRow < 0 || nextRow > matrix.length - 1
                    || nextCol < 0 || nextCol > matrix[row].length - 1) {
              continue;
            }

            //check if cell to move on is busy and continue
            if (matrix[nextRow][nextCol] != 0) {
              continue;
            }

            //update row and col and break
            row = nextRow;
            col = nextCol;

            break;
          }
        }
      }
    }

    //print matrix
    for (int rows = 0; rows < matrix.length; rows++) {
      for (int cols = 0; cols < matrix[rows].length; cols++) {
        System.out.print(matrix[rows][cols] + " ");
      }

      System.out.println();
    }
  }
}
