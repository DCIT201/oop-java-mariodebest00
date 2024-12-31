package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void testCalculateRentalCost() {
        Vehicle car = new Car("C1", "Toyota", 50.0, true);
        assertEquals(250.0, car.calculateRentalCost(5));
    }

    @Test
    void testAvailability() {
        Vehicle motorcycle = new Motocycle("C1", "Yaris", 30.0);
        assertTrue(motorcycle.getIsAvailable());
        motorcycle.setIsAvailable(false);
        assertFalse(motorcycle.getIsAvailable());
    }
}

