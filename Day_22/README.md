# Java Object Class - Complete Guide

## Overview

The `Object` class is the **root class of all classes in Java**. Every class in Java implicitly extends `Object` (either directly or indirectly). It provides fundamental methods that all objects inherit.

---

## Important Methods of Object Class

### 1. **toString()**

#### Purpose
Returns a string representation of the object.

#### Default Behavior
```java
// Default implementation returns: className@hexHashCode
// Example: Student@1f32e0a4
```

#### Why Override
- To provide a meaningful, human-readable representation of your object
- Essential for debugging and logging

#### How to Override
```java
@Override
public String toString(){
    return (name + "," + age);
}
```

#### Example Usage
```java
Student student = new Student("Alice", 20);
System.out.println(student);  // Output: Alice,20
```

---

### 2. **equals(Object obj)**

#### Purpose
Compares two objects for equality.

#### Default Behavior
- Compares object references (like `==`)
- Returns `true` only if both objects refer to the same memory location

#### Why Override
- To compare objects based on their content/state, not just reference
- Essential for collections like ArrayList, HashMap, HashSet

#### How to Override
```java
@Override
public boolean equals(Object obj){
    // Step 1: Compare reference
    if(this == obj) return true;
    
    // Step 2: Check for null
    if(obj == null) return false;
    
    // Step 3: Check class type (avoid ClassCastException)
    if(obj.getClass() != this.getClass()) return false;
    
    // Step 4: Compare fields
    Student s = (Student)obj;
    return (this.name.equals(s.name) && this.age == s.age);
}
```

#### Key Points
- Always check `this == obj` first (optimization)
- Always check for `null`
- Always verify class types before casting
- Use `.equals()` for String comparison (not `==`)

#### Example Usage
```java
Student student1 = new Student("Alice", 20);
Student student2 = new Student("Alice", 20);
Student student3 = new Student("Bob", 21);

System.out.println(student1.equals(student2));  // true (same content)
System.out.println(student1.equals(student3));  // false (different content)
```

---

### 3. **hashCode()**

#### Purpose
Returns a hash code value for the object.

#### Default Behavior
- Returns a value based on the object's memory address
- Different for different objects

#### Why Override
- **Must be overridden along with `equals()`**
- Essential for hash-based collections (HashMap, HashSet, Hashtable)
- Maintains the contract: if `a.equals(b)`, then `a.hashCode() == b.hashCode()`

#### How to Override (Method 1: Manual)
```java
@Override
public int hashCode(){
    int result = 17;  // Prime number
    result = result * 31 + age;  // Prime multiplier
    result = result * 31 + (name == null ? 0 : name.hashCode());
    return result;
}
```

#### How to Override (Method 2: Using Objects.hash)
```java
@Override
public int hashCode(){
    return Objects.hash(name, age);
}
```

#### Key Points
- Use prime numbers (17, 31) for calculation
- Combine multiple fields
- Must be consistent: same object always returns same hashCode
- If `equals()` compares certain fields, `hashCode()` must also use them

#### Example Usage
```java
Student student1 = new Student("Alice", 20);
Student student2 = new Student("Alice", 20);

System.out.println(student1.hashCode() == student2.hashCode());  // true
System.out.println(student1.equals(student2));  // true
```

---

### 4. **clone()**

#### Purpose
Creates a shallow copy of the object.

#### Default Behavior
- Throws `CloneNotSupportedException` by default
- Returns an Object reference

#### Why Override
- To allow creation of object copies
- To provide controlled cloning behavior

#### How to Override
```java
@Override
protected Object clone() throws CloneNotSupportedException{
    return super.clone();
}
```

#### Implementation Steps
1. Class must implement `Cloneable` interface (marker interface)
2. Override the `clone()` method
3. Call `super.clone()`
4. Declare `throws CloneNotSupportedException`

#### Example Usage
```java
Student student = new Student("Alice", 20);
Student student2 = (Student) student.clone();

System.out.println(student2.getName());          // Alice
System.out.println(student.hashCode() == student2.hashCode());  // false (different objects)
System.out.println(student.equals(student2));    // true (same content)
```

#### Important Notes
- Shallow vs Deep Copy: The default `clone()` is shallow (references are copied)
- For deep copy with mutable objects, override and handle nested objects

---

### 5. **getClass()**

#### Purpose
Returns the runtime class of the object.

#### Return Type
`Class<?>` - represents the class type

#### Example Usage
```java
Student student = new Student("Alice", 20);
System.out.println(student.getClass().getName());  // Output: Student
```

#### Common Uses
```java
// Check if object is of specific class
if(obj.getClass() == Student.class) { }

// Get class name as string
String className = student.getClass().getName();
```

---

### 6. **instanceof Operator**

#### Purpose
Checks if an object is an instance of a class or its subclass.

#### Syntax
```java
object instanceof ClassName
```

#### Example Usage
```java
Student student = new Student("Alice", 20);
System.out.println(student instanceof Student);  // true
System.out.println(student instanceof Object);   // true (all classes extend Object)
```

#### Usage in equals()
```java
if(!(obj instanceof Student)) return false;
```

---

## Complete Example: Proper Object Override

```java
class Student extends Object implements Cloneable {
    private String name;
    private int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 1. Override toString()
    @Override
    public String toString(){
        return name + "," + age;
    }

    // 2. Override equals()
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;
        
        Student s = (Student)obj;
        return this.name.equals(s.name) && this.age == s.age;
    }

    // 3. Override hashCode()
    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }

    // 4. Override clone()
    @Override
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
```

---

## Best Practices

### ✅ DO:
- Always override both `equals()` and `hashCode()` together
- Use `@Override` annotation
- Check for null and type compatibility in `equals()`
- Document the override behavior
- Use prime numbers in `hashCode()` calculation
- Follow the contract: if `equals()` returns true, `hashCode()` must be equal

### ❌ DON'T:
- Override `equals()` without `hashCode()`
- Use `==` to compare Strings in `equals()`
- Forget to handle null values
- Assume objects are of the same type without checking
- Make `hashCode()` return a constant
- Modify object state in `equals()` or `hashCode()`

---

## When to Use Each Method

| Method | Use When |
|--------|----------|
| `toString()` | Need readable representation for logging/debugging |
| `equals()` | Using objects in collections or comparing content |
| `hashCode()` | Using objects in HashMap, HashSet, or any hash-based collection |
| `clone()` | Need to create independent copies of objects |
| `getClass()` | Need to check or get the runtime class type |
| `instanceof` | Checking object types before casting |

---

## Common Mistakes

### ❌ Mistake 1: Using `==` for String Comparison in equals()
```java
// WRONG
return this.name == s.name;  // Compares references

// CORRECT
return this.name.equals(s.name);  // Compares content
```

### ❌ Mistake 2: Overriding equals() Without hashCode()
```java
// WRONG - Will break in HashSet/HashMap
@Override
public boolean equals(Object obj){ ... }

// CORRECT
@Override
public boolean equals(Object obj){ ... }

@Override
public int hashCode(){ ... }
```

### ❌ Mistake 3: Not Checking Class Type
```java
// WRONG - Can throw ClassCastException
Student s = (Student)obj;

// CORRECT
if(obj.getClass() != this.getClass()) return false;
Student s = (Student)obj;
```

---

## Summary Table

| Method | Signature | Overridable | Common Override |
|--------|-----------|-------------|-----------------|
| `toString()` | `String toString()` | Yes | ✅ Often |
| `equals()` | `boolean equals(Object)` | Yes | ✅ Always |
| `hashCode()` | `int hashCode()` | Yes | ✅ Always (with equals) |
| `clone()` | `Object clone()` | Yes | ✅ Sometimes |
| `getClass()` | `Class<?> getClass()` | No | ❌ Never |
| `finalize()` | `void finalize()` | Yes | ❌ Rarely (deprecated) |

---

## Additional Resources

- Always implement Comparable/Comparator for object ordering
- Use IDE tools to generate equals() and hashCode()
- Follow Effective Java guidelines by Joshua Bloch
- Test your implementations thoroughly with collections

