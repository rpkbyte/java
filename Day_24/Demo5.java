public class Demo5 {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.drive();

        // Vehicle.brake();
    }
}


//After Java 8  -->Default Methods , Static methods
// From Java 9 -->Private methods 

// List interface --> methods

// interface List{
//     void pushBack();
// }

interface Vehicle{
    default void drive(){
        System.out.println("Vehicle is driving");
        accelerate();
    }

    static void brake(){
        System.out.println( "Vehicle is applying brake");
    }

    private void accelerate(){
        System.out.println("Vehicle is accelerating ");
    }

}


class Car implements Vehicle{
    // @Override
    // public void drive(){
    //     System.out.println("car is driving");
    // }
}