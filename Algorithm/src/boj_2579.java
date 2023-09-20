import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int answer = stairs(arr, N);
		System.out.println(answer);
	}
	
	public static int stairs(int[] arr, int N) {
		int[][] score = new int[N + 1][2];
		if(N < 2) {
			return arr[1];
		}
		score[1][0] = arr[1];
		score[1][1] = 0;
		score[2][0] = arr[1] + arr[2];
		score[2][1] = arr[2];
		for(int i = 3; i <= N; i++) {
			score[i][0] = score[i - 1][1] + arr[i];
			score[i][1] = Math.max(score[i - 2][0] + arr[i], score[i - 2][1] + arr[i]);
		} 
		return Math.max(score[N][0], score[N][1]);
		
	}

}
