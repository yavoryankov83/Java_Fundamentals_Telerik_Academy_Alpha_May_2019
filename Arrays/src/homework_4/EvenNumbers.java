package homework_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvenNumbers {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    String input = reader.readLine();

    //initialize pattern to find only nums
    String stringToFind = "\\d+";

    //compile pattern
    Pattern pattern = Pattern.compile(stringToFind);

    Matcher matcher = pattern.matcher(input);

    //initialize max even number to -1, if we didn't find any even num,
    //we return -1
    int maxEvenNumber = -1;

    //iterate input
    while (matcher.find()) {
      //current match as string
      String current = matcher.group();
      //get current num as int
      int currentEvenNumber = Integer.parseInt(current);

      //check if is even
      if (currentEvenNumber % 2 == 0) {
        if (currentEvenNumber > maxEvenNumber) {
          //update max even number
          maxEvenNumber = currentEvenNumber;
        } else {
          continue;
        }
      }
    }

    //print
    System.out.println(maxEvenNumber);
  }
}
