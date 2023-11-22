package HW3;

public class Main {

    public static void main(String[] args) {
        Animal dogPatron = new Dog("Patron");
        Animal catPity = new Cat("Pity");
        dogPatron.run(1000);
        catPity.run(10);

        Dog dogBob = new Dog("Bobik");
        dogBob.swim(12);
        dogBob.run(600);

        Cat cat = new Cat("Kot");
        cat.swim(200);
        cat.run(400);
    }
}
