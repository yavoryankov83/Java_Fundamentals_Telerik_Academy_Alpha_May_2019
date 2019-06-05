package lab.reverse_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class ReverseArrayUsingCollections {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input and parse as array
    Integer[] array = Arrays.stream(reader.readLine()
            .split("\\s+"))
            .mapToInt(Integer::parseInt)
            .boxed()
            .toArray(Integer[]::new);

    //use Collections to reverse the array
    Collections.reverse(Arrays.asList(array));
    System.out.println(Arrays.toString(array)
            .replace('[', ' ')
            .replace(']', ' ')
            .trim());
  }
}
