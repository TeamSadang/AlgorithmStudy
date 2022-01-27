package BOJ_17276;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17276 {
	static int[][][] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		result = new int[testCase][][];
		// 테스트케이스 만큼 루프
		for(int i=0; i<testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			// size : 배열 크기, count : 각도 수치화
			int size = Integer.parseInt(st.nextToken());
			int degrees = Integer.parseInt(st.nextToken());
			int count = degrees >= 0 ? degrees/45 : (360 + degrees)/45;
			count %= 8;
			int[][] arr = new int[size][size];
			result[i] = new int[size][size];
			// 배열 입력
			for(int j=0; j<size; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
				for(int k=0; k<size; k++) {
					int num = Integer.parseInt(st2.nextToken());
					arr[j][k] = result[i][j][k] = num;
				}
			}
			// 회전
			rotate(i, arr, size, count);
		}
		for(int i=0; i<testCase; i++) {
			int len = result[i].length;
			for(int j=0; j<len; j++) {
				for(int k=0; k<len-1; k++)
					System.out.print(result[i][j][k] + " ");
				System.out.println(result[i][j][len-1]);
			}
		}
	}
	
	public static void rotate(int testCase, int[][] arr, int size, int count) {
		int mid = size/2;
		int len = size-1;
		//네 가지 선분으로 구분
		if(count == 0) {
			return;
		}
		if(count == 1) {
			for(int i=0; i<mid; i++) {
				result[testCase][i][mid] = arr[i][i];
				result[testCase][i][len-i] = arr[i][mid];
				result[testCase][mid][len-i] = arr[i][len-i];
				result[testCase][len-i][len-i] = arr[mid][len-i];
				result[testCase][len-i][mid] = arr[len-i][len-i];
				result[testCase][len-i][i] = arr[len-i][mid];
				result[testCase][mid][i] = arr[len-i][i];
				result[testCase][i][i] = arr[mid][i];
			}
			return;
		}
		if(count == 2) {
			for(int i=0; i<mid; i++) {
				result[testCase][i][len-i] = arr[i][i];
				result[testCase][mid][len-i] = arr[i][mid];
				result[testCase][len-i][len-i] = arr[i][len-i];
				result[testCase][len-i][mid] = arr[mid][len-i];
				result[testCase][len-i][i] = arr[len-i][len-i];
				result[testCase][mid][i] = arr[len-i][mid];
				result[testCase][i][i] = arr[len-i][i];
				result[testCase][i][mid] = arr[mid][i];
			}
			return;
		}
		if(count == 3) {
			for(int i=0; i<mid; i++) {
				result[testCase][mid][len-i] = arr[i][i];
				result[testCase][len-i][len-i] = arr[i][mid];
				result[testCase][len-i][mid] = arr[i][len-i];
				result[testCase][len-i][i] = arr[mid][len-i];
				result[testCase][mid][i] = arr[len-i][len-i];
				result[testCase][i][i] = arr[len-i][mid];
				result[testCase][i][mid] = arr[len-i][i];
				result[testCase][i][len-i] = arr[mid][i];
			}
			return;
		}
		if(count == 4) {
			for(int i=0; i<mid; i++) {
				result[testCase][len-i][len-i] = arr[i][i];
				result[testCase][len-i][mid] = arr[i][mid];
				result[testCase][len-i][i] = arr[i][len-i];
				result[testCase][mid][i] = arr[mid][len-i];
				result[testCase][i][i] = arr[len-i][len-i];
				result[testCase][i][mid] = arr[len-i][mid];
				result[testCase][i][len-i] = arr[len-i][i];
				result[testCase][mid][len-i] = arr[mid][i];
			}
			return;
		}
		if(count == 5) {
			for(int i=0; i<mid; i++) {
				result[testCase][len-i][mid] = arr[i][i];
				result[testCase][len-i][i] = arr[i][mid];
				result[testCase][mid][i] = arr[i][len-i];
				result[testCase][i][i] = arr[mid][len-i];
				result[testCase][i][mid] = arr[len-i][len-i];
				result[testCase][i][len-i] = arr[len-i][mid];
				result[testCase][mid][len-i] = arr[len-i][i];
				result[testCase][len-i][len-i] = arr[mid][i];
			}
			return;
		}
		if(count == 6) {
			for(int i=0; i<mid; i++) {
				result[testCase][len-i][i] = arr[i][i];
				result[testCase][mid][i] = arr[i][mid];
				result[testCase][i][i] = arr[i][len-i];
				result[testCase][i][mid] = arr[mid][len-i];
				result[testCase][i][len-i] = arr[len-i][len-i];
				result[testCase][mid][len-i] = arr[len-i][mid];
				result[testCase][len-i][len-i] = arr[len-i][i];
				result[testCase][len-i][mid] = arr[mid][i];
			}
			return;
		}
		if(count == 7) {
			for(int i=0; i<mid; i++) {
				result[testCase][mid][i] = arr[i][i];
				result[testCase][i][i] = arr[i][mid];
				result[testCase][i][mid] = arr[i][len-i];
				result[testCase][i][len-i] = arr[mid][len-i];
				result[testCase][mid][len-i] = arr[len-i][len-i];
				result[testCase][len-i][len-i] = arr[len-i][mid];
				result[testCase][len-i][mid] = arr[len-i][i];
				result[testCase][len-i][i] = arr[mid][i];
			}
			return;
		}
	}
}
