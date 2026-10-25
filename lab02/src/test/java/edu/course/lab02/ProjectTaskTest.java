package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjectTaskTest {

    @Test
    void createsValidTask() {
        ProjectTask t = new ProjectTask("T-1", "Docs", 8);
        assertEquals("T-1", t.getId());
        assertEquals(8, t.getEstimatedHours());
        assertFalse(t.isCompleted());
    }

    @Test
    void changeStatusWorks() {
        ProjectTask t = new ProjectTask("T-1", "Docs", 8);
        t.changeStatus(TaskStatus.DONE);
        assertTrue(t.isCompleted());
    }

    @Test
    void increaseEstimateWorks() {
        ProjectTask t = new ProjectTask("T-1", "Docs", 8);
        t.increaseEstimate(2);
        assertEquals(10, t.getEstimatedHours());
    }

    @Test
    void emptyIdThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("", "Docs", 8));
    }

    @Test
    void negativeHoursThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("T-1", "Docs", -1));
    }

    @Test
    void increaseByZeroThrows() {
        ProjectTask t = new ProjectTask("T-1", "Docs", 8);
        assertThrows(IllegalArgumentException.class,
                () -> t.increaseEstimate(0));
    }
}