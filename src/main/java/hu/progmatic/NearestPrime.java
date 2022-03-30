package hu.progmatic;

import java.util.HashSet;
import java.util.Set;

public class NearestPrime {

  public static long nextPrime(long number) {
    if (isPrime(number)) {
      return number;
    }

    for (long i = 1L; i < number; i++) {
      if (isPrime(number - i)) {
        return number - i;
      }
      if (isPrime(number + i)) {
        return (number + i);
      }
    }
    return 0;
  }

  public static boolean isPrime(long number) {
    boolean isPrime = true;
    for (long divisor = 2L; divisor <= Math.pow(number, 0.5); divisor += 1L) {
      if (number % divisor == 0) {
        isPrime = false;
        break;
      }
    }
    return isPrime;
  }

  public static int countBits(int n) {
    String binaryNum = Integer.toBinaryString(n);
    int counter = 0;
    for (int i = 0; i < binaryNum.length(); i++) {
      if (binaryNum.substring(i, i + 1).equals("1")) {
        counter++;
      }
    }
    return counter;
  }


  public static String factors(int number) {
    String list = "";
    for (int i = 2; i <= number; i++) {
      int counter = 0;
      for (int j = 0; j < 10; j++) {
        if (number % i == 0){
          counter += 1;
          number /= i;
        }
        else {
          j = 10;
        }
      }
      if (counter > 1){
        list += "(" + i + "**" + counter + ")";
      }
      else if(counter == 1){
        list+= "(" + i + ")";
      }
    }
    return list;
  }
}
