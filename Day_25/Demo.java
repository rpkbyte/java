public class Demo{
    public static void main(){
        // String name = "rpk";
        // name.concat("it's me");
        // System.out.println(name);

        String s1 = "Hello";  //Literal
        String s2 = "Hello";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s3 = new String("rpk");  //new keyword
        String s4 = new String("rpk");

        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
        
    }
}

// golden rule:
//-->only compile time constants go to string pool automaticlly.
//-->runtime created string go to heap.