package hu.progmatic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodingBatTest {

    @Test
    void name() {
        assertEquals("oz", CodingBat.startOz("ozymandias"));
        assertEquals("z", CodingBat.startOz("bzoo"));
        assertEquals("o", CodingBat.startOz("oxx"));
    }

    @Test
    void test() {
        assertEquals("ChoCho", CodingBat.frontTimes("Chocolade", 2));
    }

    @Test
    void mirrorTest() {
        assertEquals("ab", CodingBat.mirrorEnds("abXYZba"));
    }

    @Test
    void swapTest() {
        assertArrayEquals(new String[]{"ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"}, CodingBat.swap(new String[]{"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"}));
    }

    @Test
    void boolean3() {
        assertEquals(2, CodingBat.createChocalateBar(3, 2, 7));
    }
}