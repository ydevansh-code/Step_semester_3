package week9.coding_questions;

import java.util.Locale;
import java.util.Scanner;

abstract class TravelBooking {
    protected static final double BOOKING_FEE = 50.0;
    protected double distanceKm;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract String getMode();
    public abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "BUS";
    }

    @Override
    public double calculateBaseFare() {
        return 2.0 * distanceKm;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }

    @Override
    public double calculateBaseFare() {
        return 1.5 * distanceKm;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + 4.0 * distanceKm;
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distanceKm = scanner.nextDouble();
            TravelBooking booking = null;

            switch (mode) {
                case "BUS":
                    booking = new BusBooking(distanceKm);
                    break;
                case "TRAIN":
                    booking = new TrainBooking(distanceKm);
                    break;
                case "FLIGHT":
                    booking = new FlightBooking(distanceKm);
                    break;
            }

            if (booking != null) {
                double totalFare = booking.calculateTotalFare();
                System.out.printf(Locale.US, "%s: %.2f\n", booking.getMode(), totalFare);
            }
        }

        scanner.close();
    }
}
