import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10819 {

	static int[] arr;
	static int answer, N;
	static boolean[] visit;
	static int[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		visit = new boolean[N];
		A = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0);

		System.out.println(answer);
	}
	
	public static void dfs(int depth) {
		if(depth == N) {
			answer = Math.max(answer, sum(A));
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				A[depth] = arr[i];
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
	
	public static int sum(int[] A) {
		int answer = 0;
		for(int i = 1; i < N; i++) {
			answer += Math.abs(A[i] - A[i - 1]);
		}
		return answer;
	}

}
