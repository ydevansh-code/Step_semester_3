package week2.assigment_problems;

public class LibraryIsbnValidator {
    public static String normalizeCode(String raw) {
        if (raw == null) return "";
        raw = raw.trim();
        if (raw.length() < 3) return raw;
        return raw.substring(0, 3).toUpperCase() + raw.substring(3);
    }
    
    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(code.substring(0, 3)).append("] ");
        formatted.append("YEAR: ").append(code.substring(3, 7)).append(" | ");
        formatted.append("CATALOG: ").append(code.substring(7));
        return formatted.toString();
    }
    public static void main(String[] args) {
        String raw1 = " pen2026004251 ";
        String norm1 = normalizeCode(raw1);
        System.out.println(validateAndFormat(norm1));
        
        String raw2 = "12N2026004251";
        String norm2 = normalizeCode(raw2);
        System.out.println(validateAndFormat(norm2));
    }
}
