package HW3;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Animal");
        Animal dogPatron = new Dog("Patron");
        Animal catPity = new Cat("Pity");
        dogPatron.run(1000);
        catPity.swim(10);

        Dog dogBob = new Dog("Bobik");
        dogBob.swim(12);
        dogBob.run(600);

        Cat cat = new Cat("Kot");
        cat.swim(200);
        cat.run(400);

        System.out.println(Cat.getCount() + " cats were created");
        System.out.println(Dog.getCount() + " dogs were created");
        System.out.println(Animal.getCount() + " animals were created");
    }
}
