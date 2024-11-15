import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_2806 {
	
	static int[] board;
	static int N;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			count = 0;
			board = new int[N];
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
			board[depth] = i;
			if(check(depth)) {
				dfs(depth + 1);
			}
		}
	}
	
	public static boolean check(int num) {
		for(int i = 0; i < num; i++) {
			if(board[i] == board[num] || ((board[num] - board[i] == num - i) || (board[i] - board[num] == num - i))) {
				return false;
			}
		}
		return true;
	}

}
