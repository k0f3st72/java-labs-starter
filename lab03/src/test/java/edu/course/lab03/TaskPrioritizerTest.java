package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskPrioritizerTest {

    @Test
    void effortPolicyReturnsHours() {
        ProjectTask task = new ProjectTask("T1", 8, false);
        assertEquals(8, new EffortPriorityPolicy().calculatePriority(task));
    }

    @Test
    void effortPolicyChoosesLarger() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new EffortPriorityPolicy());
        ProjectTask t1 = new ProjectTask("T1", 5, false);
        ProjectTask t2 = new ProjectTask("T2", 10, false);
        assertEquals(t2, prioritizer.getHighestPriority(t1, t2));
    }

    // --- Тесты для StatusPriorityPolicy ---
    @Test
    void statusPolicyReturns100ForUncompleted() {
        ProjectTask task = new ProjectTask("T1", 5, false);
        assertEquals(100, new StatusPriorityPolicy().calculatePriority(task));
    }
    
    @Test
    void statusPolicyReturns0ForCompleted() {
        ProjectTask task = new ProjectTask("T1", 5, true);
        assertEquals(0, new StatusPriorityPolicy().calculatePriority(task));
    }

    @Test
    void statusPolicyChoosesUncompleted() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new StatusPriorityPolicy());
        ProjectTask t1 = new ProjectTask("T1", 5, true);  // выполнена
        ProjectTask t2 = new ProjectTask("T2", 10, false); // не выполнена
        assertEquals(t2, prioritizer.getHighestPriority(t1, t2));
    }
}