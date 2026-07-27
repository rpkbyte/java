public class Demo2 {
    public static void main(String[] args) {
        MathConstant r1 = new Random();
        // r1.fun();
        System.out.println(MathConstant.PI_VALUE);
    }
}

// Variables inside interfaces

/**
 * MathConstant
 */
interface MathConstant {
    double PI_VALUE =3.14;
    int VALUE =10;

    // void fun();
    
}

class Random implements MathConstant{

    // @Override
    // public void fun(){
    //     System.out.println(PI_VALUE);
    // }
}