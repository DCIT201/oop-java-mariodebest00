package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RentalTransactionTest {
    private RentalTransaction transaction;
    private Customer customer;
    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        // Create a customer and a vehicle for testing
        customer = new Customer("John Doe", 25);
        vehicle = new Car("C1", "Toyota Corolla", 100.0, true);
        transaction = new RentalTransaction("TX1", customer, vehicle);
    }

    @Test
    void testTransactionInitialization() {
        assertEquals("TX1", transaction.getTransactionId());
        assertEquals(customer, transaction.getCustomer());
        assertEquals(vehicle, transaction.getVehicle());
        assertFalse(transaction.isCompleted(), "Transaction should initially not be completed");
    }

    @Test
    void testSetIsCompleted() {
        // Mark transaction as completed
        transaction.setIsCompleted();
        assertTrue(transaction.isCompleted(), "Transaction should be marked as completed");
        assertTrue(vehicle.getIsAvailable(), "Vehicle should be available after transaction is completed");
    }
}
