package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotocycleTest {
    @Test
    void testCalculateRentalCost() {
        Vehicle motocycle = new Motocycle("C1", "Sonic", 50.0);
        assertEquals(283.0, motocycle.calculateRentalCost(5));
    }

    @Test
    void testAvailability() {
        Vehicle motorcycle = new Motocycle("M1", "Sonic", 30.0);
        assertTrue(motorcycle.getIsAvailable());
        motorcycle.setIsAvailable(false);
        assertFalse(motorcycle.getIsAvailable());
    }
}

