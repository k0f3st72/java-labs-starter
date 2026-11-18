package edu.course.lab04;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public final class IssueRegistry {

    private final Map<IssueId, ProjectTask> store = new HashMap<>();

    public ProjectTask put(IssueId id, ProjectTask task) {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(task, "task");
        return store.put(id, task);
    }

    public Optional<ProjectTask> get(IssueId id) {
        Objects.requireNonNull(id, "id");
        return Optional.ofNullable(store.get(id));
    }

    public Optional<ProjectTask> remove(IssueId id) {
        Objects.requireNonNull(id, "id");
        return Optional.ofNullable(store.remove(id));
    }

    /** Проверить наличие ключа. */
    public boolean containsKey(IssueId id) {
        Objects.requireNonNull(id, "id");
        return store.containsKey(id);
    }

    public int size() {
        return store.size();
    }

    public void clear() {
        store.clear();
    }
}