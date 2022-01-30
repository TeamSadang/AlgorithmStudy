import java.io.*;

public class boj_2671 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        String regex = "(100+1+|01)+";

        if (input.matches(regex)) {
            System.out.println("SUBMARINE");
        }
        else
            System.out.println("NOISE");
    }
}
