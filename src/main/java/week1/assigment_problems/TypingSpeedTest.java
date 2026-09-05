package week1.assigment_problems;

public class TypingSpeedTest {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Lengths do not match.");
            return;
        }
        
        int matched = 0;
        int total = original.length();
        int firstMismatchPos = -1;
        char originalChar = '\0';
        char typedChar = '\0';
        
        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1; // 1-indexed position
                    originalChar = original.charAt(i);
                    typedChar = typed.charAt(i);
                }
            }
        }
        
        double accuracy = ((double) matched / total) * 100;
        
        if (firstMismatchPos == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n", matched, total, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n", 
                              matched, total, accuracy, firstMismatchPos, originalChar, typedChar);
        }
    }

    public static void main(String[] args) {
        String orig1 = "hello world";
        String type1 = "hello worlt";
        checkTypingAccuracy(orig1, type1);
        
        String orig2 = "coding";
        String type2 = "coding";
        checkTypingAccuracy(orig2, type2);
    }
}
