package BOJ;
import java.util.Scanner;

public class BOJ_16439_치킨치킨치킨 {
	static int N, M, ans;
	static int[][] arr;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		visit = new boolean[M];
		ans = 0;
		solve(0, 0);
		System.out.println(ans);
	}

	private static void solve(int start, int depth) {
		if (depth == 3) {
			int ret = check();
			ans = ret > ans ? ret : ans;
		}
		for (int i = start; i < M; i++) {
			if (!visit[i]) {
				visit[i] = true;
				solve(i + 1, depth + 1);
				visit[i] = false;
			}
		}
	}

	private static int check() {
		int ret = 0;
		for (int i = 0; i < N; i++) {
			int max = -1;
			for (int j = 0; j < M; j++) {
				if (visit[j])
					max = max < arr[i][j] ? arr[i][j] : max;
			}
			ret += max;
		}
		return ret;
	}
}