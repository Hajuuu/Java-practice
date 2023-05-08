import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2252 {

	public static ArrayList<Integer>[] nodeList;
	public static int[] count;
	public static int[] check;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[N + 1];
		count = new int[N + 1];
		check = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodeList[a].add(b);
			count[b]++;
			check[b]++;
		}
		
		for(int i = 1; i <= N; i++) {
			if(count[i] == 0) {
				BFS(i);
			}
		}
		
		System.out.println(sb);
	}
	
	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now + " ");
			for(int i : nodeList[now]) {
				check[i]--;
				if(check[i] == 0) {
					queue.offer(i);
				}
			}
		}
	}

}
