package HW3;

public class Cat extends Animal{

    private static int count;

    public Cat(String animalName) {
        super(animalName);
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int meters) {
        if (meters > 200) {
            System.out.println(getAnimalName() + " can run not greater than 200 meters");
            return;
        }
        System.out.println(getAnimalName() + " run " + meters + " meters");
    }

    public void swim(int meters){
        System.out.println("Cats can't swim");
    }
}
