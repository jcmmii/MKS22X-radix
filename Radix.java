public class Radix {
  public static void radixsort(int[] data) {
    int repeatTimes, counter = 0;
    for (int x = 0; x < data.length; x++) {
      counter = countDigits(data[x]);
      if (counter > repeatTimes) repeatTimes = counter;
    }
    System.out.println(repeatTimes);
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
    int[] testArr = {123,4,5,2,1212,0};
    radixsort(testArr);
  }
}
