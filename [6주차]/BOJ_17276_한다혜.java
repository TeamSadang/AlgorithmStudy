import java.util.*;
import java.io.*;

public class BOJ_17276_한다혜 {
  public static int N;
  public static int[] fibo;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    N = Integer.parseInt(st.nextToken());
    fibo = new int[N + 2];
    fibo[0] = 1;
    fibo[1] = 1;
    for (int i = 2; i <= N; i++) {
      fibo[i] = (1 + fibo[i - 2] + fibo[i - 1]) % 1000000007;
    }
    System.out.println(fibo[N]);

  }

}
