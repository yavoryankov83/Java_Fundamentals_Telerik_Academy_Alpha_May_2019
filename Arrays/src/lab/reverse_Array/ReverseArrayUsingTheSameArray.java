package lab.reverse_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseArrayUsingTheSameArray {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input and parse as array
    int[] array = Arrays.stream(reader.readLine()
            .split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    //iterate to the middle of array and swap first with last element
    for (int i = 0; i < array.length / 2; i++) {
      int temp = array[i];
      array[i] = array[array.length - i - 1];
      array[array.length - i - 1] = temp;
    }

    //print reversed array
    for (int i = 0; i < array.length; i++) {
      if (i == array.length - 1) {
        System.out.print(array[i]);
      } else {
        System.out.print(array[i] + ", ");
      }
    }
  }
}
