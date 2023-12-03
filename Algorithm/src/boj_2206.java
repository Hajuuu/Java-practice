import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2206 {

	static int[][] arr;
	static boolean[][][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0u, -1, 0};
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1][2];
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			for(int j = 1; j <= M; j++) {
				arr[i][j] = str.charAt(j - 1) - '0';
			}
		}
		
		int answer = bfs();
		
		System.out.println(answer);
		
	}
	
	public static int bfs() {
		Queue<Count> queue = new ArrayDeque<>();
		queue.offer(new Count(1, 1, 1, false));
		while(!queue.isEmpty()) {
			Count now = queue.poll();
			if(now.x == N && now.y == M) {
				return now.count;
			}
			for(int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				if(nextX > 0 && nextX <= N && nextY > 0 && nextY <= M) {
					if(arr[nextX][nextY] == 0) {
						if(now.destroy && !visit[nextX][nextY][1]) {
							queue.offer(new Count(nextX, nextY, now.count + 1, now.destroy));
							visit[nextX][nextY][1] = true;
						}
						if(!now.destroy && !visit[nextX][nextY][0]) {
							queue.offer(new Count(nextX, nextY, now.count + 1, now.destroy));
							visit[nextX][nextY][0] = true;
						}
					}
					else if(arr[nextX][nextY] == 1) {
						if(!now.destroy && !visit[nextX][nextY][1]) {
							queue.offer(new Count(nextX, nextY, now.count + 1, true));
							visit[nextX][nextY][1] = true;
						}
					}
				}
			}
		}
		return -1;
	}

}

class Count {
	int x;
	int y;
	int count;
	boolean destroy;
	
	Count(int x, int y, int count, boolean destroy) {
		this.x = x;
		this.y = y;
		this.count = count;
		this.destroy = destroy;
	}
}
