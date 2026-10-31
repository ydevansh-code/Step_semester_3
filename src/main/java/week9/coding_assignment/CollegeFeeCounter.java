package week9.coding_assignment;

import java.util.Locale;
import java.util.Scanner;

interface BusServiceUser {
    double TRANSPORT_FEE = 12000.0;
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBaseFee();

    public double calculateTotalFee() {
        double fee = calculateBaseFee();
        if (this instanceof BusServiceUser) {
            fee += BusServiceUser.TRANSPORT_FEE;
        }
        return fee;
    }
}

class DayScholar extends Student implements BusServiceUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 40000.0;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements BusServiceUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateBaseFee() {
        return 20000.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            Student student = null;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
            }

            if (student != null) {
                double fee = student.calculateTotalFee();
                totalCollected += fee;
                System.out.printf(Locale.US, "%s: %.2f\n", student.getName(), fee);
            }
        }

        System.out.printf(Locale.US, "Total Collected: %.2f\n", totalCollected);
        scanner.close();
    }
}
