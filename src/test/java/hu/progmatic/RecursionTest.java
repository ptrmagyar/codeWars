package hu.progmatic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionTest {

    @Test
    void factorialTest() {
        assertEquals(2,Recursion.factorial(2));
        assertEquals(6,Recursion.factorial(3));
    }
}