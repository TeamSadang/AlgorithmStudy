import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14600 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int hole = 0;
		
		if(K == 1) {
			int[][] tile = new int[2][2];
			tile[2-Y][X-1] = -1;
			for(int i=0; i<2; i++)
				for(int j=0; j<2; j++)
					if(tile[i][j] != -1)
						tile[i][j] = 1;
			
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					System.out.print(tile[i][j]);
					if(j != 1)
						System.out.print(" ");
				}
				System.out.println();
			}
		}
		if(K == 2) {
			int [][] tile = new int[4][4];
			tile[4-Y][X-1] = -1;
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(i<2 && j<2) {
						if(tile[i][j] == -1)
							hole = 1;
						tile[i][j] = 1;
					} else if(i<2 && j>=2) {
						if(tile[i][j] == -1)
							hole = 2;
						tile[i][j] = 2;
					} else if(i>=2 && j<2) {
						if(tile[i][j] == -1)
							hole = 3;
						tile[i][j] = 3;
					} else if(i>=2 && j>=2) {
						if(tile[i][j] == -1)
							hole = 4;
						tile[i][j] = 4;
					}
				}
			}
			for(int i=1; i<3; i++) {
				for(int j=1; j<3; j++) {
					if(hole != tile[i][j])
						tile[i][j] = 5;
				}
			}
			tile[4-Y][X-1] = -1;
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					System.out.print(tile[i][j]);
					if(j != 3)
						System.out.print(" ");
				}
				System.out.println();
			}
		}
	}

}
