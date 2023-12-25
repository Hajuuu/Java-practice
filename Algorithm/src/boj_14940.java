import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14940 {

	static int[][] arr;
	static int[][] count;
	static boolean[][] visit;
	static int N, M;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int startX = 0;
		int startY = 0;
		
		arr = new int[N][M];
		count = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 2) {
					startX = i;
					startY = j;
				}
				arr[i][j] = num;
				count[i][j] = -1;
			}
		}
		
		bfs(startX, startY);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					count[i][j] = 0;
				}
				sb.append(count[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	}
	
	public static void bfs(int startX, int startY) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startX, startY});
		count[startX][startY] = 0;
		visit[startX][startY] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if(visit[nextX][nextY])
						continue;
					if(arr[nextX][nextY] == 1) {
						count[nextX][nextY] = count[now[0]][now[1]] + 1;
						visit[nextX][nextY] = true;
						queue.offer(new int[] {nextX, nextY});
					}
				}
				
			}
		}
	}

}
