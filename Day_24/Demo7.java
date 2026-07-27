public class Demo7 {
    public static void main(String[] args) {
        C c = new C();
        c.fun();
    }
}

interface A {
    default void fun(){
        System.out.println("Interface A");
    }
}

class B {
    public void fun (){
        System.out.println("Class B");
    }
}

class C extends B implements A{

}