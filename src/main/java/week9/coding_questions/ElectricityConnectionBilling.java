package week9.coding_questions;

import java.util.Locale;
import java.util.Scanner;

abstract class ElectricityConnection {
    protected double units;

    public ElectricityConnection(double units) {
        this.units = units;
    }

    public abstract String getType();
    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) {
        super(units);
    }

    @Override
    public String getType() {
        return "HOME";
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        }
        return 100 * 5.0 + (units - 100) * 7.0;
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(double units) {
        super(units);
    }

    @Override
    public String getType() {
        return "SHOP";
    }

    @Override
    public double calculateBill() {
        return units * 8.0 + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public String getType() {
        return "FACTORY";
    }

    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();
            ElectricityConnection connection = null;

            switch (type) {
                case "HOME":
                    connection = new HomeConnection(units);
                    break;
                case "SHOP":
                    connection = new ShopConnection(units);
                    break;
                case "FACTORY":
                    connection = new FactoryConnection(units);
                    break;
            }

            if (connection != null) {
                double bill = connection.calculateBill();
                total += bill;
                System.out.printf(Locale.US, "%s: %.2f\n", connection.getType(), bill);
            }
        }

        System.out.printf(Locale.US, "Total: %.2f\n", total);
        scanner.close();
    }
}
