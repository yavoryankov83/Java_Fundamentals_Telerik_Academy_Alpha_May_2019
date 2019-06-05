package lab.group_Numbers_Of_Array_By_Reminder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeGroups {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input and parse
    int[] array = Arrays.stream(reader.readLine()
            .split("\\s+"))
            .mapToInt(Integer::parseInt)
            .toArray();

    //initialize 3 arraylists for each case
    List<String> zeroReminders = new ArrayList<>();
    List<String> oneReminders = new ArrayList<>();
    List<String> twoReminders = new ArrayList<>();

    //check reminder and and the element to correct arraylist
    for (int num : array) {
      if (num % 3 == 0) {
        zeroReminders.add(String.valueOf(num));
      } else if (num % 3 == 1) {
        oneReminders.add(String.valueOf(num));
      } else if (num % 3 == 2) {
        twoReminders.add(String.valueOf(num));
      }
    }

    System.out.println(String.join(" ", zeroReminders));
    System.out.println(String.join(" ", oneReminders));
    System.out.println(String.join(" ", twoReminders));
  }
}
