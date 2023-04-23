import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] darr;
	static boolean[] isUsed;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		darr = new int[M];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		isUsed = new boolean[arr[N - 1] + 1];
		
		dfs(0);
		
		
		System.out.println(sb);
		
	}
	
	public static void dfs(int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(darr[i] + " ");			
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!isUsed[arr[i]]) {
				isUsed[arr[i]] = true;
				darr[depth] = arr[i];
				dfs(depth + 1);
				
				isUsed[arr[i]] = false;
			}
			
			
		}
	}
} 
