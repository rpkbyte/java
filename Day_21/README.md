# Immutable Class in Java

An immutable class is a class whose state cannot be changed after an object is created.

Once an immutable object is created, its fields or data cannot be modified. Any operation that appears to modify the object actually creates a new object instead.

## Why Use Immutable Classes?

Immutable classes are useful because they:

- are safer to share across threads
- prevent accidental changes to data
- make code easier to reason about
- reduce bugs caused by side effects

## Characteristics of an Immutable Class

A class is considered immutable when:

1. The class is declared as `final`
2. All fields are declared as `private`
3. All fields are declared as `final`
4. There are no setters or mutator methods
5. The class does not expose mutable objects directly
6. If mutable objects are used internally, they should be defensively copied

## Example of an Immutable Class

```java
final class Student {
    private final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
```

## Explanation of the Example

In this class:

- `Student` is declared `final`, so it cannot be extended
- `id` and `name` are `private` and `final`
- There are no setter methods
- The values are assigned only once in the constructor

This means once a `Student` object is created, its data can never be changed.

## Mutable vs Immutable

### Mutable Class

```java
class Student {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
```

In a mutable class, the object state can be changed using setters.

### Immutable Class

```java
final class Student {
    private final int id;

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
```

In an immutable class, the state cannot be changed after initialization.

## Important Notes

### 1. Use `final` for the class

Making the class `final` prevents subclassing and ensures immutability is not broken by a subclass.

### 2. Make fields `private final`

This prevents direct access and reassignment after construction.

### 3. Do not provide setters

Setters allow changes to the object's internal state.

### 4. Defensive copying for mutable fields

If an immutable class contains objects like arrays, lists, or custom mutable classes, you must protect them by copying the data before storing or returning it.

Example:

```java
final class Person {
    private final String name;
    private final String[] hobbies;

    public Person(String name, String[] hobbies) {
        this.name = name;
        this.hobbies = hobbies.clone();
    }

    public String[] getHobbies() {
        return hobbies.clone();
    }
}
```

## Real-World Example

Java's built-in `String` class is immutable.

```java
String s = "Hello";
// s cannot be modified directly
```

When you perform a string operation, Java creates a new string rather than modifying the old one.

## Benefits of Immutable Classes

- thread safety
- easier debugging
- safe sharing
- better reliability in multi-threaded applications
- fewer side effects

## Drawbacks of Immutable Classes

- can use more memory because new objects are created often
- less convenient when frequent modifications are needed

## Summary

An immutable class in Java is a class whose object state cannot be changed after it is created.

To make a class immutable:

- make the class `final`
- make fields `private final`
- do not provide setters
- do not expose mutable internals directly

## Short Interview Answer

An immutable class is one whose state cannot be changed after creation. In Java, we make the class `final`, declare fields as `private final`, avoid setters, and initialize values only in the constructor.
