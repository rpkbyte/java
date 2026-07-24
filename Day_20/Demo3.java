// BufferREader

import java.io.*;


public class Demo3 {
    public static void main(String[] args) throws IOException {
        // InputStreamReader isr = new InputStreamReader(System.in);
        // BufferedReader br = new BufferedReader(isr);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        System.out.println("Hello, " + name + "!");
    }
}
