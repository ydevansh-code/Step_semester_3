package week1.assigment_problems;

public class TrafficSignalStreak {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            return;
        }

        int maxLength = 0;
        char maxChar = '\0';
        
        int currentLength = 1;
        char currentChar = signalLog.charAt(0);
        
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxChar = currentChar;
                }
                currentChar = signalLog.charAt(i);
                currentLength = 1;
            }
        }
        
        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxChar = currentChar;
        }
        
        System.out.println("Longest Streak: '" + maxChar + "' repeated " + maxLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}
