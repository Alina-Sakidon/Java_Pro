package HW4;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SomeStringMethods someStringMethods = new SomeStringMethods();

        System.out.println(someStringMethods .findSymbolOccurance("Test was created without errors", 'w'));
        System.out.println(someStringMethods.findWordPosition("My little fried seats on little bag", "little"));
        System.out.println(someStringMethods.stringReverse("ANI LORAK"));
        System.out.println(someStringMethods.isPalindrome("ONO"));

        // GAME

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        Scanner myScanner = new Scanner(System.in);
        Random random = new Random();
        String gameWord = words[random.nextInt(words.length)];
        System.out.println("Guess a word! Some of following: " + Arrays.toString(words));
        System.out.println("I'll show you the game word but it's a secret: " + gameWord);
        String myWord;
        StringBuilder stringBuilder = new StringBuilder("###############");
        do {
            System.out.println("You can try to guess the word: ");
            myWord = myScanner.nextLine();
            if (Objects.equals(myWord, gameWord)) {
                System.out.println("Super! It's the correct word");
            } else {
                int shortWord;
                if (gameWord.length() < myWord.length()) {
                    shortWord = gameWord.length();
                } else {
                    shortWord = myWord.length();
                }
                for (int i = 0; i < shortWord; i++) {
                    if (myWord.charAt(i) == gameWord.charAt(i)) {
                        stringBuilder.setCharAt(i, myWord.charAt(i));
                    }
                }
                System.out.println("Not correct,I'll show you guessed letters in the game word on right places: ");
                System.out.println(stringBuilder);
                System.out.println("Lets try another one!");
            }
        } while (!gameWord.equals(myWord));
    }
}
