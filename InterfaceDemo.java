// Define an interface
interface Vehicle {
    void start(); // Method without implementation
}

// Implementing the interface in the Car class
class Car implements Vehicle {
    public void start() {
        System.out.println("Car is starting with a key...");
    }
}

// Implementing the interface in the Bike class
class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike is starting with a self-start button...");
    }
}

// Main class
public class InterfaceDemo {
    public static void main(String[] args) {
        // Creating objects of Car and Bike using the interface reference
        Vehicle myCar = new Car();
        Vehicle myBike = new Bike();

        // Calling the start() method on both objects
        myCar.start();  // Output: Car is starting with a key...
        myBike.start(); // Output: Bike is starting with a self-start button...
        // Note: The actual implementation of the start() method is in the Car and Bike classes
    }
}
