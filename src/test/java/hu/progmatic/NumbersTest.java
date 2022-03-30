package hu.progmatic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;



class NumbersTest {

    @Test
    void justNumberTest() {
        assertEquals(Arrays.asList(new Object[]{1,2}), Numbers.filterList(Arrays.asList(new Object[]{1,2,"a","b"})));
        assertEquals(Arrays.asList(new Object[]{1,0,15}), Numbers.filterList(Arrays.asList(new Object[]{1,"a","b",0,15})));
        assertEquals(Arrays.asList(new Object[]{1,2,123}), Numbers.filterList(Arrays.asList(new Object[]{1,2,"aasf","1","123",123})));

    }

    @Test
    void toRomanTest() {
        assertEquals("I", Numbers.toRoman(1));
        assertEquals("V", Numbers.toRoman(5));
        assertEquals("X", Numbers.toRoman(10));
        assertEquals("L", Numbers.toRoman(50));
        assertEquals("C", Numbers.toRoman(100));
        assertEquals("D", Numbers.toRoman(500));
        assertEquals("M", Numbers.toRoman(1000));
    }

    @Test
    void first9() {
        assertEquals("IX", Numbers.toRoman(9));
        assertEquals("I", Numbers.toRoman(1));
        assertEquals("II", Numbers.toRoman(2));
        assertEquals("III", Numbers.toRoman(3));
        assertEquals("IV", Numbers.toRoman(4));
        assertEquals("V", Numbers.toRoman(5));
        assertEquals("VI", Numbers.toRoman(6));
        assertEquals("VII", Numbers.toRoman(7));
        assertEquals("VIII", Numbers.toRoman(8));
    }

    @Test
    void some10s(){
        assertEquals("X", Numbers.toRoman(10));
        assertEquals("XIII", Numbers.toRoman(13));
        assertEquals("XLV", Numbers.toRoman(45));
        assertEquals("LXXXIV", Numbers.toRoman(84));
    }

    @Test
    void someBigNumbers(){
        assertEquals("MDCLXVI", Numbers.toRoman(1666));
    }

    @Test
    void fromRomanFirst10() {
        assertEquals(9, Numbers.fromRoman("IX"));
        assertEquals(4, Numbers.fromRoman("IV"));
        assertEquals(1, Numbers.fromRoman("I"));
        assertEquals(2, Numbers.fromRoman("II"));
        assertEquals(3, Numbers.fromRoman("III"));
        assertEquals(5, Numbers.fromRoman("V"));
        assertEquals(6, Numbers.fromRoman("VI"));
        assertEquals(7, Numbers.fromRoman("VII"));
        assertEquals(8, Numbers.fromRoman("VIII"));
        assertEquals(10, Numbers.fromRoman("X"));
    }

    @Test
    void fromRomanRandomNumbers() {
        assertEquals(2944, Numbers.fromRoman1("MMCMXLIV"));
        assertEquals(19, Numbers.fromRoman("XIX"));
    }

}