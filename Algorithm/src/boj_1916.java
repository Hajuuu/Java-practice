import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1916 {
	
	static ArrayList<Bus>[] nodeList;
	static boolean[] visit;
	static int[] expense;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		nodeList = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		expense = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		Arrays.fill(expense, Integer.MAX_VALUE);
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			nodeList[s].add(new Bus(e, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		
		System.out.println(expense[end]);
 	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Bus> queue = new PriorityQueue<>();
		expense[start] = 0;
		queue.offer(new Bus(start, 0));
		
		while(!queue.isEmpty()) {
			Bus b = queue.poll();
			int v = b.num;
			if(visit[v]) continue;
			visit[v] = true;
			for(Bus i : nodeList[v]) {
				int next = i.num;
				int cost = i.cost;
				if(expense[next] > expense[v] + cost) {
					expense[next] = expense[v] + cost;
					queue.offer(new Bus(next, expense[next]));
				}
			}
		}
	}
	

}

class Bus implements Comparable<Bus> {
	int num;
	int cost;
	
	public Bus(int num, int cost) {
		this.num = num;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Bus b) {
		return this.cost - b.cost;
	}
}
