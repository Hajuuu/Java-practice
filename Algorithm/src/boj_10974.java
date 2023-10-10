import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10974 {

	static boolean[] visit;
	static int[] arr;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		visit = new boolean[N + 1];
		arr = new int[N];
		
		printNum(0);
		System.out.println(sb);
	}
	
	public static void printNum(int depth) {
		if(depth == N) {
			for(int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visit[i]) {
				arr[depth] = i;
				visit[i] = true;
				printNum(depth + 1);
				visit[i] = false;
			}
		}
	}

}
