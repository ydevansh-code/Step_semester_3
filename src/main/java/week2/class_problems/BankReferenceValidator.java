package week2.class_problems;

public class BankReferenceValidator {
    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        raw = raw.trim();
        if (raw.length() < 3) return raw;
        return raw.substring(0, 3).toUpperCase() + raw.substring(3);
    }
    
    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: length must be exactly 14 characters";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: sequence must be 11 digits";
            }
        }
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(reference.substring(0, 3)).append("] ");
        formatted.append("DATE: ").append(reference.substring(3, 5)).append("/")
                 .append(reference.substring(5, 7)).append("/")
                 .append(reference.substring(7, 9)).append(" | ");
        formatted.append("SEQ: ").append(reference.substring(9));
        return formatted.toString();
    }
    public static void main(String[] args) {
        String raw1 = " hdf03022600042 ";
        String norm1 = normalizeReference(raw1);
        System.out.println(validateAndFormat(norm1));
        
        String raw2 = "12F03022600042";
        String norm2 = normalizeReference(raw2);
        System.out.println(validateAndFormat(norm2));
    }
}
