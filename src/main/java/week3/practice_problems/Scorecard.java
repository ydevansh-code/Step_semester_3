package week3.practice_problems;

public class Scorecard {
    private boolean[] results;
    private int currentIndex;
    private final int totalQuestions;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.currentIndex = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (currentIndex < totalQuestions) {
            results[currentIndex] = isCorrect;
            currentIndex++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < currentIndex; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println(sc.getScore());
    }
}
