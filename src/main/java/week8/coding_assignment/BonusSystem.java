package week8.coding_assignment;

import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public abstract double calculateBonus();
    
    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }
    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }
    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {
    public Intern(String name, double salary) {
        super(name, salary);
    }
    @Override
    public double calculateBonus() {
        return 2000.0;
    }
}

public class BonusSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            Employee employee = null;
            
            switch (type) {
                case "FULLTIME": employee = new FullTimeEmployee(name, salary); break;
                case "PARTTIME": employee = new PartTimeEmployee(name, salary); break;
                case "INTERN": employee = new Intern(name, salary); break;
            }
            
            if (employee != null) {
                double bonus = employee.calculateBonus();
                total += bonus;
                System.out.printf("%s: %.2f\n", name, bonus);
            }
        }
        System.out.printf("Total Bonus: %.2f\n", total);
        scanner.close();
    }
}
