import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1976 {

	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					union(i, j);
				}
			}
		}
		
		int[] travel = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			travel[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i < M; i++) {
			if(!find(travel[0], travel[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	public static int getParent(int num) {
		if(parent[num] == num) return num;
		return parent[num] = getParent(parent[num]);
	}
	
	public static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if(a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}
	
	public static boolean find(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a == b) {
			return true;
		} else {
			return false;
		}
	}
}
