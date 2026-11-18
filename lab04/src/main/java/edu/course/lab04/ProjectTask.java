package edu.course.lab04;

import java.util.Objects;

public final class ProjectTask {

    private final String description;
    private final int priority;

    public ProjectTask(String description, int priority) {
        this.description = Objects.requireNonNull(description, "description");
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectTask)) return false;
        ProjectTask that = (ProjectTask) o;
        return priority == that.priority && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, priority);
    }

    @Override
    public String toString() {
        return "ProjectTask{description='" + description + "', priority=" + priority + "}";
    }
}