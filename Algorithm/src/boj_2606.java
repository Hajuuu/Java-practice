import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2606 {

	static ArrayList<Integer>[] nodeList;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
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
		
		BFS(1);
		int count = 0;
		for(int i = 2; i <= N; i++) {
			if(visit[i]) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	public static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(start);
		visit[start] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i : nodeList[now]) {
				if(!visit[i]) {
					visit[i] = true;
					queue.offer(i);
				}
			}
		}
	}

}
