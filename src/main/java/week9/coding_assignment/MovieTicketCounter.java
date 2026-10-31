package week9.coding_assignment;

import java.util.Locale;
import java.util.Scanner;

abstract class Ticket {
    protected static final double CONVENIENCE_FEE = 20.0;
    protected int count;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract String getSeatType();
    public abstract double getBasePrice();

    public double calculateTotal() {
        return (getBasePrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }

    @Override
    public double getBasePrice() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }

    @Override
    public double getBasePrice() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }

    @Override
    public double getBasePrice() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();
            Ticket ticket = null;

            switch (seat) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
            }

            if (ticket != null) {
                double amount = ticket.calculateTotal();
                grandTotal += amount;
                System.out.printf(Locale.US, "%s: %.2f\n", ticket.getSeatType(), amount);
            }
        }

        System.out.printf(Locale.US, "Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
