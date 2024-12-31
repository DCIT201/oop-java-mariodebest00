package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RentalAgency {
    private List<RentalTransaction> transactions;
    private List<Vehicle> vehicles;

    public RentalAgency() {
        this.transactions = new ArrayList<>();
        this.vehicles = new ArrayList<>();
    }

    // Add a vehicle to the agency's fleet
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added: " + vehicle.getModel());
    }

    // Rent a vehicle to a customer
    public void rentVehicle(String vehicleId, Customer customer, int days) {
        Vehicle vehicle = findVehicleById(vehicleId);

        if (vehicle == null) {
            System.out.println("Vehicle with ID " + vehicleId + " not found.");
            return;
        }

        if (!vehicle.isAvailableForRental()) {
            System.out.println("Vehicle " + vehicle.getModel() + " is not available for rental.");
            return;
        }

        RentalTransaction transaction = new RentalTransaction(
                "TX-" + (transactions.size() + 1), customer, vehicle);
        transactions.add(transaction);

        vehicle.rent(customer, days);
        System.out.println("Transaction created: " + transaction.getTransactionId());
    }

    // Return a rented vehicle
    public void returnVehicle(String transactionId) {
        RentalTransaction transaction = findTransactionById(transactionId);

        if (transaction == null) {
            System.out.println("Transaction with ID " + transactionId + " not found.");
            return;
        }

        if (transaction.isCompleted()) {
            System.out.println("Transaction " + transactionId + " is already completed.");
            return;
        }

        transaction.setIsCompleted();
        System.out.println("Vehicle returned for transaction: " + transactionId);
    }

    // View all vehicles
    public void viewVehicles() {
        System.out.println("Vehicles in fleet:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    // View all transactions
    public void viewTransactions() {
        System.out.println("Rental transactions:");
        for (RentalTransaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    // Helper method to find a vehicle by ID
    private Vehicle findVehicleById(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    // Helper method to find a transaction by ID
    private RentalTransaction findTransactionById(String transactionId) {
        for (RentalTransaction transaction : transactions) {
            if (transaction.getTransactionId().equals(transactionId)) {
                return transaction;
            }
        }
        return null;
    }

    public int getVehicles() {
        return vehicles.size();
    }
}
