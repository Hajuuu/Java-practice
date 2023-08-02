import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_18352 {

	static ArrayList<Integer>[] nodeList;
	static boolean[] visit;
	static int[] count;
	static int K;
	static ArrayList<Integer> answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		count = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodeList[a].add(b);
		}
		answer = new ArrayList<>();
		
		bfs(X);
		Collections.sort(answer);
		for(int i : answer) {
			sb.append(i + "\n");
		}
		
		if(answer.size() == 0) {
			sb.append(-1);
		}
		System.out.println(sb);
	
		
	}
	
	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		
		visit[node] = true;
		queue.offer(node);
		while(!queue.isEmpty()) {
			int next = queue.poll();
			if(count[next] == K) {
				answer.add(next);
			}
			for(int i : nodeList[next]) {
				if(!visit[i]) {
					queue.offer(i);
					count[i] = count[next] + 1;
					visit[i] = true;
				}
			}
		}
	}
}
