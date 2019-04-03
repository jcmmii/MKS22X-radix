import java.util.*;

public class Radix {
  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data) {
    if (data.length == 0) return;
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

    //math.pw(num,exp)
    for (int repeatTimes = 0; repeatTimes < digitCount; repeatTimes++) {
      for (int index = 0; index < data.length; index++) {
        double tenPow = Math.pow(10,repeatTimes);
        int number = data[index] / (int)tenPow;
        int result = number % 10;
        System.out.println("TRIAL: " + repeatTimes + " NUMBER: " + data[index] + " RESULT: " + result);
      //  System.out.println(data[index]);
      //  System.out.println(result);
      if (data[index] > 0) {
        buckets[10+Math.abs(result)].add(data[index]);
      } else {
        buckets[9-Math.abs(result)].add(data[index]);
        }
      }
      /*
      //System.out.println(Arrays.toString(buckets));
      for (int i = 0; i < buckets.length; i++) {
        values.extend(buckets[i]);
      }
      for (int c = 0; c < data.length; c++) {
        data[c] = (int) values.removeFront();
      }
    //  System.out.println(Arrays.toString(data));
    */
    }
  }

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
  }

}
