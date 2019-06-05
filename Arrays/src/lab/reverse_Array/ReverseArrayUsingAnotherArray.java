package lab.reverse_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseArrayUsingAnotherArray {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input and parse as array
    int[] array = Arrays.stream(reader.readLine()
            .split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    //initialize a new array to store reversed values
    int[] reversedArray = new int[array.length];
    //initialize variable for index of reversed array
    int index = 0;

    //iterate from last to first element of the array
    for (int i = array.length - 1; i >= 0; i--) {
      //set set elements in reversed array starting from 0
      reversedArray[index++] = array[i];
    }

    //print reversed array
    for (int i = 0; i < reversedArray.length; i++) {
      if (i == reversedArray.length - 1) {
        System.out.print(reversedArray[i]);
      } else {
        System.out.print(reversedArray[i] + ", ");
      }
    }
  }
}
