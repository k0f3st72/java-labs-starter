package edu.course.lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IssueIdTest {

    @Test
    void equalIdsHaveEqualHashCode() {
        IssueId a = new IssueId("PROJ", 42);
        IssueId b = new IssueId("PROJ", 42);

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void differentIdsAreNotEqual() {
        assertNotEquals(new IssueId("PROJ", 42), new IssueId("PROJ", 43));
        assertNotEquals(new IssueId("PROJ", 42), new IssueId("OTHER", 42));
    }

    @Test
    void equalsNullAndOtherType() {
        IssueId a = new IssueId("PROJ", 1);
        assertFalse(a.equals(null));
        assertFalse(a.equals("PROJ-1"));
        assertFalse(a.equals(new Object()));
    }
}