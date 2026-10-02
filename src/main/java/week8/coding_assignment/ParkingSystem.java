package week8.coding_assignment;

import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }
    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }
    @Override
    public double calculateCharge() {
        if (hours == 0) return 0;
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }
    @Override
    public double calculateCharge() {
        return Math.max(100.0, hours * 50.0);
    }
}

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            Vehicle vehicle = null;
            
            switch (type) {
                case "BIKE": vehicle = new Bike(hours); break;
                case "CAR": vehicle = new Car(hours); break;
                case "TRUCK": vehicle = new Truck(hours); break;
            }
            
            if (vehicle != null) {
                double charge = vehicle.calculateCharge();
                total += charge;
                System.out.printf("%s: %.2f\n", type, charge);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
