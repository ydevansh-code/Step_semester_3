package week6.practice_problems;

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
        pb.withdraw(30);
        pb.withdraw(500);
        System.out.println("savings = " + pb.getSavings());
    }
}
