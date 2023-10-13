import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_13549 {

	static int N, K;
	static boolean[] visit;
	static int[] time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new boolean[100001];
		bfs();
		
	}
	
	public static void bfs() {
		PriorityQueue<Point2> queue = new PriorityQueue<>();
		queue.offer(new Point2(N, 0));
		while(!queue.isEmpty()) {
		
			Point2 point = queue.poll();
			int now = point.idx;
			int time = point.value;
			visit[now] = true;
			
			if(now == K) {
				System.out.println(time);
				return;
			}
			
			if(now - 1 >= 0) {
				if(!visit[now - 1]) {
					queue.offer(new Point2(now - 1, time + 1));
				}
				
			}
			if(now + 1 <= 100000) {
				if(!visit[now + 1]) {
					queue.offer(new Point2(now + 1, time + 1));
				}
				
			}
			if(now * 2 <= 100000) {
				if(!visit[now * 2]) {
					queue.offer(new Point2(now * 2, time));
				}
				
			}
			
			
		}
	}
		

}

class Point2 implements Comparable<Point2> {
	int idx;
	int value;
	
	public Point2(int idx, int value) {
		this.idx = idx;
		this.value = value;
	}
	
	@Override
	public int compareTo(Point2 p) {
		return this.value - p.value;
	}
}