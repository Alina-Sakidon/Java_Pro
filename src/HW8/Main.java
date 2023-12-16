package HW8;


public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();
        FileData fileData = new FileData("src/HW1/work1.txt", "work1.txt", (byte) 10);
        FileData fileData2 = new FileData("src/HW2/work2.java", "work2.java", (byte) 13);
        FileData fileData3 = new FileData("src/HW3/work3.txt", "work3.txt", (byte) 11);
        FileData fileData4 = new FileData("src/HW7/work7.java", "work7.java", (byte) 9);
        FileData fileData5 = new FileData("src/HW5/work5.txt", "work5.txt", (byte) 7);
        FileData fileData6 = new FileData("src/HW5/work5.txt", "work6.txt", (byte) 7);

        fileNavigator.add("src/HW1/work1.txt", fileData);
        fileNavigator.add("src/HW2/work2.java", fileData2);
        fileNavigator.add("src/HW3/work3.txt", fileData3);
        fileNavigator.add("src/HW7/work7.java", fileData4);
        fileNavigator.add("src/HW5/work5.txt", fileData5);

        System.out.println(fileNavigator);

        //method find
        System.out.println("Find element by path: " + fileData3.getPath() + fileNavigator.find(fileData3.getPath()));
        System.out.println("Find illegal path: " + fileNavigator.find("src/HW4"));

        //filter Size
        System.out.println("Filter by size: " + fileNavigator.filterBySize((byte) 11));

        //remove
        fileNavigator.remove(fileData3.getPath());

        //sort
        System.out.println("Sorted values: " + fileNavigator.sortBySize());

        //add illegal path
        fileNavigator.add("src/HW5/workFailed.txt", fileData6);
    }
}
