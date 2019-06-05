package lab.symmetric_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SymmetricArrays {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(reader.readLine());

    for (int i = 0; i < count; i++) {
      //initialize boolean to true
      boolean isSymmetric = true;

      //read input and parse to int
      int[] array = Arrays.stream(reader.readLine()
              .split("\\s+"))
              .mapToInt(Integer::parseInt)
              .toArray();

      //iterate to the middle and check if first element differs from last element
      for (int j = 0; j < array.length / 2; j++) {
        if (array[j] != array[array.length - j - 1]) {
          //set bollean to false
          isSymmetric = false;
          break;
        }
      }

      //check boolean condition
      if (isSymmetric) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
  }
}
