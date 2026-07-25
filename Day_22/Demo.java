public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // Object obj = new Object();
        Student student = new Student("Alice", 20);
        Student student2 = new Student("rpk", 21);

        // System.out.println(student);
        // System.out.println(student.equals(student2));

        // Student student3 = null;
        // System.out.println(student.equals(student3));

        // Integer i = 28;
        // System.out.println(student.equals(i));
        
    }
    
}

// extends Object optional
class Student extends Object {
    private String name;
    private int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString(){
        return(name + ","+age);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)return true;

        if(obj == null){
            return false;
        }

        // Check if both classes are of type Student
        // if not checked  -- ClassCastExceptions
        if(obj.getClass() != this.getClass()){
            return false;
        }
        Student s = (Student)obj;
        return (this.name == s.name && this.age ==s.age );
    }

    // @Override
    // public 
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
}