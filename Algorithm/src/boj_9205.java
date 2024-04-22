import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_9205 {

	static ArrayList<Point9205> store;
	static int n;
	static int endX;
	static int endY;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			store = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				store.add(new Point9205(x, y));
			}
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			boolean check = bfs(startX, startY);
			if(check) {
				sb.append("happy\n");
			} else {
				sb.append("sad\n");
			}
		}
		System.out.println(sb);
		
	}
	
	public static boolean bfs(int startX, int startY) {
		Queue<Point9205> queue = new ArrayDeque<>();
		queue.offer(new Point9205(startX, startY));
		boolean[] visit = new boolean[n];
		while(!queue.isEmpty()) {
			Point9205 now = queue.poll();
			if(Math.abs(now.x - endX) + Math.abs(now.y - endY) <= 1000) {
				return true;
			}
			for(int i = 0; i < n; i++) {
				if(!visit[i]) {
					if(Math.abs(now.x - store.get(i).x) + Math.abs(now.y - store.get(i).y) <= 1000) {
						queue.offer(new Point9205(store.get(i).x, store.get(i).y));
						visit[i] = true;
					}
				}
			}
		}
		return false;
	}

	
}

class Point9205 {
	int x;
	int y;
	
	Point9205(int x, int y) {
		this.x = x;
		this.y = y;
	}
}