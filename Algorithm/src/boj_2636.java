import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] map;
	static int N, M;
	static int cheeseCount = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cheeseCount++;
				}
				
			}
		}
		int time = 0;
		int cheese = 0;
		while(cheeseCount > 0) {
			cheese = cheeseCount;
			time++;
			bfs();
			
		}
		
		System.out.println(time);
		System.out.println(cheese);
	}
	
	public static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];
		queue.offer(new int[] {0, 0});
		visit[0][0] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || visit[nextX][nextY]) {
					continue;
				}
				visit[nextX][nextY] = true;
				if(map[nextX][nextY] == 1) {
					map[nextX][nextY] = 0;
					cheeseCount--;
				}
				else if(map[nextX][nextY] == 0) {
					queue.offer(new int[] {nextX, nextY});
				}
			}
		}
	}
	
}

