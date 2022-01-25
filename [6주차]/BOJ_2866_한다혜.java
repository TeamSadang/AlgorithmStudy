import java.util.*;
import java.io.*;

public class BOJ_2866_한다혜 {
  public static int R, C;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    char[][] word = new char[R][C];
    for (int i = 0; i < R; i++) {
      word[i] = br.readLine().toCharArray();
    }
    String[] str = new String[C];
    for (int j = 0; j < C; j++) {
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i < R; i++) {
        sb.append(word[i][j]);
      }
      str[j] = sb.toString();
    }
    boolean flag = false;
    int cnt = 0;
    for (int i = 0; i < R; i++) {
      Set<String> set = new HashSet<>();
      for (int j = 0; j < C; j++) {
        String cur = str[j].substring(i); // index 0 ~ 부터 string에 담음
        if (set.contains(cur)) { // 동일한 문자열이 있으면 빠져나옴
          flag = true;
          break;
        } else {
          set.add(cur); // 없으면 set에 담음
        }
      }
      if (flag)
        break;
      cnt++;
    }
    System.out.println(cnt);
  }

}
