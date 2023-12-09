package phonebook;

public class Note {

    private String name;
    private String phoneNumber;

    public Note(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "{name: \"" + this.name + "\", phone Number: " + this.phoneNumber + "}";
    }
}
