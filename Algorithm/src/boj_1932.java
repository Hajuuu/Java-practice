import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1932 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[][] arr = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = sum(arr, N);
		System.out.println(answer);
	}
	
	public static int sum(int[][] arr, int N) {
		int[][] count = new int[N + 1][N + 1];
		
		count[1][1] = arr[1][1];
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(j - 1 < 1) {
					count[i][j] = count[i - 1][j] + arr[i][j];
					continue;
				}
				count[i][j] = Math.max(count[i - 1][j] + arr[i][j], count[i - 1][j - 1] + arr[i][j]);
			}
		}
		
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			if(answer < count[N][i]) {
				answer = count[N][i];
			}
		}
		return answer;
	}

}
