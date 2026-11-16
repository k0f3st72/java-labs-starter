package edu.course.lab03;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("========== ПРОВЕРКА СКИДОК ==========");
        
        // 1. Создаем разные стратегии скидок
        DiscountPolicy noDiscount = new NoDiscount();
        DiscountPolicy twentyPercent = new PercentDiscount(20);
        
        // 2. Передаем их в калькулятор
        PriceCalculator calc1 = new PriceCalculator(noDiscount);
        PriceCalculator calc2 = new PriceCalculator(twentyPercent);
        
        // 3. Считаем цену 100 рублей
        System.out.println("Цена 100 без скидки: " + calc1.calculate(100));
        System.out.println("Цена 100 со скидкой 20%: " + calc2.calculate(100));

        System.out.println("\n========== ПРОВЕРКА ПРИОРИТЕТОВ ==========");
        
        // 4. Создаем две задачи
        ProjectTask task1 = new ProjectTask("T-1", 5, false);
        ProjectTask task2 = new ProjectTask("T-2", 10, true);
        
        System.out.println("Задача 1 (T-1): " + task1.getEstimatedHours() + " ч., выполнена: " + task1.isCompleted());
        System.out.println("Задача 2 (T-2): " + task2.getEstimatedHours() + " ч., выполнена: " + task2.isCompleted());

        // 5. Сравниваем по количеству часов (EffortPriorityPolicy)
        TaskPrioritizer effortPrioritizer = new TaskPrioritizer(new EffortPriorityPolicy());
        ProjectTask winnerByEffort = effortPrioritizer.getHighestPriority(task1, task2);
        
        System.out.println("\nСравнение по часам (EffortPriorityPolicy):");
        System.out.println("Победила задача " + winnerByEffort.getId() + " (у неё больше часов)");

        // 6. Сравниваем по статусу (StatusPriorityPolicy)
        TaskPrioritizer statusPrioritizer = new TaskPrioritizer(new StatusPriorityPolicy());
        ProjectTask winnerByStatus = statusPrioritizer.getHighestPriority(task1, task2);
        
        System.out.println("\nСравнение по статусу (StatusPriorityPolicy):");
        System.out.println("Победила задача " + winnerByStatus.getId() + " (она ещё не выполнена)");
        
        System.out.println("\n========== КОНЕЦ ПРОВЕРКИ ==========");
    }
}