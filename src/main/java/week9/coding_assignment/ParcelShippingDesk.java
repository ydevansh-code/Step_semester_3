package week9.coding_assignment;

import java.util.Locale;
import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract String getType();
    public abstract double calculateCharge();

    public double getInsurance() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance();
        }
        return 0.0;
    }

    public double calculateTotal() {
        return calculateCharge() + getInsurance();
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }

    @Override
    public double calculateCharge() {
        return 40.0 + 10.0 * weightKg;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }

    @Override
    public double calculateCharge() {
        return 80.0 + 15.0 * weightKg;
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public String getType() {
        return "FRAGILE";
    }

    @Override
    public double calculateCharge() {
        return (40.0 + 10.0 * weightKg) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weightKg = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();
            Parcel parcel = null;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weightKg, declaredValue);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(weightKg, declaredValue);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(weightKg, declaredValue);
                    break;
            }

            if (parcel != null) {
                double charge = parcel.calculateCharge();
                double insurance = parcel.getInsurance();
                double total = parcel.calculateTotal();
                grandTotal += total;
                System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f\n",
                        parcel.getType(), charge, insurance, total);
            }
        }

        System.out.printf(Locale.US, "Grand Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
