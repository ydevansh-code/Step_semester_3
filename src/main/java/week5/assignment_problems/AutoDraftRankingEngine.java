package week5.assignment_problems;

import java.util.Arrays;

public class AutoDraftRankingEngine {
    public static String draftAndRank(Player[] players) {
        int count = 0;
        for (Player p : players) {
            if (p.isDraftable()) {
                count++;
            }
        }

        Player[] draftableArray = new Player[count];
        int index = 0;
        for (Player p : players) {
            if (p.isDraftable()) {
                draftableArray[index++] = p;
            }
        }

        Arrays.sort(draftableArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            sb.append(i + 1).append(". ").append(draftableArray[i].getName());
            if (i < draftableArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}
