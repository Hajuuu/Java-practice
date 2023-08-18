import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14502 {

	static int[][] map;
	static int N, M;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] virusMap;
	static int max;
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
			}
		}
		
		max = Integer.MIN_VALUE;
		DFS(0);
		System.out.println(max);
	}
	
	public static void DFS(int depth) {
		if(depth == 3) {
			BFS();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					DFS(depth + 1);
					map[i][j] = 0;
				}
			}
 		}
	}
	
	public static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		virusMap = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				virusMap[i][j] = map[i][j];
				if(virusMap[i][j] == 2) {
					queue.offer(new int[] {i, j});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if(virusMap[nextX][nextY] == 0) {
						virusMap[nextX][nextY] = 2;
						queue.offer(new int[] {nextX, nextY});
					}
				}
			}
			
		}
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(virusMap[i][j] == 0) {
					count++;
				}
			}
		}
		
		max = Math.max(max, count);
	}

}
