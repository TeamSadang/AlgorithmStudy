package BOJ;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BOJ_20119_한기연_시간초과 {
	static class Recipe {
		int num;
		Set<Integer> set;

		public Recipe(int num, Set<Integer> set) {
			super();
			this.num = num;
			this.set = set;
		}
	}

	static int N, M, L;
	static List<Recipe> recipe;
	static boolean[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 물약의 종류의 수 N
		M = sc.nextInt();// 레시피의 개수 M
		recipe = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int len = sc.nextInt();
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < len; j++) {
				set.add(sc.nextInt());
			}
			int num = sc.nextInt();
			recipe.add(new Recipe(num, set));
		}

		L = sc.nextInt();// 가지고 있는 물약 종류의 수 L
		Queue<Integer> q = new LinkedList<>();
		memo = new boolean[N + 1];
		for (int i = 0; i < L; i++) {
			int x = sc.nextInt();
			q.add(x);
			memo[x] = true;
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < recipe.size(); i++) {
				Recipe r = recipe.get(i);
				if (r.num == now) {
					continue;
				}
				if (r.set.contains(now)) {
					r.set.remove(now);
				}
				if (r.set.size() == 0) {
					if (!memo[r.num]) {
						memo[r.num] = true;
						q.add(r.num);
					}
					recipe.remove(i);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 0; i < memo.length; i++) {
			if (memo[i]) {
				sb.append(i + " ");
				cnt++;
			}
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
}