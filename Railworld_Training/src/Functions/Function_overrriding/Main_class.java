package Functions.Function_overrriding;

public class Main_class {

        public static void main(String[] args) {
            Animal myAnimal = new Animal(); // Create an Animal object
            Animal myDog = new Dog();       // Create a Dog object (upcasted to Animal)

            myAnimal.sound(); // Calls the sound() method in Animal class
            myDog.sound();    // Calls the sound() method in Dog class (overridden method)
        }
}
