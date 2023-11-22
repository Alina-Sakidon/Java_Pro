package HW3;

public  class Animal {

    private String animalName;
    private static int count;

    public Animal(String animalName) {
        this.animalName = animalName;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void swim(int meters){
        System.out.println("Animal swim " + meters + " meters");
    }

    public void run(int meters){
        System.out.println("Animal run " + meters + " meters");
    }

    public String getAnimalName() {
        return animalName;
    }
}
