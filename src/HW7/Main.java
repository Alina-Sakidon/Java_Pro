package HW7;

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
}
