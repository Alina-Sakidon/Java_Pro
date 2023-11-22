package HW3;

public class Dog extends Animal {

    private static int count;

    public Dog(String animalName) {
        super(animalName);
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void swim(int meters) {
        if (meters > 10) {
            System.out.println(getAnimalName() + " can swim not greater than 10 meters");
            return;
        }
        System.out.println(getAnimalName() + " swim " + meters + " meters");
    }

    public void run(int meters) {
        if (meters > 500) {
            System.out.println(getAnimalName() + " can run not greater than 500 meters");
            return;
        }
        System.out.println(getAnimalName() + " run " + meters + " meters");
    }
}
