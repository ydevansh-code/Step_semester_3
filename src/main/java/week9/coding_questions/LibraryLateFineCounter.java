package week9.coding_questions;

import java.util.Locale;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(50.0, daysLate * 5.0);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double totalFines = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();
            LibraryItem item = null;

            switch (type) {
                case "BOOK":
                    item = new BookItem(title, daysLate);
                    break;
                case "DVD":
                    item = new DvdItem(title, daysLate);
                    break;
                case "MAGAZINE":
                    item = new MagazineItem(title, daysLate);
                    break;
            }

            if (item != null) {
                double fine = item.calculateFine();
                totalFines += fine;
                System.out.printf(Locale.US, "%s: %.2f\n", item.getTitle(), fine);
            }
        }

        System.out.printf(Locale.US, "Total Fines: %.2f\n", totalFines);
        scanner.close();
    }
}
