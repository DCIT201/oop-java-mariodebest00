package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RentalAgencyTest {
    @Test
    void testAddVehicle() {
        RentalAgency agency = new RentalAgency();
        Vehicle car = new Car("C1", "Toyota", 50.0, true);
        agency.addVehicle(car);

        assertEquals(1, agency.getVehicles());
    }

    @Test
    void testRentVehicle() {
        RentalAgency agency = new RentalAgency();
        Vehicle car = new Car("C1", "Toyota", 50.0, true);
        agency.addVehicle(car);

        Customer customer = new Customer("John", 25);
        agency.rentVehicle("C1", customer, 3);

        assertFalse(car.getIsAvailable());
    }
}
