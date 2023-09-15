import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2644 {

	static ArrayList<Integer>[] nodeList;
	static boolean[] visit;
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		
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
			nodeList[b].add(a);
		}
		int answer = bfs(num1, num2);
		System.out.println(answer);
	}
	
	public static int bfs(int x, int y) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i : nodeList[now]) {
				if(!visit[i]) {
					count[i] = count[now] + 1;
 					visit[i] = true;
					queue.offer(i);
				}
				if(i == y) {
					return count[i];
				}
			}
		}
		
		return -1;
	}

}
