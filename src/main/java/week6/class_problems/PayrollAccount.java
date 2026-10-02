package week6.class_problems;

public class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: basic salary cannot be negative. Setting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Percentage must be between 0 and 100.");
        } else {
            this.basicSalary -= this.basicSalary * (percent / 100);
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
