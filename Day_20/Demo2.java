import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException{

        StringBuilder s = new StringBuilder();
        int c;
        while ((c = System.in.read()) != -1 && c != '\n') {
            s.append((char) c);
        }

        System.out.println(s.toString());

        // int x = System.in.read();

        // System.out.println((char)x);
    }
}
