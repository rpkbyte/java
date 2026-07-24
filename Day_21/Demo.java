public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        College college = new College("rlsy","patna" );

        Student s1 = new Student(21,"rpk" , college);

        System.out.println(s1.getAge());
        System.out.println(s1.getName());
        System.out.println(s1.getCollege().name);

        s1.getCollege().name = "IIT";

        System.out.println(s1.getCollege().name);


    }    
}


/**
 * Student
 */

// Immutable class
class Student {
    private final int age ;
    private final String name ;
    private final College college;

    Student(int age , String name , College college){
        this.age = age;
        this.name= name;
        this.college = new College(college.name, college.address);
    }

    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }
    public College getCollege(){
        return new College(college.name, college.address);
    }


    
}

/**
 * College
 */
class College {
    String name;
    String address;


    College(String name, String address){
        this.name = name;
        this.address = address;
    }

    
}