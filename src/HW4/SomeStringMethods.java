package HW4;

public class SomeStringMethods {

    public int findSymbolOccurance(String someString, char symbol) {
        int count = 0;
        for (int i = 0; i < someString.length(); i++) {
            if (someString.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }

    public int findWordPosition(String source, String target) {
        String[] listWord = source.split(" ");
        for (int i = 0; i < listWord.length; i++) {
            if (listWord[i].equals(target)) {
              return   i + 1;
            }
        }
        return -1;
    }

    public String stringReverse(String stringToReverse){
        return new StringBuilder(stringToReverse).reverse().toString();
    }
}
