package week1.class_problems;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return checkRecursive(text, 0, text.length() - 1);
    }
    
    private static boolean checkRecursive(String text, int left, int right) {
        if (left >= right) return true;
        if (text.charAt(left) != text.charAt(right)) return false;
        return checkRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] arr = text.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        String reversed = new String(arr);
        return text.equals(reversed);
    }

    public static void main(String[] args) {
        String[] testCases = {"madam", "hello"};
        
        for (String test : testCases) {
            System.out.println("Input: \"" + test + "\"");
            String iter = isPalindromeIterative(test) ? "Palindrome" : "Not Palindrome";
            String rec = isPalindromeRecursive(test) ? "Palindrome" : "Not Palindrome";
            String arr = isPalindromeArrayReversal(test) ? "Palindrome" : "Not Palindrome";
            
            System.out.println("Iterative: " + iter + " | Recursive: " + rec + " | Array Reversal: " + arr);
            System.out.println();
        }
    }
}
