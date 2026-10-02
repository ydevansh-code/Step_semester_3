package week6.practice_problems;

public class NameTag {
    private final String firstName;
    private final char lastNameInitial;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastNameInitial = parts[1].charAt(0);
    }

    public String getNickname() {
        return firstName + " " + lastNameInitial + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}
