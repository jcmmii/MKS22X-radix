import java.util.*;
public class Radix {
  @SuppressWarnings("unchecked")
  public static void radixsort(int[] data) {
    /*
    int repeatTimes = 0;
    int counter = 0;
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int x = 0; x < data.length; x++) {
      counter = countDigits(data[x]);
      if (counter > repeatTimes) repeatTimes = counter;
    }
    counter = 0;
    while (counter < repeatTimes) {

    }
    */
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    int divNum = 10;
    int curNum = 0;
    for (int x = 0; x < data.length; x++) {
      curNum = data[x]%10;
      System.out.println(curNum);
      buckets[Math.abs(curNum)].add(data[x]);
    }
    System.out.println(buckets);
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
