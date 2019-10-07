package section_07.polymorphism;

class Car {

    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        wheels = 4;
        engine = true;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine()";
    }

    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate()";
    }

    public String brake() {
        return getClass().getSimpleName() + " -> brake()";
    }

}

class Mitsubishi extends Car {

    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

//    @Override
//    public String startEngine() {
//        return getClass().getSimpleName() + " -> startEngine()";
//    }
//
//    @Override
//    public String accelerate() {
//        return getClass().getSimpleName() + " -> accelerate()";
//    }
//
//    @Override
//    public String brake() {
//        return getClass().getSimpleName() + " -> brake()";
//    }

}

class Holden extends Car {

    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }

//    @Override
//    public String startEngine() {
//        return getClass().getSimpleName() + " -> startEngine()";
//    }
//
//    @Override
//    public String accelerate() {
//        return getClass().getSimpleName() + " -> accelerate()";
//    }
//
//    @Override
//    public String brake() {
//        return getClass().getSimpleName() + " -> brake()";
//    }

}

class Ford extends Car {

    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

//    @Override
//    public String startEngine() {
//        return getClass().getSimpleName() + " -> startEngine()";
//    }
//
//    @Override
//    public String accelerate() {
//        return getClass().getSimpleName() + " -> accelerate()";
//    }
//
//    @Override
//    public String brake() {
//        return getClass().getSimpleName() + " -> brake()";
//    }

}

public class Challenge {

    // We are going to go back to the car analogy.
    // Create a base class called Car
    // It should have a few fields that would be appropriate for a generic car class.
    // engine, cylinders, wheels, etc.
    // Constructor should initialize cylinders (number of) and name, and set wheels to 4
    // and engine to true. Cylinders and names would be passed parameters.
    //
    // Create appropriate getters
    //
    // Create some methods like startEngine, accelerate, and brake
    //
    // show a message for each in the base class
    // Now create 3 sub classes for your favorite vehicles.
    // Override the appropriate methods to demonstrate polymorphism in use.
    // put all classes in the one java file (this one).

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Car car = randomCar();
            System.out.println("Car #" + i + ":\n" +
                    car.startEngine() + "\n" +
                    car.accelerate() + "\n" +
                    car.brake() + "\n");
        }

//        Car car = new Car(8, "Base car");
//        System.out.println(car.startEngine());
//        System.out.println(car.accelerate());
//        System.out.println(car.brake());
//        System.out.println();
//
//        Mitsubishi mitsubishi = new Mitsubishi(8, "Outlander VRX 4WD");
//        System.out.println(mitsubishi.startEngine());
//        System.out.println(mitsubishi.accelerate());
//        System.out.println(mitsubishi.brake());
//        System.out.println();
//
//        Ford ford = new Ford(6, "Ford Falcon");
//        System.out.println(ford.startEngine());
//        System.out.println(ford.accelerate());
//        System.out.println(ford.brake());
//        System.out.println();
//
//        Holden holden = new Holden(6, "Holden Commodore");
//        System.out.println(holden.startEngine());
//        System.out.println(holden.accelerate());
//        System.out.println(holden.brake());
//        System.out.println();

    }

    public static Car randomCar() {
        int randomNumber = (int) (Math.random() * 4) + 1;
        System.out.println("Random number generated was: " + randomNumber);

        switch(randomNumber) {
            case 1:
                return new Car(8, "Base car");
            case 2:
                return new Mitsubishi(8, "Outlander VRX 4WD");
            case 3:
                return new Ford(6, "Ford Falcon");
            case 4:
                return new Holden(6, "Holden Commodore");
            default:
                return null;
        }
    }

}
