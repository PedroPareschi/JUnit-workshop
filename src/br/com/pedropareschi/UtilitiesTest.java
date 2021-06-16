package br.com.pedropareschi;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    private static Utilities utilities;

    @org.junit.jupiter.api.BeforeEach
    public void initiate(){
        utilities = new Utilities();
    }

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        char[] chars = utilities.everyNthChar(new char[] {'h','e','l','l','o'}, 2);
        assertArrayEquals(new char[]{'e', 'l'}, chars);
    }

    @org.junit.jupiter.api.Test
    void everyNthChar_nGreaterThenLength() {
        char[] chars = utilities.everyNthChar(new char[] {'h','e','l','l','o'}, 6);
        assertArrayEquals(new char[] {'h','e','l','l','o'}, chars);
    }


    @org.junit.jupiter.api.Test
    void removePairs() {
        String test = utilities.removePairs("AABCDDEFF");
        assertEquals("ABCDEF", test);
    }

    @org.junit.jupiter.api.Test
    void removePairs_allTheSame() {
        String test = utilities.removePairs("111111111111111");
        assertEquals("1", test);
    }

    @org.junit.jupiter.api.Test
    void removePairs_oneChar() {
        String test = utilities.removePairs("1");
        assertEquals("1", test);
    }

    @org.junit.jupiter.api.Test
    void removePairs_null() {
        String test = utilities.removePairs(null);
        assertNull(test);
    }

    @org.junit.jupiter.api.Test
    void removePairs_empty() {
        String test = utilities.removePairs("");
        assertEquals("", test);
    }


    @org.junit.jupiter.api.Test
    void converter() {
        assertEquals(300, utilities.converter(10, 5));
    }

    @org.junit.jupiter.api.Test
    void converter_exception() {
        assertThrows(ArithmeticException.class, () -> {
            utilities.converter(10,0);
        });
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        assertNotNull(utilities.nullIfOddLength("even"));
        assertNull(utilities.nullIfOddLength("odd"));
    }
}