import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1389 {

	static int N, M;
	static ArrayList<Integer>[] nodeList;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
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
		
		int[][] distance = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j || distance[i][j] != 0) continue;
				int count = bfs(i, j);
				distance[i][j] = count;
				distance[j][i] = count;
				visit = new boolean[N + 1];
			}
		}
		
		int answer = Integer.MAX_VALUE;
		int result = 0;
		for(int i = 1; i <= N; i++) {
			int sum = 0 ;
			for(int j = 1; j <= N; j++) {
				if(i == j) continue;
				sum += distance[i][j];
			}
			if(answer > sum) {
				answer = sum;
				result = i;
			}
		} 
		
		System.out.println(result);
	}
	
	public static int bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		int[] count = new int[N + 1];
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i : nodeList[now]) {
				if(!visit[i]) {
					queue.offer(i);
					visit[i] = true;
					count[i] = count[now] + 1;
				}
				if(i == end) {
					return count[i];
				}
			}
		}
		return 0;
	}

}
