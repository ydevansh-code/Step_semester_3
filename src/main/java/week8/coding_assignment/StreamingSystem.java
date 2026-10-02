package week8.coding_assignment;

import java.time.LocalDate;
import java.util.Scanner;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    public Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
    
    public String getName() {
        return name;
    }
}

class BasicPlan extends Plan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }
    @Override
    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends Plan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }
    @Override
    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends Plan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }
    @Override
    public int getValidityDays() {
        return 365;
    }
}

public class StreamingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr);
            Plan plan = null;
            
            switch (type) {
                case "BASIC": plan = new BasicPlan(name, startDate); break;
                case "STANDARD": plan = new StandardPlan(name, startDate); break;
                case "PREMIUM": plan = new PremiumPlan(name, startDate); break;
            }
            
            if (plan != null) {
                System.out.println(plan.getName() + ": " + plan.calculateRenewalDate());
            }
        }
        scanner.close();
    }
}
