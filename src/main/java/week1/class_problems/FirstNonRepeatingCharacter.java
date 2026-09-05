package week1.class_problems;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : text.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        for (char c : text.toCharArray()) {
            if (counts.get(c) == 1) {
                return c;
            }
        }
        
        return '\0';
    }

    public static void main(String[] args) {
        String[] testCases = {"swiss", "aabbcc"};
        
        for (String test : testCases) {
            System.out.println("Input: \"" + test + "\"");
            char result = findFirstNonRepeatingChar(test);
            if (result != '\0') {
                System.out.println("First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("No Non-Repeating Character Found");
            }
            System.out.println();
        }
    }
}
