package edu.course.lab04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void equalBooksFoundInHashMapByAnotherInstance() {
        Book key = new Book("978-3-16-148410-0", "Effective Java");
        Map<Book, String> map = new HashMap<>();
        map.put(key, "shelf-A");

        Book sameIsbn = new Book("978-3-16-148410-0", "Effective Java 3rd ed.");

        assertEquals("shelf-A", map.get(sameIsbn));
        assertEquals(key, sameIsbn);
        assertEquals(key.hashCode(), sameIsbn.hashCode());
    }

    @Test
    void booksWithDifferentIsbnAreNotEqual() {
        Book a = new Book("111", "A");
        Book b = new Book("222", "A");

        assertNotEquals(a, b);
        assertFalse(a.equals(b));
    }

    @Test
    void equalsNullAndOtherType() {
        Book a = new Book("111", "A");
        assertFalse(a.equals(null));
        assertFalse(a.equals("111"));
    }
}