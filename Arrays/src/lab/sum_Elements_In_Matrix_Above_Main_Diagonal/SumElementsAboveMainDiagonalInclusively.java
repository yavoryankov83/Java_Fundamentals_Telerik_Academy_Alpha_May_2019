package lab.sum_Elements_In_Matrix_Above_Main_Diagonal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SumElementsAboveMainDiagonalInclusively {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int size = Integer.parseInt(reader.readLine());

    //initialize matrix
    BigInteger[][] matrix = new BigInteger[size][size];

    //fill the matrix
    for (int row = 0; row < matrix.length; row++) {
      //initialize variable - every first element of each row = 2^row
      //row 0 = 2^0 = 1
      //row 1 = 2^1 = 2
      //row 2 = 2^2 = 4
      long index = (long) Math.pow(2, row);
      for (int col = 0; col < matrix[row].length; col++) {
        //set value to matrix elements
        matrix[row][col] = BigInteger.valueOf(index);
        //update index - every next element of each row = first * 2;
        index *= 2;
      }
    }

    //initialize variable to sum values
    BigInteger sum = new BigInteger("0");

    //iterate elements above main diagonal inclusively
    for (int row = 0; row < matrix.length; row++) {
      for (int col = row; col < matrix.length; col++) {
        BigInteger elementValue = matrix[row][col];

        //add values to sum
        sum = sum.add(elementValue);
      }
    }

    System.out.println(sum.toString());
  }
}
