public class Demo3 {

    public static void main(String[] args) {
        String s="";
        for( int i=0; i<5; i++){
            s+=i;
            String a =" ";
            System.out.print(a.repeat(5-i));
            System.out.println(s);
        }
    }
}

// Problem of Immutability 