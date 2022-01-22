package BOJ;

import java.util.Scanner;

public class BOJ_14570_한기연_런타임에러_NullPointer {

	static class Node {
		int num, cnt;
		Node left, right, parent;

		public Node(int num) {
			this.num = num;
			this.cnt = 0;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
	}

	static int N;
	static long K;
	static Node[] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tree = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new Node(i);
		}

		for (int i = 1; i <= N; i++) {
			int l = sc.nextInt(); // 왼쪽 자식노드
			int r = sc.nextInt(); // 오른쪽 자식노드
			if (l != -1) {
				tree[i].left = tree[l];
				tree[l].parent = tree[i];
			}
			if (r != -1) {
				tree[i].right = tree[r];
				tree[r].parent = tree[i];
			}
		}
		K = sc.nextLong();
		int ret = 0;
		for (long i = 0; i < K; i++) {
			ret = DFS(tree[1]).num;
		}
		System.out.println(ret);
	}

	private static Node DFS(Node now) {
		now.cnt +=1;
		// 1. 현재 구슬이 놓인 노드의 자식이 없다면 그 자리에서 멈춘다.
		if (now.left == null && now.right == null) {
			return now;
		}
		
		// 2. 1을 만족하지 않으며, 만일 현재 구슬이 놓인 노드의 자식 노드가 한 개라면 해당 자식 노드로 떨어진다.
		if (now.left != null && now.right == null) {
			// 오른쪽으로
			return DFS(now.right);
		} else if (now.left == null && now.right != null) {
			// 왼쪽으로
			return DFS(now.left);
		}
		
		// 3. 1, 2를 만족하지 않으며, 만일 현재 구슬이 놓인 노드의 자식 노드가 두 개라면,
		if (now.left.cnt <= now.right.cnt) {
			// 3-1. 현재 노드의 왼쪽 서브트리에 담긴 모든 구슬의 수 <= 오른쪽 서브트리에 담긴 모든 구슬의 수일 경우,
			// 왼쪽 자식 노드로 떨어진다.
			return DFS(now.left);
		} else {
			// 3-2. 그 외의 경우에는 오른쪽 자식 노드로 떨어진다.
			return DFS(now.right);
		}
	}
}