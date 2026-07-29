public class Demo2 {
    public static void main(String[] args) {
        String s1 = "ja" + "va";  //java
        String s2 = "java";

        System.out.println(s1 == s2);  //true

        String s3 = "helllo";
        String s4 = s3 + "world";
        String s5 = "hello world";

        System.out.println(s4 == s5 ); // false 

        String s6 = "Hello";
        String s7 = s6;
        System.out.println(s6 == s7); //true


        String s8 = "Hello";
        s8 = "World";
        System.out.println(s8); // World

        String s9 = new String("Hello");
        String s10 = "Hello";

        System.out.println(s9 == s10); //false



    }
}


// String pool --> hello , world , hello world

// Heap --> hello world