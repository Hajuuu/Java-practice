import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_24445 {

	static ArrayList<Integer>[] nodeList;
	static boolean[] visit;
	static int[] answer;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		answer = new int[N + 1];
		
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
		
		for(int i = 1; i <= N; i++) {
			nodeList[i].sort(Comparator.reverseOrder());
		}
		BFS(R);
		
		for(int i = 1; i <= N; i++) {
			sb.append(answer[i] + "\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		visit[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			count++;
			answer[now] = count;
			for(int i : nodeList[now]) {
				if(!visit[i]) {
					visit[i] = true;
					queue.offer(i);
				}
			}
		}
	}

}
