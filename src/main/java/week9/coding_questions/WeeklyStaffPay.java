package week9.coding_questions;

import java.util.Locale;
import java.util.Scanner;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * 1.5 * rate;
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            Staff staff = null;

            switch (type) {
                case "FULLTIME":
                    double salary = scanner.nextDouble();
                    staff = new FullTimeStaff(name, salary);
                    break;
                case "HOURLY":
                    double hours = scanner.nextDouble();
                    double rate = scanner.nextDouble();
                    staff = new HourlyStaff(name, hours, rate);
                    break;
                case "INTERN":
                    double stipend = scanner.nextDouble();
                    staff = new InternStaff(name, stipend);
                    break;
            }

            if (staff != null) {
                double pay = staff.calculatePay();
                totalPayroll += pay;
                System.out.printf(Locale.US, "%s: %.2f\n", staff.getName(), pay);
            }
        }

        System.out.printf(Locale.US, "Total Payroll: %.2f\n", totalPayroll);
        scanner.close();
    }
}
