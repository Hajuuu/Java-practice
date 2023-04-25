import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260 {

	static int N, M;
	static ArrayList<Integer>[] nodeList;
	static boolean[] isVisited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodeList[a].add(b);
			nodeList[b].add(a);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(nodeList[i]);
		}
		
		dfs(V);
		sb.append("\n");
		Arrays.fill(isVisited, false);
		bfs(V);
		System.out.println(sb);
		
	}
	
	public static void dfs(int V) {
		if(isVisited[V]) return;
		
		sb.append(V + " ");
		isVisited[V] = true;
		
		for(int i = 0; i < nodeList[V].size(); i++) {

			int cur = nodeList[V].get(i);
			if(!isVisited[cur]) {
				dfs(cur);
			}
		}
	}
	
	public static void bfs(int V) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(V);
		isVisited[V] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			sb.append(node + " ");
			
			for(int i = 0; i < nodeList[node].size(); i++) {
				int cur = nodeList[node].get(i);
				if(!isVisited[cur]) {
					q.add(cur);
					isVisited[cur] = true;
				}
			}
		}
	}

}
