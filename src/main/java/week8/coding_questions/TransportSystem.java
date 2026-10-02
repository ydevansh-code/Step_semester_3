package week8.coding_questions;

import java.util.Scanner;

abstract class Journey {
    protected double distance;

    public Journey(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
}

class BusJourney extends Journey {
    public BusJourney(double distance) {
        super(distance);
    }
    @Override
    public double calculateFare() {
        return Math.min(10.0, 2.0 + 0.10 * distance);
    }
}

class TrainJourney extends Journey {
    public TrainJourney(double distance) {
        super(distance);
    }
    @Override
    public double calculateFare() {
        return 3.0 + 0.15 * distance;
    }
}

class MetroJourney extends Journey {
    private double peakHourFactor;
    
    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }
    @Override
    public double calculateFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            Journey journey = null;
            
            switch (type) {
                case "BUS":
                    journey = new BusJourney(distance);
                    break;
                case "TRAIN":
                    journey = new TrainJourney(distance);
                    break;
                case "METRO":
                    double factor = scanner.nextDouble();
                    journey = new MetroJourney(distance, factor);
                    break;
            }
            
            if (journey != null) {
                double fare = journey.calculateFare();
                total += fare;
                System.out.printf("%s: %.2f\n", type, fare);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
