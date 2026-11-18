package edu.course.lab04;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IssueRegistryTest {

    @Test
    void equalKeyFromAnotherInstanceFindsValue() {
        IssueRegistry reg = new IssueRegistry();
        reg.put(new IssueId("PROJ", 1), new ProjectTask("Init", 1));

        Optional<ProjectTask> found = reg.get(new IssueId("PROJ", 1));

        assertTrue(found.isPresent());
        assertEquals("Init", found.get().getDescription());
    }

    @Test
    void reinsertWithEqualKeyReplacesAndDoesNotGrow() {
        IssueRegistry reg = new IssueRegistry();
        ProjectTask first = new ProjectTask("Old", 1);
        ProjectTask second = new ProjectTask("New", 2);

        assertNull(reg.put(new IssueId("PROJ", 1), first));
        assertEquals(1, reg.size());

        ProjectTask previous = reg.put(new IssueId("PROJ", 1), second);
        assertEquals(first, previous);
        assertEquals(1, reg.size());

        assertEquals(second, reg.get(new IssueId("PROJ", 1)).orElseThrow());
    }

    @Test
    void collidingButDifferentKeysKeepDistinctValues() {
        IssueId k1 = new CollidingIssueId("PROJ", 1);
        IssueId k2 = new CollidingIssueId("PROJ", 2);

        assertNotEquals(k1, k2);
        assertEquals(k1.hashCode(), k2.hashCode(), "Ожидалась коллизия хешей");

        IssueRegistry reg = new IssueRegistry();
        reg.put(k1, new ProjectTask("First", 1));
        reg.put(k2, new ProjectTask("Second", 2));

        assertEquals(2, reg.size());
        assertEquals("First", reg.get(k1).orElseThrow().getDescription());
        assertEquals("Second", reg.get(k2).orElseThrow().getDescription());
    }

    @Test
    void removeAndContains() {
        IssueRegistry reg = new IssueRegistry();
        IssueId id = new IssueId("PROJ", 5);
        reg.put(id, new ProjectTask("Task", 3));

        assertTrue(reg.containsKey(new IssueId("PROJ", 5)));
        assertTrue(reg.remove(new IssueId("PROJ", 5)).isPresent());
        assertFalse(reg.containsKey(id));
        assertEquals(0, reg.size());
    }

    /** Ключ с намеренно плохим, но контрактно-валидным hashCode. */
    private static final class CollidingIssueId extends IssueId {
        CollidingIssueId(String projectCode, int number) {
            super(projectCode, number);
        }

        @Override
        public int hashCode() {
            return 7;
        }
    }
}