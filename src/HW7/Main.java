package HW7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Task1
        List<String> rows = new ArrayList<>(Arrays.asList("item1", "item2", "item3", "item4", "item5", "item6", "item7",
                "item9", "item9", "item10", "item10", "item10", "item10"));

        System.out.println(countOccurrence(rows, "item10"));
    }

    static int countOccurrence(List<String> rows, String value) {
        return Collections.frequency(rows, value);
    }
}
