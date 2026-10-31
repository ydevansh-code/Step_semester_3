package week9.coding_assignment;

import java.util.Locale;
import java.util.Scanner;

interface NightServiceable {
}

abstract class Cab {
    protected double distance;

    public Cab(double distance) {
        this.distance = distance;
    }

    public abstract String getType();
    public abstract double getRatePerKm();

    public double calculateBaseFare() {
        return Math.max(100.0, distance * getRatePerKm());
    }

    public boolean supportsNightService() {
        return this instanceof NightServiceable;
    }

    public double calculateFare(boolean isNight) {
        double fare = calculateBaseFare();
        if (isNight) {
            fare *= 1.20;
        }
        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double distance) {
        super(distance);
    }

    @Override
    public String getType() {
        return "MINI";
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double distance) {
        super(distance);
    }

    @Override
    public String getType() {
        return "SEDAN";
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }
}

class SuvCab extends Cab implements NightServiceable {
    public SuvCab(double distance) {
        super(distance);
    }

    @Override
    public String getType() {
        return "SUV";
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double distance = scanner.nextDouble();
            String time = scanner.next();
            boolean isNight = "NIGHT".equalsIgnoreCase(time);

            Cab cab = null;
            switch (cabType) {
                case "MINI":
                    cab = new MiniCab(distance);
                    break;
                case "SEDAN":
                    cab = new SedanCab(distance);
                    break;
                case "SUV":
                    cab = new SuvCab(distance);
                    break;
            }

            if (cab != null) {
                if (isNight && !cab.supportsNightService()) {
                    System.out.printf("%s: night service not available\n", cab.getType());
                } else {
                    double fare = cab.calculateFare(isNight);
                    total += fare;
                    System.out.printf(Locale.US, "%s: %.2f\n", cab.getType(), fare);
                }
            }
        }

        System.out.printf(Locale.US, "Total: %.2f\n", total);
        scanner.close();
    }
}
