import java.util.*;

public class Radix {
  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data) {
    if (data.length == 0) return; //an empty array is essentially already sorted
        //System.out.println("This array is empty!");

    //Finds the maximum amount of digits in []data in any of its numbers
    int maxVal = data[0];
    for (int x = 0; x < data.length; x++) {
      if (data[x] > maxVal) maxVal = data[x];
    }
    int digitCount = countDigits(maxVal);

    //Creates the buckets
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int x = 0; x < buckets.length; x++) {
      buckets[x] = new MyLinkedList();
    }
    MyLinkedList values = new MyLinkedList();

    //Actual sorting algorithm
    //amount of times this operation is repeated is the amount of digits in the greatest number
    for (int repeatTimes = 0; repeatTimes < digitCount; repeatTimes++) {
      for (int index = 0; index < data.length; index++) {
        double tenPow = Math.pow(10,repeatTimes);
        int number = data[index] / (int)tenPow;
        int result = number % 10;
            //System.out.println("TRIAL: " + repeatTimes + " NUMBER: " + data[index] + " RESULT: " + result);
      if (data[index] > 0) {
        buckets[10+Math.abs(result)].add(data[index]);
      } else {
        buckets[9-Math.abs(result)].add(data[index]);
        }
      }
      //for each bucket, go through and take values, extend to values linkedlist
      for (int i = 0; i < buckets.length; i++) {  //buckets.length == 20;
        values.extend(buckets[i]);
      }
      //actually assign the values in the values linkedlist to data
      for (int c = 0; c < data.length; c++) {
        data[c] = (int)values.removeFront(); //(int) typecasting required as it would just be an Object otherwise
      }
            //System.out.println(Arrays.toString(data));
    }
  }

  //helper method counting digits in a single number
  private static int countDigits(int num) {
    int digits = 0;
    while (num > 0) {
      num = num / 10;
      digits = digits + 1;
    }
    return digits;
  }

  public static void main(String[] args) {
    int[] testArr = {12,13,21,4,43,32,0,1};
    radixsort(testArr);
    int[] testArr2 = {1000,100,123,-5,-2020,0,8,9123,10,-99};
    radixsort(testArr2);
    int[] testArr3 = {0,0,0,0,-1,1};
    radixsort(testArr3);
  }

}
