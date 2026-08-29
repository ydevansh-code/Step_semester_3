package string.class_problems;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String clean = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(clean).reverse().toString();
        return clean.equals(reversed);
    }
}
