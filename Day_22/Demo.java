import java.util.Objects;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Hello, World!");
        Object obj = new Object();
        Student student = new Student("Alice", 20);
        Student student2 = new Student("rpk", 21);
        Student student3 = new Student("Alice", 20);

        // System.out.println(student);
        // System.out.println(student.equals(student2));

        // Student student3 = null;
        // System.out.println(student.equals(student3));

        // Integer i = 28;
        // System.out.println(student.equals(i));
        // System.out.println(student.hashCode());
        // System.out.println(student2.hashCode());
        // System.out.println(student3.hashCode());
        // System.out.println(student.hashCode() == student3.hashCode());
        
        // System.out.println(student.getClass().getName());
        
        // System.out.println(student instanceof Student);
        
        // Student student4 = (Student)student.clone();
        // System.out.println(student4.getName());
        // System.out.println(student.getName());
        // System.out.println(student.hashCode() == student4.hashCode());
        // System.out.println(student.equals(student4));
        

    }
    
}

// instenceOf operator -> check if an object is instance of a class or any of its


// extends Object optional
class Student extends Object implements Cloneable{
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

    @Override
    public int hashCode(){
        // int result =17;
        // result = result*31 +age;
        // result = result*31 + (name == null ? 0 : name.hashCode());
        // return result;

        return Objects.hash(name, age);

    }

    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
}