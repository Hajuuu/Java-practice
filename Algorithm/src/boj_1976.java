import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1976 {

	static int[] parent;
	static int[][] city;
	static int[] route;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st;

		parent = new int[N + 1];
		city = new int[N + 1][N + 1];
		route = new int[M];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(city[i][j] == 1) {
					union(i, j);
				}
			}
		}
		
		int index = find(route[0]);
		for(int i = 1; i < M; i++) {
			if(index != find(route[i])) {
				System.out.println("NO\n");
				return;
			}
		}
		
		System.out.println("YES\n");
		
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			parent[b] = a;
		}
	}

	public static int find(int a) {
		if(a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
}
