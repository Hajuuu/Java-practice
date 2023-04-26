import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_13023 {

	static boolean[] visited;
	static ArrayList<Integer>[] nodeList;
	static boolean ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ans = false;
		visited = new boolean[N];
		nodeList = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodeList[a].add(b);
			nodeList[b].add(a);
		}
		
		for(int i = 0; i < N; i++) {
			dfs(i, 1);
			if(ans) {
				break;
			}
		}
		
		if(ans) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		
		
	}
	
	public static void dfs(int start, int depth) {
		if(depth == 5) {
			ans = true;
			return;
		}
		
		visited[start] = true;
		
		for(int i : nodeList[start]) {
			if(!visited[i]) {
				dfs(i, depth + 1);
			}
		}
		
		visited[start] = false;
		
	}
	

}
