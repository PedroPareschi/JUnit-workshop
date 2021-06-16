package br.com.pedropareschi;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilitiesTestParameters {
    private static Utilities utilities;

    @BeforeEach
    public void initiateUtilities(){
        utilities = new Utilities();
    }

    @ParameterizedTest
    @MethodSource("testRemovePairs")
    void removePairs(String source, String expected){
        String result = utilities.removePairs(source);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> testRemovePairs(){
       return Stream.of(Arguments.of("ABCDEFF", "ABCDEF"),
                Arguments.of("AB88EFFG", "AB8EFG"),
                Arguments.of("112233445566", "123456"),
                Arguments.of("ZYZQQB", "ZYZQB"),
                Arguments.of("A", "A"));
    }
}
