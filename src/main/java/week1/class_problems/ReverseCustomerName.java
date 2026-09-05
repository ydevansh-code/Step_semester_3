package week1.class_problems;

public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - 1 - i];
            chars[n - 1 - i] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String input = "Sunil";
        System.out.println("Original Name: " + input);
        System.out.println("Reversed Name: " + reverseCustomerName(input));
    }
}
