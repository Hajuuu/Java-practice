import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1707 {

	static ArrayList<Integer>[] nodeList;
	static int[] color;
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < K; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			check = true;
			nodeList = new ArrayList[V + 1];
			color = new int[V + 1];
			
			for(int i = 1; i <= V; i++) {
				nodeList[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				nodeList[u].add(v);
				nodeList[v].add(u);
			}
			
			for(int i = 1; i <= V; i++) {
				if(color[i] == 0) {
					BFS(i, 1);
				}
			}
			
			if(check) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
	}
	
	
	public static void DFS(int node, int c) {
		color[node] = c;
		for(int i : nodeList[node]) {
			if(color[i] == color[node]) {
				check = false;
				return;
			}
			else {
				if(color[i] == 0) {
					DFS(i, -c);
				}
			}
		}
	}
	
	public static void BFS(int node, int c) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(node);
		color[node] = c;
		
		while(!queue.isEmpty()) {
			int next = queue.poll();
			c = color[next];
			for(int i : nodeList[next]) {
				if(color[i] == color[next]) {
					check = false;
					return;
				} else {
					if(color[i] == 0) {
						queue.offer(i);
						color[i] = -c;
					}
				}
			}
		}
	}
	
}
