import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260 {

	static ArrayList<Integer>[] nodeList;
	static StringBuilder sb;
	static boolean[] visit;
	static int N, M, V;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[N + 1];
		visit = new boolean[N + 1];
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
		sb = new StringBuilder();
		dfs(V);
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
	}
	
	public static void dfs(int start) {
		if(visit[start]) {
			return;
		}
		
		visit[start] = true;
		sb.append(start + " ");
		for(int i : nodeList[start]) {
			if(!visit[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] check = new boolean[N + 1];
		queue.offer(start);
		check[start] = true;
		
		while(!queue.isEmpty()) {
			int next = queue.poll();
			sb.append(next + " ");
			for(int i : nodeList[next]) {
				if(!check[i]) {
					queue.offer(i);
					check[i] = true;
				}
			}
		}
	}
	
	
}
