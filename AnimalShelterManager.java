import java.util.LinkedList;
import java.util.Queue;

class Animal {
    private String name;
    private int order;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

public class AnimalShelterManager {
    private Queue<Dog> dogs;
    private Queue<Cat> cats;
    private int order;

    public AnimalShelterManager() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        order = 0;
    }

    // Enqueue an animal to the shelter
    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;

        if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.add((Cat) animal);
        }
    }

    // Dequeue the oldest animal (either dog or cat)
    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.getOrder() < cat.getOrder()) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    // Dequeue the oldest dog
    public Dog dequeueDog() {
        return dogs.poll();
    }

    // Dequeue the oldest cat
    public Cat dequeueCat() {
        return cats.poll();
    }

           public static void main(String[] args) {
        AnimalShelterManager shelter = new AnimalShelterManager();
        shelter.enqueue(new Dog("Dog1"));
        shelter.enqueue(new Cat("Cat1"));
        shelter.enqueue(new Dog("Dog2"));
        shelter.enqueue(new Cat("Cat2"));
    
        Animal animal = shelter.dequeueAny();
        System.out.println("Dequeue Any: " + (animal != null ? animal.getName() : "No animals"));
    
        Dog dog = shelter.dequeueDog();
        System.out.println("Dequeue Dog: " + (dog != null ? dog.getName() : "No dogs"));
    
        Cat cat = shelter.dequeueCat();
        System.out.println("Dequeue Cat: " + (cat != null ? cat.getName() : "No cats"));
    
        animal = shelter.dequeueAny();
        System.out.println("Dequeue Any: " + (animal != null ? animal.getName() : "No animals"));
    }
}