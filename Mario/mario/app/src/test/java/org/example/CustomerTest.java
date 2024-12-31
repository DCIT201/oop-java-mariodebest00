package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    void testCheckAgeEligibility() {
        Customer customer = new Customer("John Doe", 20);
        assertTrue(customer.checkAgeEligibility());

        Customer underageCustomer = new Customer("Jane", 16);
        assertFalse(underageCustomer.checkAgeEligibility());
    }
}
