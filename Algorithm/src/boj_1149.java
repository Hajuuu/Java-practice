import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1149 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][3];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = rgb(arr, N);
		
		System.out.println(answer);
		
	}
	
	public static int rgb(int[][] arr, int N) {
		int[][] count = new int[N + 1][3];
		count[1][0] = arr[1][0];
		count[1][1] = arr[1][1];
		count[1][2] = arr[1][2];
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 3; j++) {
				count[i][j] = Math.min(count[i - 1][(j + 1) % 3] + arr[i][j], count[i - 1][(j + 2) % 3] + arr[i][j]);			
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			answer = Math.min(answer, count[N][i]);
		}
		
		return answer;
	}
	
}
