import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11724 {


	static ArrayList<Integer>[] nodeList;
	static int N, M;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		nodeList = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			nodeList[u].add(v);
			nodeList[v].add(u);
		}
		int count = 0;
		for(int i = 1; i <= N; i++) {
			if(!visit[i]) {
				bfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	
//	public static void dfs(int u) {
//		if(visit[u]) return;
//		visit[u] = true;
//		
//		for(int i : nodeList[u]) {
//			if(!visit[i]) {
//				dfs(i);
//			}
//		}
//	}
	
	public static void bfs(int u) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(u);
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for(int i : nodeList[v]) {
				if(!visit[i]) {
					queue.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}
