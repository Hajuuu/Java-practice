import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2817 {

	static int count;
	static int K;
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			count = 0;
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			sb.append("#" + tc + " " + count + "\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int start, int sum) {
		if(sum == K) {
			count++;
			return;
		}
		
		for(int i = start; i < N; i++) {
			dfs(i + 1, sum + arr[i]);
		}
	}

}
