import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16439 {
	static int[][] pref;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		pref = new int[N][M];
		// 선호도 입력
		for(int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine().trim());
			for(int j=0; j<M; j++) {
				pref[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		int max = 0;
		
		for(int i=0; i<M-2; i++) {
			for(int j=i+1; j<M-1; j++) {
				for(int k=j+1; k<M; k++) {
					int subMax = 0;
					for(int l=0; l<N; l++) {
						int _max = pref[l][i];
						if(pref[l][j] > _max) _max = pref[l][j];
						if(pref[l][k] > _max) _max = pref[l][k];
						subMax += _max;
					}
					if(max < subMax)
						max = subMax;
				}
			}
		}
		
		System.out.println(max);
	}

}
