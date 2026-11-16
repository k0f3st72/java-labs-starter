package edu.course.lab03;

public class StatusPriorityPolicy implements PriorityPolicy {
    @Override
    public int calculatePriority(ProjectTask task) {
        return task.isCompleted() ? 0 : 100;
    }
}