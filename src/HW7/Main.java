package HW7;

import phonebook.Note;
import phonebook.PhoneBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Task1
        List<String> rows = new ArrayList<>(Arrays.asList("item1", "item2", "item3", "item4", "item5", "item6", "item7",
                "item9", "item9", "item10", "item10", "item10", "item10"));

        System.out.println(countOccurrence(rows, "item10"));

        //Task2
        String[] lines = {"test1 string line", "test2", "test3", "test4", "test4"};

        System.out.println(toList(lines));

        //Task3
        List<Integer> listAll = Arrays.asList(1, 2, 3, 3, 4, 5, 4, 6, 6);
        System.out.println(findUnique(listAll));

        //Task4
        calcOccurrence(rows);

        //Task4***
        findOccurrence(rows);

        //Task PhoneBook
        Note note1 = new Note("Alina", "+380994184102");
        Note note2 = new Note("Alina", "+7896541233");
        Note note3 = new Note("Slava", "+132565444");
        Note note4 = new Note("Irina", "+713698888888");
        Note note5 = new Note("Alina", "+45654654654");

        List<Note> notes = new ArrayList<>(Arrays.asList(note1, note2, note3, note4, note5));
        notes.forEach(i -> System.out.println(i));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(note1);
        phoneBook.addNotes(notes);
        System.out.println("Phone Book " + phoneBook);
        System.out.println("Return note from phone book by name " + phoneBook.find("Alina"));
        System.out.println("Return note from phone book by name if not exist " + phoneBook.find("Oleg"));
        System.out.println("Return all notes from phone book by name " + phoneBook.findAll("Alina"));
        System.out.println("Return all notes from phone book by name if not exist " + phoneBook.findAll("Oleg"));
    }

    static int countOccurrence(List<String> rows, String value) {
        return Collections.frequency(rows, value);
    }

    static ArrayList<String> toList(String... lines) {
        return new ArrayList<>(Arrays.asList(lines));
    }

    static List<Integer> findUnique(List<Integer> listAll) {
        return listAll.stream().distinct().collect(Collectors.toList());
    }

    static void calcOccurrence(List<String> rows) {
        rows.stream().distinct().forEach(i -> System.out.println(i + ": " + Collections.frequency(rows, i)));
    }

    static void findOccurrence(List<String> rows) {
        List<ResearchResult> occurence = new ArrayList<>();
        rows.stream().distinct().collect(Collectors.toList()).forEach(i -> occurence.add(new ResearchResult(i, Collections.frequency(rows, i))));
        occurence.stream().forEach(l -> System.out.println(l));
    }
}
