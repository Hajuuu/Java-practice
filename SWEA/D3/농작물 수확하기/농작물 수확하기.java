import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for(int j = 0; j < N; j++) {
				String str = br.readLine();
				for(int q = 0; q < N; q++) {
					arr[j][q] = str.charAt(q) - '0';
				}
			}
			int sum = 0;
			for(int j = 0; j <= N / 2; j++) {
				for(int q = N / 2 - j; q <= N / 2 + j; q++) {
					sum += arr[j][q];
				}
			}
			
		
			for(int j = 1; j <= N / 2; j++) {
				for(int q = j; q < N - j; q++) {
					sum += arr[j + N / 2][q];
				}
			}
			
			sb.append("#" + i + " " + sum + "\n");
		}
		System.out.println(sb);
	}
	

}
