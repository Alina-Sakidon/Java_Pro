package HW3;

public class Cat extends Animal{

    public Cat(String animalName) {
        super(animalName);
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
