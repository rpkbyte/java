public class Demo2 {
    public static void main(String[] args) {
        
        String s1 = new String("rampravesh kumar"); 
        String s2 = new String("rampravesh kumar");

        // Length / Emptiness
        // System.out.println(s1.length()); // length of string
        // System.out.println(s1.isEmpty()); 
        // System.out.println(s1.isBlank());


        //Character access
        // System.out.println(s1.charAt(5));
        char[] arr = s1.toCharArray();

        // Comarison
        // System.out.println(s1.equals(s2));
        // System.out.println(s1 == s2); // it's false because new keyword
        // System.out.println(s1.equalsIgnoreCase(s2));

        // lexicographical comparison --> Dictionary
        // System.out.println(s1.compareTo(s2));

        //seraching
        // System.out.println(s1.contains("am"));
        // System.out.println(s1.indexOf("a"));
        // System.out.println(s1.indexOf("pr"));
        // System.out.println(s1.lastIndexOf("umar"));
        // System.out.println(s1.startsWith("r"));
        // System.out.println(s1.endsWith("k"));

        //Extraction/ transformation
        // System.out.println(s1.substring(1,5));
        // System.out.println(s1.toUpperCase());
        // System.out.println(s1.trim());
        // System.out.println(s1.strip()); //unicode friendly

        // System.out.println(s1.repeat(3));

        // // System.out.println(s1.replace('a', 'p'));
        // System.out.println(s1.replaceAll("a","b"));

        // String s3 = "Rpk-Rohit-Rohan";
        // String[] arr2 = s3.split("-");

        // for (int i = 0; i < arr2.length; i++) {
        //     System.out.println(arr2[i]);
        // }

        // System.out.println(String.join("-","a","b","c"));

        //Conversion
        // String s4 = new String(String.valueOf(10));
        // System.out.println(s4);

        // byte[] arr3 =s1.getBytes();

        // for (int i = 0; i < arr3.length; i++) {
        //     System.out.println(arr3[i]);
        // }


        //Advance -->intern() ,format()

        // String s5 = new String("hello");
        // String s6 =s5;
        // System.out.println(s5==s6);

        // String s7 = s5.intern();

        // System.out.println(s5==s7);

        //format 

        String name = "rpk";
        int age =21;

        //Hello rpk , your age is 21;

        System.out.println("Hello" + " " + name +" , your age is " + age);

        System.out.println(String.format("Hello %s, your age is %s", name, age));


    }
}
