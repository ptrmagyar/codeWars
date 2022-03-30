package hu.progmatic;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class NearestPrimeTest {

  @Test
  void nextPrime() {
    assertEquals(3L,NearestPrime.nextPrime(3L));
    assertEquals(11L,NearestPrime.nextPrime(11L));
    assertEquals(3L,NearestPrime.nextPrime(4L));
    assertEquals(109L,NearestPrime.nextPrime(110L));
    assertEquals(1109L,NearestPrime.nextPrime(1110L));
    assertEquals(2999L,NearestPrime.nextPrime(3000L));
    assertEquals(34981L,NearestPrime.nextPrime(35000L));
    assertEquals(10000000019L,NearestPrime.nextPrime(10000000000L));

    assertTrue(NearestPrime.isPrime(3));
    assertTrue(NearestPrime.isPrime(10000000019L));
    assertFalse(NearestPrime.isPrime(16));

  }

  @Test
  public void testPrimeDecompOne() {
    int lst = 7775460;
    assertEquals(
        "(2**2)(3**3)(5)(7)(11**2)(17)",
        NearestPrime.factors(lst));

    System.out.println(NearestPrime.factors(130));
    System.out.println(NearestPrime.factors(1310));
    System.out.println(NearestPrime.factors(40));
    System.out.println(NearestPrime.factors(34060));

  }

  @Test
  public void correctValue() {
    assertEquals("codewa.rs", Kata.name);
  }

  @Test
  public void exampleTests() {
    assertEquals("odd", Numbers.oddity(BigInteger.valueOf(4)));
    assertEquals("even", Numbers.oddity(BigInteger.valueOf(12)));
    assertEquals("even", Numbers.oddity(BigInteger.valueOf(1000000000)));
  }

  @Test
  public void test_fractions() throws Exception {
    long[][] lst;
    lst = new long[][] { {1, 2}, {1, 3}, {10, 40} };
    assertEquals("(6,12)(4,12)(3,12)", Numbers.convertFrac(lst));
  }

  @Test
  public void test_BasicTests() {
    assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", Numbers.rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20}));

    assertEquals("-3--1,2,10,15,16,18-20", Numbers.rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));
  }

  @Test
  void bmi() {
    assertEquals("Underweight",Numbers.bmi(50,1.80));
  }
}