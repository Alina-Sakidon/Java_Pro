package HW4;

public class Main {

    public static void main(String[] args) {
        SomeStringMethods someStringMethods = new SomeStringMethods();

        System.out.println(someStringMethods .findSymbolOccurance("Test was created without errors", 'w'));
        System.out.println(someStringMethods.findWordPosition("My little fried seats on little bag", "little"));
        System.out.println(someStringMethods.stringReverse("ANI LORAK"));
        System.out.println(someStringMethods.isPalindrome("ONO"));
    }
}
