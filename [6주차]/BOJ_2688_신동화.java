package BOJ_2688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2688 {
	static long[][] allNum;
	static int[] arrayNum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		int max = 0;
		arrayNum = new int[testCase];
		for(int i=0; i<testCase; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n>max)
				max = n;
			arrayNum[i] = n;
		}
		allNum = new long[max][10];
		for(int i=0; i<10; i++)
			allNum[0][i] = i+1;
		for(int i=0; i<max; i++)
			allNum[i][0] = 1;
		for(int i=1; i<max; i++) {
			for(int j=1; j<10; j++)
				allNum[i][j] = allNum[i-1][j] + allNum[i][j-1];
		}
		for(int i=0; i<testCase; i++) {
			System.out.println(allNum[arrayNum[i]-1][9]);
		}
	}
}
