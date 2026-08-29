package string.assigment_problems;

public class CountVowelsConsonants {
    public static int[] count(String str) {
        int vowels = 0;
        int consonants = 0;
        if (str == null) {
            return new int[]{0, 0};
        }
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return new int[]{vowels, consonants};
    }
}
