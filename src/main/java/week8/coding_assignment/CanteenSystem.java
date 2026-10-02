package week8.coding_assignment;

import java.util.Scanner;

abstract class Customer {
    protected double billAmount;

    public Customer(double billAmount) {
        this.billAmount = billAmount;
    }

    public abstract double calculateFinalAmount();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double billAmount) {
        super(billAmount);
    }
    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.90;
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double billAmount) {
        super(billAmount);
    }
    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.95;
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double billAmount) {
        super(billAmount);
    }
    @Override
    public double calculateFinalAmount() {
        return billAmount + 10.0;
    }
}

public class CanteenSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            Customer customer = null;
            
            switch (type) {
                case "STUDENT": customer = new StudentCustomer(amount); break;
                case "STAFF": customer = new StaffCustomer(amount); break;
                case "GUEST": customer = new GuestCustomer(amount); break;
            }
            
            if (customer != null) {
                double finalAmount = customer.calculateFinalAmount();
                total += finalAmount;
                System.out.printf("%s: %.2f\n", type, finalAmount);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
