public class Demo2 {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal d = new Dog();

        System.out.println(a.getClass().getName());
        System.out.println(d.getClass().getName());

        System.out.println(a instanceof Animal);
        System.out.println(d instanceof Animal);
        System.out.println(a instanceof Dog);
    }
    
}


/**
 * Animal
 */
class Animal {

    
}

/**
 * Dog extends Animal
 */
class Dog extends Animal {

    
}