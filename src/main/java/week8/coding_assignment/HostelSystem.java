package week8.coding_assignment;

import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }
    @Override
    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    private int occupants;
    
    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }
    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }
    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class HostelSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            Room room = null;
            
            switch (type) {
                case "SINGLE": room = new SingleRoom(units); break;
                case "SHARED": 
                    int occupants = scanner.nextInt();
                    room = new SharedRoom(units, occupants); 
                    break;
                case "AC": room = new ACRoom(units); break;
            }
            
            if (room != null) {
                double bill = room.calculateBill();
                total += bill;
                System.out.printf("%s: %.2f\n", type, bill);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
