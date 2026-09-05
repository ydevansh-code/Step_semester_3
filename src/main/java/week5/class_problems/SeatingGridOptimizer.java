package week5.class_problems;

public class SeatingGridOptimizer {
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0.0;
        double sum = 0;
        for (int val : row) {
            sum += val;
        }
        return sum / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String status = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";
            sb.append("Row ").append(i).append(": ").append(status);
            if (i < seatingScores.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;
        System.out.println(classifyRows(seatingScores, threshold));
    }
}
