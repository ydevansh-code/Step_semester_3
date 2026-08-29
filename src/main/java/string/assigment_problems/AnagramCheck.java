package string.assigment_problems;

import java.util.Arrays;

public class AnagramCheck {
    public static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        char[] array1 = str1.replaceAll("\\s+", "").toLowerCase().toCharArray();
        char[] array2 = str2.replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }
}
