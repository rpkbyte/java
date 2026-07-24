
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// Scanner class
public class Demo4 {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, IOException {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter your name: ");
        // String name = sc.nextLine();
        // System.out.println("Hello, " + name + "!");
        // sc.close();
        // Scanner sc2 = new Scanner("4 5 6");
        // sc2.useDelimiter(" ");
        // int num1 = sc2.nextInt();
        // int num2 = sc2.nextInt();
        // int num3 = sc2.nextInt();
        // System.out.println("Numbers: " + num1 + ", " + num2 + ", " + num3);
        // sc2.close();

        FileWriter writer = new FileWriter("input.txt");
        writer.write(" \n This text is written into input.txt.\n");
        writer.write("Demo4 wrote this file.");
        writer.close();

        Scanner sc3 = new Scanner(new File("input.txt"));
        while (sc3.hasNextLine()) {
            String line = sc3.nextLine();
            System.out.println(line);
        }
        sc3.close();
        // Thread.sleep(num3 * 1000);
    }
}

