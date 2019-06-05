package homework_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Move {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //reading input
    int position = Integer.parseInt(reader.readLine());
    int[] array = Arrays.stream(reader.readLine()
            .split(","))
            .mapToInt(Integer::parseInt)
            .toArray();

    //initialize variables for sum
    long forwardSum = 0;
    long backwardSum = 0;

    //read commands
    String inputCommands;

    while (!"exit".equals(inputCommands = reader.readLine())) {
      String[] commandArguments = inputCommands.split("\\s+");

      int steps = Integer.parseInt(commandArguments[0]);
      String direction = commandArguments[1];
      int size = Integer.parseInt(commandArguments[2]);

      if ("backwards".equals(direction)) {
        size *= -1;
      }

      for (int i = 0; i < steps; i++) {
        position += size;

        if (position >= array.length) {
          //if position is more than array length - roll back
          position = position % array.length;
        }
        if (position < 0) {
          //if position is less than first index of array - roll back
          position = (array.length - (Math.abs(position) % array.length)) % array.length;
        }

        //add values
        if ("forward".equals(direction)) {
          forwardSum += array[position];
        } else {
          backwardSum += array[position];
        }
      }
    }

    System.out.printf("Forward: %d\n", forwardSum);
    System.out.printf("Backwards: %d", backwardSum);
  }
}
