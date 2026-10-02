package week8.coding_questions;

import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowingPeriod();

    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getBorrowingPeriod());
    }
    
    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }
    @Override
    public int getBorrowingPeriod() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }
    @Override
    public int getBorrowingPeriod() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }
    @Override
    public int getBorrowingPeriod() {
        return 3;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int firstSpace = line.indexOf(' ');
            if (firstSpace == -1) continue;
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).replace("\"", "");
            
            LibraryItem item = null;
            switch (type) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title);
                    break;
            }
            
            if (item != null) {
                LocalDate dueDate = item.calculateDueDate(currentDate);
                System.out.println(item.getTitle() + ": " + dueDate);
            }
        }
        scanner.close();
    }
}
