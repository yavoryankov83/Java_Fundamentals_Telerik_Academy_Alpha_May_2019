package homework_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JoroTheRabbit {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    String[] input = reader.readLine().split(", ");
    int[] route = new int[input.length];

    //fill the array
    for (int i = 0; i < input.length; i++) {
      route[i] = Integer.parseInt(input[i]);
    }

    //initialize best path count
    int bestPathCount = 0;

    //iterate outside loop by the indeces of array
    for (int index = 0; index < route.length; index++) {
      //iterate inside loop by steps
      for (int step = 1; step < route.length; step++) {
        //store current array index in current index
        int currentIndex = index;
        //initialize current path count
        int currentPathCount = 1;
        //initialize and set next index
        int nextIndex = (currentIndex + step) % route.length; //if next index > route.length

        //iterate array while next num > current num
        while (route[nextIndex] > route[currentIndex]) {
          //update the path
          currentPathCount++;
          //update the index
          currentIndex = nextIndex;
          //update net index
          nextIndex = (currentIndex + step) % route.length;
        }
        //update best path
        if (currentPathCount > bestPathCount) {
          bestPathCount = currentPathCount;
        }
      }
    }

    //print
    System.out.println(bestPathCount);
  }
}
