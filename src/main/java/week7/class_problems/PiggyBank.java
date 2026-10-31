package week7.class_problems;

public class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.savings) {
            this.savings -= amount;
        }
    }

    public double getSavings() {
        return this.savings;
    }

    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("deposit(100) -> savings = " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("withdraw(30) -> savings = " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("withdraw(500) -> rejected, savings stays " + pb.getSavings());
    }
}
