import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3980 {
	static int[][] S = new int[11][11];
	static boolean[] check = new boolean[11];
	static int maxSum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		int[] resultSet = new int[C];
		for(int i=0; i<C; i++) {
			for(int j=0; j<11; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for(int k=0; k<11; k++)
					S[j][k] = Integer.parseInt(st.nextToken());
			}
			
			maxSum = 0;
			searchMaxSum(0, 0);
			System.out.println(maxSum);
		}
	}
	
	static public void searchMaxSum(int idx, int curSum) {
		if(idx == 11) {
			if(curSum > maxSum)
				maxSum = curSum;
			return;
		}
		for(int i=0; i<11; i++) {
			if(!check[i] && S[idx][i] != 0) {
				check[i] = true;
				searchMaxSum(idx+1, curSum + S[idx][i]);
				check[i] = false;
			}
		}
	}

}
