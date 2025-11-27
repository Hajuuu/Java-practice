import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] arr;
	static int answer;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; tc++) {
			answer = -1;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0, 0);
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb);
		
	}
	
	public static void dfs(int start, int depth, int sum) {
		if(depth == 2) {
			if(sum <= M) {
				answer = Math.max(answer, sum);
			}
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			dfs(i + 1, depth + 1, sum + arr[i]);
		}
	}

}
