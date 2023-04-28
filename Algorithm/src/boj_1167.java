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
	static int[] distance;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		nodeList = new ArrayList[N + 1];
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>(); 
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			while(true) {
				int E = Integer.parseInt(st.nextToken());
				if(E == -1) break;
				int V = Integer.parseInt(st.nextToken());
				nodeList[S].add(new Edge(E, V));
			}
		}
		
		BFS(1);
		int max = 1;
		for(int i = 2; i <= N; i++) {
			if(distance[i] > distance[max]) {
				max = i;
			}
		}
		
		visited = new boolean[N + 1];
		distance = new int[N + 1];
		BFS(max);
		Arrays.sort(distance);
		System.out.println(distance[N]);
		
	}
	
	public static void BFS(int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		visited[index] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(Edge i : nodeList[now]) {
				int e = i.e;
				int v = i.value;
				if(!visited[e]) {
					visited[e] = true;
					queue.add(e);
					distance[e] = distance[now] + v;
				}
			}
		}
	}

}

class Edge {
	int e;
	int value;
	public Edge(int e, int value) {
		this.e = e;
		this.value = value;
	}
}