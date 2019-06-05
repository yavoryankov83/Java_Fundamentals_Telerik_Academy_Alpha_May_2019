package homework_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitConvert {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    String[] input = reader.readLine().split(",");

    //initialize builder for result
    StringBuilder builder = new StringBuilder();

    //iterate nums
    for (int i = 0; i < input.length; i++) {
      //get current num
      int currentNum = Integer.parseInt(input[i]);
      //get current num as binary string
      String binaryCurrentNum = Integer.toBinaryString(currentNum);
      //padding with zeroes current binary string
      String paddingBinaryCurrentNum = "00000000".substring(binaryCurrentNum.length()) + binaryCurrentNum;

      //check if num is at even position in input (when i is even)
      if (i % 2 == 0) {
        //iterate binary string and get only bits at odd position (start i from 1 and increase +2)
        for (int j = 1; j < paddingBinaryCurrentNum.length(); j += 2) {
          //get current bit as char
          char current = paddingBinaryCurrentNum.charAt(j);
          //store in result
          builder.append(current);
        }
      } else {
        //iterate binary string and get only bits at even position (start i from 0 and increase +2)
        for (int j = 0; j < paddingBinaryCurrentNum.length(); j += 2) {
          //get current bit as char
          char current = paddingBinaryCurrentNum.charAt(j);
          //store in result
          builder.append(current);
        }
      }
    }
    //print
    System.out.println(builder.toString());
  }
}
