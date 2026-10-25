package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void depositWorks() {
        BankAccount acc = new BankAccount(0);
        acc.deposit(50);
        assertEquals(50, acc.getBalance());
    }

    @Test
    void successfulWithdraw() {
        BankAccount acc = new BankAccount(100);
        acc.withdraw(30);
        assertEquals(70, acc.getBalance());
    }

    @Test
    void withdrawTooMuchThrows() {
        BankAccount acc = new BankAccount(50);
        assertThrows(IllegalArgumentException.class,
                () -> acc.withdraw(100));
    }

    @Test
    void negativeInitialBalanceThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount(-10));
    }

    @Test
    void negativeDepositThrows() {
        BankAccount acc = new BankAccount(100);
        assertThrows(IllegalArgumentException.class,
                () -> acc.deposit(-5));
    }
}