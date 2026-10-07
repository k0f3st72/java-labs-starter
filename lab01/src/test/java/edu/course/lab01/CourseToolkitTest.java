package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
    assertTrue(CourseToolkit.isEven(-8));
    }

    @Test
    void returnsTrueForPrimeNumber() {
    assertTrue(CourseToolkit.isPrime(7));
    }

    @Test
    void returnsTrueForTwo() {
    assertTrue(CourseToolkit.isPrime(2));
    }

    @Test
    void returnsFalseForCompositeNumber() {
    assertFalse(CourseToolkit.isPrime(12));
    }

    @Test
    void returnsFalseForNumberLessThanTwo() {
    assertFalse(CourseToolkit.isPrime(1));
    assertFalse(CourseToolkit.isPrime(0));
    assertFalse(CourseToolkit.isPrime(-5));
    }

    @Test
    void returnsTrueForPalindrome() {
    assertTrue(CourseToolkit.isPalindrome("level"));
    }

    @Test
    void returnsFalseForNonPalindrome() {
    assertFalse(CourseToolkit.isPalindrome("hello"));
    }

    @Test
    void nullPalindromeThrowsException() {
    assertThrows(
            IllegalArgumentException.class,
            () -> CourseToolkit.isPalindrome(null)
        );
    }

    @Test
    void averageReturnsCorrectResult() {
    assertEquals(2.5, CourseToolkit.average(new int[]{1, 2, 3, 4}));
    }

    @Test
    void averageWorksWithNegativeNumbers() {
    assertEquals(-2.0, CourseToolkit.average(new int[]{-1, -2, -3}));
    }

    @Test
    void averageDoesNotModifyArray() {
    int[] values = {1, 2, 3};

    CourseToolkit.average(values);

    assertArrayEquals(new int[]{1, 2, 3}, values);
    }

    @Test
    void averageWithNullThrowsException() {
    assertThrows(
            IllegalArgumentException.class,
            () -> CourseToolkit.average(null)
        );
    }

    @Test
    void averageWithEmptyArrayThrowsException() {
    assertThrows(
            IllegalArgumentException.class,
            () -> CourseToolkit.average(new int[]{})
        );
    }
}
