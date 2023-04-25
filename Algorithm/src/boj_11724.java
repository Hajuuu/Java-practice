import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11724 {

	static int N, M;
	static ArrayList<Integer>[] nodeList;
	static boolean[] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
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
		
		int components = 0;
		for(int i = 1; i <= N; i++) {
			if(!isVisited[i]) {
				dfs(i);
				components += 1;
			}
		}
		
		System.out.println(components);
	}
	
	public static void dfs(int start) {
		if(isVisited[start]) return;
		isVisited[start] = true;
		for(int i = 0; i < nodeList[start].size(); i++) {
			int cur = nodeList[start].get(i);
			if(!isVisited[cur]) {
				dfs(cur);
			}
		}
	}
	
//	public static void bfs(int start) {
//		Queue<Integer> q = new LinkedList<>();
//		q.add(start);
//		isVisited[start] = true;
//		while(!q.isEmpty()) {
//			int node = q.poll();
//			isVisited[node] = true;
//			for(int i = 0; i < nodeList[node].size(); i++) {
//				int cur = nodeList[node].get(i);
//				if(!isVisited[cur]) {
//					q.add(cur);
//				}
//			}
//		}
//	}

}
