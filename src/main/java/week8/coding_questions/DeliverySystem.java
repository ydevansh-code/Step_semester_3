package week8.coding_questions;

import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }
    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }
    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;
    
    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }
    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class DeliverySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            Delivery delivery = null;
            
            switch (type) {
                case "STANDARD":
                    delivery = new StandardDelivery(weight, distance);
                    break;
                case "EXPRESS":
                    delivery = new ExpressDelivery(weight, distance);
                    break;
                case "INTERNATIONAL":
                    double customsFee = scanner.nextDouble();
                    delivery = new InternationalDelivery(weight, distance, customsFee);
                    break;
            }
            
            if (delivery != null) {
                double fee = delivery.calculateFee();
                total += fee;
                System.out.printf("%s: %.2f\n", type, fee);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
