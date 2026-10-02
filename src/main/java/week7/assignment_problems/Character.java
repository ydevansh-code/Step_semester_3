package week7.assignment_problems;

public class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            this.health = Math.max(0, this.health - amount);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            this.health = Math.min(this.maxHealth, this.health + amount);
        }
    }

    public int getHealth() {
        return this.health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("health = " + c.getHealth());
        c.heal(50);
        System.out.println("health = " + c.getHealth() + " (capped)");
        c.takeDamage(150);
        System.out.println("health = " + c.getHealth() + " (floored)");
    }
}
