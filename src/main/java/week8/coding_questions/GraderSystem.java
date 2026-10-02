package week8.coding_questions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String text, String correctAnswer, String studentAnswer, double points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double grade();
}

class MCQ extends Question {
    public MCQ(String text, String correctAnswer, String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }
    @Override
    public double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TF extends Question {
    public TF(String text, String correctAnswer, String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }
    @Override
    public double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class Essay extends Question {
    public Essay(String text, String correctAnswer, String studentAnswer, double points) {
        super(text, correctAnswer, studentAnswer, points);
    }
    @Override
    public double grade() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String lowerStudentAnswer = studentAnswer.toLowerCase();
        for (String keyword : keywords) {
            if (lowerStudentAnswer.contains(keyword.trim().toLowerCase())) {
                matchCount++;
            }
        }
        if (matchCount >= 2) return points * 0.75;
        if (matchCount == 1) return points * 0.50;
        return 0;
    }
}

public class GraderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());
        double total = 0;
        
        Pattern pattern = Pattern.compile("^(\\w+)\\s+\"([^\"]+)\"\\s+\"([^\"]+)\"\\s+\"([^\"]+)\"\\s+(\\d+(?:\\.\\d+)?)$");
        
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String type = matcher.group(1);
                String text = matcher.group(2);
                String correct = matcher.group(3);
                String student = matcher.group(4);
                double points = Double.parseDouble(matcher.group(5));
                
                Question q = null;
                switch (type) {
                    case "MCQ": q = new MCQ(text, correct, student, points); break;
                    case "TF": q = new TF(text, correct, student, points); break;
                    case "ESSAY": q = new Essay(text, correct, student, points); break;
                }
                
                if (q != null) {
                    double score = q.grade();
                    total += score;
                    System.out.printf("%s: %.2f\n", type, score);
                }
            }
        }
        System.out.printf("Total Score: %.2f\n", total);
        scanner.close();
    }
}
