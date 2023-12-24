import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1743 {

	static int[][] arr;
	static boolean[][] visit;
	static int N, M;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
		}
		
		int max = Integer.MIN_VALUE;
		int count = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(!visit[i][j]) {
					count = bfs(i, j);
				}
				max = Math.max(max, count);
			}
		}
		System.out.println(max);
	}
	
	public static int bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		int count = 0;
		while(!queue.isEmpty()) {
			int[] next = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = next[0] + dx[i];
				int nextY = next[1] + dy[i];
				if(nextX > 0 && nextX <= N && nextY > 0 && nextY <= M) {
					if(visit[nextX][nextY])
						continue;
					visit[nextX][nextY] = true;
					if(arr[nextX][nextY] == 1) {
						count++;
						queue.offer(new int[] {nextX, nextY});
					}
				}
			}
		}
		return count;
		
	}

}
