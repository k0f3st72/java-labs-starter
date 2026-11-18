package edu.course.lab04;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация работы IssueRegistry ===");
        
        IssueRegistry registry = new IssueRegistry();
            
        ProjectTask task1 = new ProjectTask("Исправить баг с оплатой", 1);
        ProjectTask task2 = new ProjectTask("Добавить кнопку 'Назад'", 2);

        IssueId id1 = new IssueId("SHOP", 101);
        registry.put(id1, task1);
        registry.put(new IssueId("SHOP", 102), task2);

        System.out.println("Размер реестра после добавления: " + registry.size());

        IssueId searchId = new IssueId("SHOP", 101);
        System.out.println("Поиск задачи SHOP-101...");
        
        ProjectTask found = registry.get(searchId).orElse(null);
        if (found != null) {
            System.out.println("Найдено: " + found.getDescription());
        } else {
            System.out.println("Задача не найдена (это было бы ошибкой).");
        }

        System.out.println("\n=== Демонстрация проблемы с изменяемым ключом ===");
        
        class BadKey {
            String code;
            int num;
            BadKey(String code, int num) { this.code = code; this.num = num; }
            
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                BadKey badKey = (BadKey) o;
                return num == badKey.num && code.equals(badKey.code);
            }
            
            @Override
            public int hashCode() {
                return 31 * code.hashCode() + num;
            }
        }

        Map<BadKey, String> map = new HashMap<>();
        BadKey mutableKey = new BadKey("USERS", 1);
        map.put(mutableKey, "Значение");

        System.out.println("До изменения ключа: " + map.get(new BadKey("USERS", 1)));

        mutableKey.num = 2;

        System.out.println("После изменения ключа (по старым данным): " + map.get(new BadKey("USERS", 1)));
        System.out.println("Размер мапы (объект все еще там, но 'потерян'): " + map.size());
    }
}