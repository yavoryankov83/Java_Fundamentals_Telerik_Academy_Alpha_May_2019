package homework_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrimeTriangle {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    int maxNumber = Integer.parseInt(reader.readLine());

    List<Integer> primeNumbers = new ArrayList<>();

    //iterate from 1 to max number and get all nums
    for (int i = 1; i <= maxNumber; i++) {
      //store current num
      int currentNumber = i;
      //check if current num is prime and return current num ot -1 if it is not
      if (checkIfNumberIsPrime(currentNumber) != -1) {
        //store only prime numbers
        primeNumbers.add(currentNumber);
      }
    }

    //iterate to prime numbers size() - this is count of rows to print
    for (int i = 0; i < primeNumbers.size(); i++) {
      //set index as the num we will print
      int index = 1;
      //every row must start with first num of primes - primes.getAt(0),
      //so every time j must be 0 - we set j = i - i
      //every row must have cols count = number of current row
      for (int j = i - i; j < primeNumbers.get(i); j++) {
        //check if num to print is even ot odd
        if (checkIfNumberIsPrime(index) != -1) {
          //if is even print 1
          System.out.print(1);
        } else {
          //if is odd print 0
          System.out.print(0);
        }
        //update num to print
        index++;
      }
      System.out.println();
    }
  }

  //method to check if num is prime or not and return the value of number if is prime, else return -1
  private static int checkIfNumberIsPrime(int numberToCheck) {
    boolean isPrime = true;

    for (int devider = 2; devider <= Math.sqrt(numberToCheck); devider++) {
      if (numberToCheck % devider == 0) {
        isPrime = false;
        break;
      } else {
        isPrime = true;
      }
    }
    if (isPrime) {
      return numberToCheck;
    } else {
      return -1;
    }
  }
}
