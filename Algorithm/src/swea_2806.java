import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_2806 {

	static int count;
	static int[] queen;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; tc++) {
			N = Integer.parseInt(br.readLine());
			count = 0;
			queen = new int[N];
			dfs(0);
			sb.append("#" + tc + " " + count + "\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			queen[depth] = i;
			if(check(depth)) {
				dfs(depth + 1);
			}
		} 
	}
	
	public static boolean check(int N) {
		for(int i = 0; i < N; i++) {
			if(queen[i] == queen[N] || (N - i) == Math.abs(queen[N] - queen[i])) {
				return false;
			}
		}
		return true;
	}

}
