package week1.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        playerMove = playerMove.toLowerCase();
        computerMove = computerMove.toLowerCase();
        
        if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
            (playerMove.equals("paper") && computerMove.equals("rock")) ||
            (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"Rock", "Paper", "Scissors"};
        
        int n = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;
        
        System.out.println("Starting Rock-Paper-Scissors match!");
        
        for (int i = 1; i <= n; i++) {
            int computerIndex = random.nextInt(3);
            String computerMove = options[computerIndex];
            
            System.out.print("Round " + i + " - Enter your move (Rock, Paper, Scissors): ");
            String playerMove = scanner.nextLine();
            
            String result = playRound(playerMove, computerMove);
            System.out.println("Round " + i + " - Player: " + playerMove + ", Computer: " + computerMove);
            System.out.println("Result: " + result);
            
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }
        
        double winPercentage = (double) wins / n * 100;
        System.out.println("\nFinal Summary (after " + n + " rounds)");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + String.format("%.1f", winPercentage) + "%");
        
        scanner.close();
    }
}
