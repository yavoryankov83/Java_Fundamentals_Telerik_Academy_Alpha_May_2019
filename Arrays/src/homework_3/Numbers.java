package homework_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numbers {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    String[] input = reader.readLine().split("\\s+");

    int firstNum = Integer.parseInt(input[0]);
    int secondNum = Integer.parseInt(input[1]);
    int thirdNum = Integer.parseInt(input[2]);
    int fourthNum = Integer.parseInt(input[3]);

    StringBuilder builder = new StringBuilder();

    //declare the fourth numbers
    int a, b, aab, abb;

    //set a = -1000
    a = -1000;

    do {
      if (a != 0) {
        b = -1000;
        do {
          if (b != 0) {
            aab = a * a * b;
            abb = a * b * b;

            if ((a == firstNum || firstNum == 0)
                    && (b == secondNum || secondNum == 0)
                    && (aab == thirdNum || thirdNum == 0)
                    && (abb == fourthNum || fourthNum == 0)) {

              System.out.println(builder
                      .append(a)
                      .append(" ")
                      .append(b)
                      .append(" ")
                      .append(aab)
                      .append(" ")
                      .append(abb).toString());

              return;
            }
          }

          b++;
        } while (b <= a);
      }

      a++;
    } while (a <= 1000);
  }
}
