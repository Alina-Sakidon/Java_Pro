package phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PhoneBook {

    private List<Note> phoneNotes;

    public PhoneBook() {
        this.phoneNotes = new ArrayList<>();
    }

    public void add(Note note) {
        this.phoneNotes.add(note);
    }

    public void addNotes(List<Note> notes) {
        this.phoneNotes.addAll(notes);
    }

    public Note find(String name) {
        Optional<Note> result = this.phoneNotes.stream().filter(n -> n.getName().equals(name)).findFirst();
        return result.orElse(null);
    }

    public List<Note> findAll(String name) {
        List<Note> result = this.phoneNotes.stream().filter(n -> n.getName().equals(name)).collect(Collectors.toList());
        return result.isEmpty() ? null : result;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.phoneNotes.forEach(i -> stringBuilder.append(i.toString() + System.getProperty("line.separator")));
        return stringBuilder.toString();
    }
}
