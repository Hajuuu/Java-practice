import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1167 {

	static ArrayList<Edge>[] nodeList;
	static boolean[] visit;
	static int max;
	static int node;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V = Integer.parseInt(br.readLine());
		
		nodeList = new ArrayList[V + 1];
		visit = new boolean[V + 1];
		
		for(int i = 1; i <= V; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			while(true) {
				int next = Integer.parseInt(st.nextToken());
				if(next == -1) {
					break;
				}
				int weight = Integer.parseInt(st.nextToken());
				nodeList[now].add(new Edge(next, weight));
			}
			
		}
		
		max = Integer.MIN_VALUE;
		DFS(1, 0);
		
		visit = new boolean[V + 1];
		DFS(node, 0);
		
		
		System.out.println(max);
	}
	
	public static void DFS(int u, int count) {
		if(count > max) {
			max = count;
			node = u;
		}
		visit[u] = true;
		
		for(Edge e: nodeList[u]) {
			int next = e.u;
			int weight = e.weight;
			
			if(!visit[next]) {
				visit[next] = true;
				DFS(next, count + weight);
			}
		}
	}
}

class Edge {
	int u;
	int weight;
	
	public Edge(int u, int weight) {
		this.u = u;
		this.weight = weight;
	}
}
	