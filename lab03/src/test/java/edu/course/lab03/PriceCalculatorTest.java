package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    @Test
    void noDiscountReturnsSamePrice() {
        PriceCalculator calc = new PriceCalculator(new NoDiscount());
        assertEquals(100, calc.calculate(100));
    }

    @Test
    void percentDiscountWorks() {
        PriceCalculator calc = new PriceCalculator(new PercentDiscount(20));
        assertEquals(80, calc.calculate(100));
    }

    @Test
    void canReplacePolicy() {
        PriceCalculator calc = new PriceCalculator(new NoDiscount());
        assertEquals(100, calc.calculate(100));
        
        // Меняем политику - и результат меняется!
        PriceCalculator calc2 = new PriceCalculator(new PercentDiscount(50));
        assertEquals(50, calc2.calculate(100));
    }
    
    @Test
    void negativePriceThrows() {
        PriceCalculator calc = new PriceCalculator(new NoDiscount());
        assertThrows(IllegalArgumentException.class, () -> calc.calculate(-10));
    }
}