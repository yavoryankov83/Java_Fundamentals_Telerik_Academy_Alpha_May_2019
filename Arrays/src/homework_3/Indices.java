package homework_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Indices {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    int countOfNums = Integer.parseInt(reader.readLine());
    String[] nums = reader.readLine().split("\\s+");

    //initialize int array to store numbers
    int[] numbers = new int[nums.length];

    //initialize boolean array to mark visited numbers
    boolean[] visitedNumbers = new boolean[numbers.length];

    //initialize builder to add found indeces
    StringBuilder builder = new StringBuilder();

    //fill the numbers array
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = Integer.parseInt(nums[i]);
    }

    //initialze current index when we start iterating the array
    int currentIndex = 0;
    //initialize start index when we start a cicle and set it to -1
    int loopStartIndex = -1;

    //iterate array while current idex is inside array boudries or we have a cicle
    while (true) {
      if (currentIndex < 0 || currentIndex >= numbers.length) {
        break;
      }
      //we have a cicle
      if (visitedNumbers[currentIndex]) {
        //set loop index to current index to store the start index of the cicle
        loopStartIndex = currentIndex;
        break;
      }

      //store current index and then white space
      builder
              .append(currentIndex)
              .append(" ");

      //set current index in boolean array to true - so we visited the number
      visitedNumbers[currentIndex] = true;
      //update current index - set it to the element at index - current index of the array
      currentIndex = numbers[currentIndex];
    }

    //if we have a cicle
    if (loopStartIndex >= 0) {

      //get the index of the white space before the index, when cicle starts
      int index = builder.indexOf(" " + loopStartIndex + " ");

      //if this index < 0, then insert "(" at index 0 of the stored result - builder
      if (index < 0) {
        builder.insert(0, "(");
        //if this index is >= 0, then replace the wtite space at this index with "("
      } else {
        builder.replace(index, index + 1, "(");
      }

      //if we have a cicle insert ")" at the end of result - builder
      builder.insert(builder.length() - 1, ")");
    }

    //print stored values and trim white space at the end
    System.out.println(builder.toString().trim());
  }
}
