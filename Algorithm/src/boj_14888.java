import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888 {

	
	static int[] arr;
	static int N;
	static int max, min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int add = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		int mul = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		dfs(1, arr[0], add, sub, mul, div);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int depth, int sum, int add, int sub, int mul, int div) {
		if(depth == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		if(add > 0) {
			dfs(depth + 1, sum + arr[depth], add - 1, sub, mul, div);
		}
		if(sub > 0) {
			dfs(depth + 1, sum - arr[depth], add, sub - 1, mul, div);
		}
		if(mul > 0) {
			dfs(depth + 1, sum * arr[depth], add, sub, mul - 1, div);
		}
		if(div > 0) {
			dfs(depth + 1, sum / arr[depth], add, sub, mul, div - 1);
		}
		
	}


}
