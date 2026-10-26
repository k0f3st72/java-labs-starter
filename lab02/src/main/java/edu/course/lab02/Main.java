package edu.course.lab02;

public class Main {
    public static void main(String[] args) {
        System.out.println("##### Проверка BankAccount #####");
        
        BankAccount acc = new BankAccount(100);
        System.out.println("Начальный баланс: " + acc.getBalance());

        acc.deposit(50);
        System.out.println("После пополнения на 50: " + acc.getBalance());

        acc.withdraw(30);
        System.out.println("После снятия 30: " + acc.getBalance());
        
        try {
            acc.withdraw(1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при снятии 1000: " + e.getMessage());
        }


        System.out.println("##### Проверка ProjectTask #####");
        
        ProjectTask task = new ProjectTask("2", "Сделать лабу", 5);
        System.out.println("Задача создана: " + task.getTitle() + ", часы: " + task.getEstimatedHours());
        System.out.println("Выполнена? " + task.isCompleted());

        task.increaseEstimate(3);
        System.out.println("После добавления 3 часов: " + task.getEstimatedHours());

        task.changeStatus(TaskStatus.DONE);
        System.out.println("Новый статус: " + task.getStatus());
        System.out.println("Выполнена? " + task.isCompleted());
    }
}