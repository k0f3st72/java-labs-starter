package edu.course.lab03;

public class TaskPrioritizer {
    private final PriorityPolicy policy;

    public TaskPrioritizer(PriorityPolicy policy) {
        this.policy = policy;
    }

    public ProjectTask getHighestPriority(ProjectTask t1, ProjectTask t2) {
        int p1 = policy.calculatePriority(t1);
        int p2 = policy.calculatePriority(t2);
        return p1 >= p2 ? t1 : t2;
    }
}