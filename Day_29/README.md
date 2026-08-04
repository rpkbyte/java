# Java Collection Framework Notes

## 1. What is the Collection Framework?

The Java Collection Framework is a set of classes and interfaces used to store and manage groups of objects.
It helps you work with data in a structured way using methods like add, remove, search, sort, and iterate.

### Important terms
- Collection: an interface that represents a group of objects.
- Collections: a utility class that provides static methods such as sort(), reverse(), shuffle(), and max().

---

## 2. Collection Interface

The Collection interface is the root of most collection types in Java.
It defines common operations such as:
- add(object)
- remove(object)
- contains(object)
- size()
- isEmpty()
- clear()
- iterator()

### How it works
A Collection stores multiple elements in one object. You can add or remove elements dynamically. It is used when you want to manage a group of values together.

Example:
```java
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Collection<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");

        System.out.println(fruits);
        fruits.remove("Banana");
        System.out.println(fruits);
    }
}
```

---

## 3. Child Interfaces of Collection

The Collection interface has several child interfaces.

### 3.1 List Interface
The List interface stores elements in order and allows duplicates.

#### Features
- Maintains insertion order
- Allows duplicate values
- Supports index-based access

#### Common classes
- ArrayList
- LinkedList
- Vector

#### How it works
List is useful when you need to access items by position, such as index 0, 1, 2, and so on.

Example:
```java
List<String> names = new ArrayList<>();
names.add("Amit");
names.add("Rahul");
names.add("Amit");
System.out.println(names);
```

#### ArrayList
- Uses a dynamic array internally
- Fast for reading and accessing data by index
- Slower when inserting or removing in the middle

#### LinkedList
- Uses linked nodes internally
- Good for insertion and deletion in the middle
- Slower for random access by index

#### Vector
- Synchronized and thread-safe
- Slower than ArrayList in most cases

---

### 3.2 Set Interface
The Set interface stores unique elements only.

#### Features
- No duplicates allowed
- No guaranteed order (except some implementations)

#### Common classes
- HashSet
- LinkedHashSet
- TreeSet

#### How it works
Set is useful when you want to store only one copy of each value.

Example:
```java
Set<Integer> numbers = new HashSet<>();
numbers.add(10);
numbers.add(20);
numbers.add(10);
System.out.println(numbers);
```

#### HashSet
- Uses hashing for fast access
- Does not preserve insertion order

#### LinkedHashSet
- Preserves insertion order
- Still avoids duplicates

#### TreeSet
- Stores elements in sorted order
- Uses a tree structure

---

### 3.3 Queue Interface
The Queue interface is used for holding elements before processing.

#### Features
- Follows FIFO order (First In, First Out)
- Used in job scheduling and processing tasks

#### Common classes
- PriorityQueue
- LinkedList

#### How it works
Elements are inserted at the end and removed from the front.

Example:
```java
Queue<String> queue = new LinkedList<>();
queue.add("A");
queue.add("B");
queue.add("C");
System.out.println(queue.remove());
```

#### PriorityQueue
- Elements are processed based on priority
- Not FIFO by default

---

### 3.4 Deque Interface
Deque stands for Double Ended Queue.
It allows insertion and removal from both ends.

#### Features
- Can add/remove from front and back
- More flexible than normal Queue

#### Common classes
- ArrayDeque
- LinkedList

#### How it works
Deque is useful for implementing stacks and queues efficiently.

Example:
```java
Deque<String> deque = new ArrayDeque<>();
deque.addFirst("A");
deque.addLast("B");
System.out.println(deque.removeFirst());
```

---

## 4. Common Implementations Summary

| Interface | Main Purpose | Common Classes |
|---|---|---|
| List | Ordered collection with duplicates | ArrayList, LinkedList, Vector |
| Set | Unique elements only | HashSet, LinkedHashSet, TreeSet |
| Queue | FIFO processing | PriorityQueue, LinkedList |
| Deque | Double-ended queue | ArrayDeque, LinkedList |

---

## 5. When to Use Which?

- Use List when order matters and duplicates are allowed.
- Use Set when duplicate values should not exist.
- Use Queue when data should be processed in order.
- Use Deque when you need operations from both ends.

---

## 6. Important Note

In Java:
- Collection is an interface.
- Collections is a utility class.

So, Collection is used to define the data structure, while Collections provides built-in operations for it.

---

## 7. Short Example of Collections Utility Class

```java
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(10);
        list.add(30);

        Collections.sort(list);
        System.out.println(list);
    }
}
```

---

## 8. Conclusion

The Java Collection Framework is one of the most important parts of Java programming.
It provides a standard way to store and manage groups of objects efficiently.
Understanding Collection, List, Set, Queue, and Deque helps you choose the best structure for your program.
