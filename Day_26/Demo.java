public class Demo {
    public static void main(String[] args) {

        // empty string constructor
        String s1 = new String();
        String s2 = new String(""); // s1 and s2 both are same renturn noting

        // System.out.println(s1);
        // System.out.println(s2);
        
        // string litrel
        String s3 = "Rpk";
        String s4 = new String(s3);
        
        //char array
        char [] arr = {'r','a','m','p','r','a','v','e','s','h',' ','k','u','m','a','r'};
        String s5 = new String(arr);

        // System.out.println(s5);

        // arr[0] = 's';

        // System.out.println(s5);

        //char array subset
        String s6 = new String(arr,0,10);
        // System.out.println(s6);

        byte[] arr2 = {97,98,99};
        String s7 = new String(arr2 , 0 ,3);

        // System.out.println(s7);

        //String Builder / StringBuffer 

        StringBuilder sb = new StringBuilder("Hello");
        String s8 = new String(sb);

        // System.out.println(s8);

        StringBuffer sf = new StringBuffer("Hello");
        String s9 = new String(sf);

        System.out.println(sf);
        System.out.println(s9);




    }
}

// all String constructor

// 1. new String()
// 2. new String("")
// 3. new String("string")
// 4. new String(char[])
// 5. new String(byte[])
// 6. new String(StringBuffer)
// 7. new String(StringBuilder)