# Java I/O Guide

## Overview
Java I/O (Input/Output) is the system that allows Java programs to read data from and write data to files, memory, network connections, consoles, and other data sources. The `java.io` and `java.nio` packages provide classes for working with byte streams, character streams, and file systems.

This guide focuses on the classic Java I/O API based on streams, readers, and writers.

---

## 1. Streams, Readers, and Writers

### 1.1 Byte Streams vs Character Streams
- Byte streams handle raw binary data.
- Character streams handle text data and apply character encoding.

Byte stream base classes:
- `InputStream` (read bytes)
- `OutputStream` (write bytes)

Character stream base classes:
- `Reader` (read characters)
- `Writer` (write characters)

### 1.2 Why use Reader/Writer?
- Text data requires encoding and decoding.
- `Reader` and `Writer` simplify working with text.
- They are built on top of byte streams to convert bytes to characters using a charset.

Example:
- `FileReader` / `FileWriter`
- `BufferedReader` / `BufferedWriter`
- `InputStreamReader` / `OutputStreamWriter`

---

## 2. Common Reader Classes

### 2.1 `Reader`
The abstract class for reading character streams.
Common methods:
- `int read()` reads a single character
- `int read(char[] cbuf)` reads characters into a buffer
- `void close()` closes the stream

### 2.2 `InputStreamReader`
Converts a byte stream (`InputStream`) into a character stream (`Reader`).
Useful for reading text from an input source with a known charset.

Example:
```java
try (InputStreamReader reader = new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8)) {
    int ch;
    while ((ch = reader.read()) != -1) {
        System.out.print((char) ch);
    }
}
```

### 2.3 `FileReader`
A convenience class for reading character files using the platform default charset.

Example:
```java
try (FileReader reader = new FileReader("input.txt")) {
    int ch;
    while ((ch = reader.read()) != -1) {
        System.out.print((char) ch);
    }
}
```

> Note: Prefer `InputStreamReader` with `StandardCharsets.UTF_8` if you need a specific encoding.

### 2.4 `BufferedReader`
Wraps a `Reader` to add buffering and more efficient reading.
Provides convenient methods like `readLine()`.

Example:
```java
try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
}
```

### 2.5 Other useful readers
- `StringReader` – read characters from a `String`
- `CharArrayReader` – read characters from a `char[]`
- `PipedReader` – connect to a `PipedWriter` for thread communication

---

## 3. Common Writer Classes

### 3.1 `Writer`
The abstract class for writing character streams.
Common methods:
- `void write(int c)` writes a single character
- `void write(char[] cbuf)` writes characters from a buffer
- `void write(String str)` writes a string
- `void flush()` forces buffered output to be written
- `void close()` closes the stream

### 3.2 `OutputStreamWriter`
Converts a character stream (`Writer`) into a byte stream (`OutputStream`).
Useful when you want to write text using a specific charset.

Example:
```java
try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("output.txt"), StandardCharsets.UTF_8)) {
    writer.write("Hello, Java I/O!\n");
}
```

### 3.3 `FileWriter`
A convenience class for writing character files using the platform default charset.

Example:
```java
try (FileWriter writer = new FileWriter("output.txt")) {
    writer.write("Hello, file writer!\n");
}
```

> Note: Prefer `OutputStreamWriter` with explicit charset when you need consistent text encoding.

### 3.4 `BufferedWriter`
Wraps a `Writer` to add buffering and improve efficiency.
Provides `newLine()`.

Example:
```java
try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
    bw.write("Line 1");
    bw.newLine();
    bw.write("Line 2");
}
```

### 3.5 Other useful writers
- `StringWriter` – write characters to a `String` buffer
- `CharArrayWriter` – write characters to a `char[]`
- `PipedWriter` – connect to a `PipedReader`

---

## 4. Byte Stream Classes

Byte streams are ideal for binary data such as images, audio, and serialized objects.

### 4.1 `InputStream`
Abstract class for reading bytes.
Common subclasses:
- `FileInputStream`
- `ByteArrayInputStream`
- `BufferedInputStream`
- `DataInputStream`

Example:
```java
try (FileInputStream fis = new FileInputStream("file.bin")) {
    int b;
    while ((b = fis.read()) != -1) {
        // process byte value b
    }
}
```

### 4.2 `OutputStream`
Abstract class for writing bytes.
Common subclasses:
- `FileOutputStream`
- `ByteArrayOutputStream`
- `BufferedOutputStream`
- `DataOutputStream`

Example:
```java
try (FileOutputStream fos = new FileOutputStream("file.bin")) {
    fos.write(0x42);
}
```

### 4.3 Buffered byte streams
- `BufferedInputStream`
- `BufferedOutputStream`

They improve performance by reducing the number of native I/O calls.

Example:
```java
try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("file.bin"))) {
    byte[] buffer = new byte[8192];
    int read;
    while ((read = bis.read(buffer)) != -1) {
        // process bytes
    }
}
```

---

## 5. Data Streams and Object Streams

### 5.1 `DataInputStream` / `DataOutputStream`
Used for reading and writing Java primitive data types with binary encoding.

Example:
```java
try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin"))) {
    dos.writeInt(42);
    dos.writeDouble(3.14);
    dos.writeUTF("Hello");
}

try (DataInputStream dis = new DataInputStream(new FileInputStream("data.bin"))) {
    int x = dis.readInt();
    double d = dis.readDouble();
    String s = dis.readUTF();
}
```

### 5.2 `ObjectOutputStream` / `ObjectInputStream`
Used for serializing and deserializing Java objects.
Classes must implement `Serializable`.

Example:
```java
import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;
}
```

```java
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
    oos.writeObject(new Person("Alice", 30));
}

try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {
    Person p = (Person) ois.readObject();
}
```

---

## 6. File I/O utilities

### 6.1 `File`
Represents file and directory pathnames.
Useful methods:
- `exists()`
- `isFile()` / `isDirectory()`
- `mkdir()` / `mkdirs()`
- `delete()`
- `length()`
- `listFiles()`

Example:
```java
File file = new File("example.txt");
if (file.exists()) {
    System.out.println("Size: " + file.length());
}
```

### 6.2 `RandomAccessFile`
Allows reading and writing at arbitrary file positions.
Useful for binary files that require seek operations.

Example:
```java
try (RandomAccessFile raf = new RandomAccessFile("data.bin", "rw")) {
    raf.seek(100);
    raf.writeInt(123);
}
```

---

## 7. Reading and Writing Patterns

### 7.1 Try-with-resources
Always close I/O resources to avoid leaks.
Use try-with-resources when possible.

Example:
```java
try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
    // use reader
}
```

### 7.2 Reading text line by line

```java
try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
}
```

### 7.3 Writing text line by line

```java
try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
    bw.write("First line");
    bw.newLine();
    bw.write("Second line");
}
```

### 7.4 Copying files with streams

#### Text file copy using Reader/Writer:
```java
try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
     BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
    String line;
    while ((line = br.readLine()) != null) {
        bw.write(line);
        bw.newLine();
    }
}
```

#### Binary file copy using InputStream/OutputStream:
```java
try (InputStream in = new BufferedInputStream(new FileInputStream("source.bin"));
     OutputStream out = new BufferedOutputStream(new FileOutputStream("target.bin"))) {
    byte[] buffer = new byte[8192];
    int bytesRead;
    while ((bytesRead = in.read(buffer)) != -1) {
        out.write(buffer, 0, bytesRead);
    }
}
```

---

## 8. Character Encoding and Charset

Character streams convert bytes to characters using a charset.
Always specify `StandardCharsets.UTF_8` when reading or writing text files unless the file uses a different encoding.

Example:
```java
try (Reader reader = new InputStreamReader(new FileInputStream("file.txt"), StandardCharsets.UTF_8);
     Writer writer = new OutputStreamWriter(new FileOutputStream("copy.txt"), StandardCharsets.UTF_8)) {
    int ch;
    while ((ch = reader.read()) != -1) {
        writer.write(ch);
    }
}
```

Common charsets:
- `StandardCharsets.UTF_8`
- `StandardCharsets.ISO_8859_1`
- `StandardCharsets.US_ASCII`
- `Charset.forName("UTF-16")`

---

## 9. Error handling

I/O operations may throw checked exceptions such as `IOException` and `FileNotFoundException`.
Handle or declare these exceptions.

Example:
```java
try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
    // read file
} catch (IOException e) {
    e.printStackTrace();
}
```

---

## 10. Best Practices

- Use `try-with-resources` whenever possible.
- Prefer buffered streams/readers/writers for better performance.
- Use `InputStreamReader`/`OutputStreamWriter` with explicit charset for text.
- Validate file paths before reading or writing.
- Avoid mixing text readers with binary streams on the same file unless you know the format.
- Close streams to release system resources.
- For large files, process data in chunks rather than reading the whole file into memory.

---

## 11. Advanced Topics (When to use next)

### 11.1 `java.nio.file` (NIO.2)
Modern file I/O API supporting `Path`, `Files`, `FileVisitor`, and more.
Offers simpler methods for many common tasks, such as `Files.readAllLines()` and `Files.newBufferedReader()`.

### 11.2 `java.nio.channels`
Supports non-blocking I/O, file locking, and direct buffer transfer.
Useful for high-performance systems.

### 11.3 Asynchronous and non-blocking I/O
`java.nio.channels.AsynchronousFileChannel` and `AsynchronousSocketChannel` support asynchronous operations.

---

## 12. Summary

Java I/O has two main families:
- Byte-based I/O (`InputStream` / `OutputStream`)
- Character-based I/O (`Reader` / `Writer`)

Use readers/writers when working with text, and remember to buffer for performance. Always manage resources with try-with-resources and choose the right abstraction for your data type.

This guide covers the core classes and patterns needed to understand Java I/O from beginning to end.