import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17175 {
	static int[] numOfCall;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		numOfCall = new int[N+2];
		numOfCall[0] = 1;
		numOfCall[1] = 1;
		for(int i=2; i<=N; i++) {
			numOfCall[i] = numOfCall[i-1] + numOfCall[i-2] + 1;
			numOfCall[i] %= 1000000007;
		}
		System.out.println(numOfCall[N]);
	}
}
