import java.util.*;
import java.io.*;

public class BOJ_16439_한다혜 {
  public static int N, M;
  public static boolean[] visited;
  public static int[][] arr;
  public static int max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N][M];
    visited = new boolean[M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine().trim());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < M; i++) {
      visited[i] = true;
      dfs(i, 1); // 치킨 종류 인덱스, 카운트
      visited[i] = false;
    }
    System.out.println(max);
  }

  public static int cal() {
    int res = 0;
    for (int i = 0; i < N; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < M; j++) {
        if (visited[j])
          if (max < arr[i][j]) {
            max = arr[i][j];
          }
      }
      res += max;
    }
    return res;
  }

  public static void dfs(int idx, int cnt) {
    if (cnt == 3) {
      int res = cal();
      if (res > max) {
        max = cal();
      }
      return;
    }
    for (int i = idx + 1; i < M; i++) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(i, cnt + 1);
        visited[i] = false;
      }
    }
  }
}
