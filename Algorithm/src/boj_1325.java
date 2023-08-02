import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1325 {

	static ArrayList<Integer>[] nodeList;
	static boolean[] visit;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodeList[b].add(a);
		}
		
		int[] count = new int[N + 1];
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			visit = new boolean[N + 1];
			count[i] = bfs(i, 0);
			if(count[i] > max) {
				max = count[i];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(max == count[i]) {
				sb.append(i + " ");
			}
		}
		
		System.out.println(sb);
		
	}

	public static int bfs(int node, int depth) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(node);
		visit[node] = true;
		
		while(!queue.isEmpty()) {
			int next = queue.poll();
			
			for(int i : nodeList[next]) {
				if(!visit[i]) {
					queue.offer(i);
					visit[i] = true;
					depth++;
				}
			}
		}
		return depth;
	}

}
