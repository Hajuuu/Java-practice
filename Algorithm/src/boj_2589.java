import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2589 {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] time;
	static char[][] maps;
	static boolean[][] visit;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maps = new char[N][M];
		time = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				maps[i][j] = str.charAt(j);
			}
		}
		int answer = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(maps[i][j] == 'L') {
					visit = new boolean[N][M];
					time = new int[N][M];
					
					answer = Math.max(answer, bfs(i, j));
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static int bfs(int start, int end) {
		Queue<int[]> queue = new ArrayDeque<>();
		int max = Integer.MIN_VALUE;
		queue.offer(new int[] {start, end});
		visit[start][end] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if(!visit[nextX][nextY] && maps[nextX][nextY] == 'L') {
						visit[nextX][nextY] = true;
						time[nextX][nextY] = time[now[0]][now[1]] + 1;
						max = Math.max(max, time[nextX][nextY]);
						queue.offer(new int[] {nextX, nextY});
					}
				}
			}
		}
		return max;
	}

}
