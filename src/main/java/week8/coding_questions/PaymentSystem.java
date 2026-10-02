package week8.coding_questions;

import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAdjustedAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }
    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }
    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }
    @Override
    public double calculateAdjustedAmount() {
        return amount;
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            Payment payment = null;
            
            switch (type) {
                case "CARD":
                    payment = new CardPayment(amount);
                    break;
                case "WALLET":
                    payment = new WalletPayment(amount);
                    break;
                case "BANKTRANSFER":
                    payment = new BankTransferPayment(amount);
                    break;
            }
            
            if (payment != null) {
                double adjusted = payment.calculateAdjustedAmount();
                total += adjusted;
                System.out.printf("%s: %.2f\n", type, adjusted);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
