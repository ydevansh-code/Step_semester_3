package week9.coding_assignment;

import java.util.Locale;
import java.util.Scanner;

interface EnergySaver {
}

abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract String getType();
    public abstract double getPowerRating();

    public boolean supportsSaverMode() {
        return this instanceof EnergySaver;
    }

    public double calculateUnits(boolean saverMode) {
        double units = (getPowerRating() * hours) / 1000.0;
        if (saverMode) {
            units *= 0.75;
        }
        return units;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "FRIDGE";
    }

    @Override
    public double getPowerRating() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements EnergySaver {
    public AirConditioner(double hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "AC";
    }

    @Override
    public double getPowerRating() {
        return 1500.0;
    }
}

class Television extends Appliance {
    public Television(double hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "TV";
    }

    @Override
    public double getPowerRating() {
        return 100.0;
    }
}

class WashingMachine extends Appliance implements EnergySaver {
    public WashingMachine(double hours) {
        super(hours);
    }

    @Override
    public String getType() {
        return "WASHER";
    }

    @Override
    public double getPowerRating() {
        return 500.0;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            while (line.isEmpty() && scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
            }
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = parts.length > 2 && "SAVER".equalsIgnoreCase(parts[2]);

            Appliance appliance = null;
            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours);
                    break;
                case "TV":
                    appliance = new Television(hours);
                    break;
                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;
            }

            if (appliance != null) {
                if (saverRequested && !appliance.supportsSaverMode()) {
                    System.out.printf("%s: saver mode not supported\n", appliance.getType());
                } else {
                    double units = appliance.calculateUnits(saverRequested);
                    double cost = appliance.calculateCost(units);
                    totalCost += cost;
                    System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f\n", appliance.getType(), units, cost);
                }
            }
        }

        System.out.printf(Locale.US, "Total Cost: %.2f\n", totalCost);
        scanner.close();
    }
}
