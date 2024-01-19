import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16928 {

	static int[] dice = {1, 2, 3, 4, 5, 6};
	static ArrayList<Integer>[] nodeList;
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[101];
		count = new int[101];
		for(int i = 1; i < 101; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodeList[x].add(y);
		}
		
		bfs(1);
		System.out.println(count[100]);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i = 0; i < 6; i++) {
				int next = now + dice[i];
				if(next > 100) {
					continue;
				}
				if(nodeList[next].size() > 0) {
					if(count[nodeList[next].get(0)] == 0 || count[nodeList[next].get(0)] > count[now] + 1) {
						queue.offer(nodeList[next].get(0));
						count[nodeList[next].get(0)] = count[now] + 1;
						
					}
					continue;
					
				}
				if(count[next] > count[now] + 1 || count[next] == 0) {
					count[next] = count[now] + 1;
					queue.offer(next);
				}
					
			}
		}
	}
}