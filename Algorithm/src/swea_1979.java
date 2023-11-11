import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1979 {

	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int sum = check1(n, k) + check2(n, k);
			sb.append("#" + tc + " " + sum + "\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static int check1(int n, int k) {
		int answer = 0;
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 0) {
					if(sum == k) {
						answer++;
					}
					sum = 0;
					continue;
				}
				sum += arr[i][j];
			}
			if(sum == k) {
				answer++;
			}
		}
		return answer;
	}
	
	public static int check2(int n, int k) {
		int answer = 0;
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = 0; j < n; j++) {
				if(arr[j][i] == 0) {
					if(sum == k) {
						answer++;
					}
					sum = 0;
					continue;
				}
				sum += arr[j][i];
			}
			if(sum == k) {
				answer++;
			}
			
		}
		return answer;
	}

}
