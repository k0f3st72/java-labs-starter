package edu.course.lab03;

public class EffortPriorityPolicy implements PriorityPolicy {
    @Override
    public int calculatePriority(ProjectTask task) {
        // Чем больше часов, тем выше приоритет
        return task.getEstimatedHours();
    }
}