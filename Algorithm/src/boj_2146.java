import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2146 {

	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		arr = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int check = 2;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 1 && !visit[i][j]) {
					
					island(i, j, check);
					check++;
				}
			}
		}
		
		visit = new boolean[N][N];
		int answer = bfs(0, 0);
		
		System.out.println(answer);
	}
	
	public static void island(int x, int y, int check) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y, 0));
		visit[x][y] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
					if(!visit[nextX][nextY] && arr[nextX][nextY] == 1) {
						queue.offer(new Point(nextX, nextY, 0));
						arr[nextX][nextY] = check;
						visit[nextX][nextY] = true;
					}
				}
			}
		}
	}
	
	public static int bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		int count = Integer.MAX_VALUE;
		queue.offer(new Point(x, y, 0));
		visit[x][y] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
					if(visit[nextX][nextY]) continue;
					if(arr[p.x][p.y] > 0 && arr[nextX][nextY] == 0) {
						queue.offer(new Point(nextX, nextY, p.count + 1));
						visit[nextX][nextY] = true;
						continue;
					}
					if(arr[p.x][p.y] > 0 && arr[nextX][nextY] != arr[p.x][p.y] && p.count > 0) {
						count = Math.min(count, p.count);
						System.out.println(count);
					}
				}
			}
		}
		
		return count;
	}

}

class Point {
	int x;
	int y;
	int count;
	
	public Point(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
	
}
