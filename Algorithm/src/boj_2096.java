import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2096 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] max = new int[N + 1][3];
		int[][] min = new int[N + 1][3];
		int[][] arr = new int[N + 1][3];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) {
					max[i][j] = Math.max(max[i - 1][j] + arr[i][j], max[i - 1][j + 1] + arr[i][j]);
					min[i][j] = Math.min(min[i - 1][j] + arr[i][j], min[i - 1][j + 1] + arr[i][j]);
				} else if(j == 1) {
					max[i][j] = Math.max(max[i - 1][j] + arr[i][j], Math.max(max[i - 1][j - 1] + arr[i][j], max[i - 1][j + 1] + arr[i][j]));
					min[i][j] = Math.min(min[i - 1][j] + arr[i][j], Math.min(min[i - 1][j - 1] + arr[i][j], min[i - 1][j + 1] + arr[i][j]));
				} else {
					max[i][j] = Math.max(max[i - 1][j] + arr[i][j], max[i - 1][j - 1] + arr[i][j]);
					min[i][j] = Math.min(min[i - 1][j] + arr[i][j], min[i - 1][j - 1] + arr[i][j]);
				}
			}
		}
		
		int minimum = Integer.MAX_VALUE;
		int maximum = Integer.MIN_VALUE;
		
		minimum = Math.min(min[N][0], Math.min(min[N][1], min[N][2]));
		maximum = Math.max(max[N][0], Math.max(max[N][1], max[N][2]));
		
		System.out.println(maximum + " " + minimum);
	}

}
