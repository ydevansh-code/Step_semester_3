package week6.class_problems;

public class CompanyEmployee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        System.out.println("3 Employee objects created");
        new CompanyEmployee("A", 1000);
        new CompanyEmployee("B", 2000);
        new CompanyEmployee("C", 3000);
        CompanyEmployee.printCompanyInfo();
    }
}
