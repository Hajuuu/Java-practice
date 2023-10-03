import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6603 {

	static int[] arr;
	static int N;
	static int[] lotto;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) {
				break;
			}
			
			arr = new int[N];
			lotto = new int[6];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(int num, int depth) {
		
		if(depth == 6) {
			for(int i : lotto) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = num; i < N; i++) {
			lotto[depth] = arr[i];
			dfs(i + 1, depth + 1);
		}
	}

}
