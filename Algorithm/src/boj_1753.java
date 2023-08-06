import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1753 {

	static ArrayList<mNode>[] nodeList;
	static boolean[] visit;
	static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		nodeList = new ArrayList[V + 1];
		visit = new boolean[V + 1];
		distance = new int[V + 1];
		
		for(int i = 1; i <= V; i++) {
			nodeList[i] = new ArrayList<>();
		}
	
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			nodeList[u].add(new mNode(v, w));
			
		}
		dijkstra(K);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(distance[i] + "\n");
			}
		} 
		
		System.out.println(sb);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<mNode> queue = new PriorityQueue<>();
		distance[start] = 0;
		queue.offer(new mNode(start, 0));
		
		while(!queue.isEmpty()) {
			mNode n = queue.poll();
			int v = n.idx;
			if(visit[v]) continue;
			visit[v] = true;
			
			for(mNode i : nodeList[v]) {
				int next = i.idx;
				int weight = i.cost;
				if(distance[next] > distance[v] + weight) {
					distance[next] = distance[v]  + weight;
					queue.offer(new mNode(next, distance[next]));
				}
			}
		}
	}

	
}

class mNode implements Comparable<mNode> {
	int idx;
	int cost;
	
	public mNode(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(mNode o) {
		return this.cost - o.cost;
	}
}
